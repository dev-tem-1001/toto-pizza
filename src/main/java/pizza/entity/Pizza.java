package pizza.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// @Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=5, message="Имя должно состоять как минимум из 5 символов")
    private String name; // название пиццы

    @NotNull
    @Column(precision = 10, scale = 2)
    private BigDecimal price; // цена пиццы

    @ElementCollection
    @CollectionTable( // разобрать эти моменты
            name = "pizza_ingredients",
            joinColumns = @JoinColumn(name = "pizza_id")
    )
    @Size(min=1, message="Вы должны выбрать хотя бы один ингредиент")
    private List<IngredientRef> ingredients = new ArrayList<>(); // список ингредиентов

    @CreationTimestamp
    private LocalDateTime createdAt = LocalDateTime.now(); // дата создания пиццы

    @NotNull
    private int preparationTime; // примерное время готовки пиццы

    private String imageUrl; // путь к соответствующему изображению пиццы

    public void addIngredient(Ingredient ingredient) {

        for (IngredientRef ingredientRef: ingredients) {
            // Если ингредиент с таким id есть в пицце, то просто суммируем их ->
            if (ingredientRef.getIngredientId().equals(ingredient.getId())) {
                ingredientRef.setQuantity(ingredientRef.getQuantity() + 1);
                ingredientRef.setPreparationTime(ingredientTime(ingredientRef, ingredient));
                ingredientRef.setPrice(ingredientPrice(ingredient, ingredientRef.getQuantity()));
                return;
            }
        }
        // Если нету такого ингредиента, то добавляем как новый
        IngredientRef ingredientRef = new IngredientRef();

        ingredientRef.setIngredientId(ingredient.getId());
        ingredientRef.setName(ingredient.getName());
        ingredientRef.setType(ingredient.getType());
        ingredientRef.setPreparationTime(ingredient.getPreparationTime());
        ingredientRef.setPrice(ingredient.getPrice());

        this.ingredients.add(ingredientRef);
    }

    // Функция которая будет плюсовать цену чтобы не была цена за 6 пицц как за 1 пиццу
    // Саам решуу :D
    public BigDecimal ingredientPrice(Ingredient ingredient, int quantity) {
        return ingredient.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    // просто плюсуем время ингредиента
    public int ingredientTime(IngredientRef ingredientRef, Ingredient ingredient) {
        return ingredientRef.getPreparationTime() + ingredient.getPreparationTime();
    }

    // для отображения пути с картинкой пиццы (из за кастомных)
    public String getImageUrl() {
        return imageUrl != null ? imageUrl : "/images/pizza.png";
    }
}
