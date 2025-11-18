package pizza.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
    private String name;

    @NotNull
    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    @ManyToMany
    @Size(min=1, message="Вы должны выбрать хотя бы один ингредиент")
    private List<Ingredient> ingredients;

    private LocalDateTime createdAt;

    @NotNull
    private int preparationTime;

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
}
