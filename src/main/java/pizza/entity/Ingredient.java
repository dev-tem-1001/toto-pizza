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
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @NotNull
    @Column(precision = 10)
    private String name;

    private Type type;

    @NotNull
    private int preparationTime; // минуты

    @NotNull
    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    public enum Type {
        DOUGH, MEAT, VEGGIES, SAUCE
    }
}
