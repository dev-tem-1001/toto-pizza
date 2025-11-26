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
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public void addIngredient(IngredientRef ingredient) {
        this.ingredients.add(ingredient);
    }


}
