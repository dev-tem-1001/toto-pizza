package pizza.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class IngredientRef {

    private String ingredientId;

    @Column(precision = 10)
    private String name;

    private Ingredient.Type type; // Тип ингредиента

    private int preparationTime; // минуты

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    private int quantity = 1;    // 1, 2, 3...

}

