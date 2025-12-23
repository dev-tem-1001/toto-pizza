package pizza.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
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
public class PizzaRef {

    //@ManyToOne
    //private Pizza pizza;

    private Long pizzaId;

    private String pizzaName;

    private int pizzaPreparationTime;

    @Column(precision = 10, scale = 2)
    private BigDecimal pizzaPrice;

    private int quantity = 1;

}
