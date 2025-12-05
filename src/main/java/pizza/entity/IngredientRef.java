package pizza.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class IngredientRef {

    @ManyToOne
    private Ingredient ingredient;

    private int quantity = 1;    // 1, 2, 3...

}

