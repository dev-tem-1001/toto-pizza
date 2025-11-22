package pizza.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

// @Data не стоит использовать для сущностей, тк может вызывать проблемы с производительностью

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotNull
    private String name;

    @Enumerated(EnumType.STRING)
    private Type type; // Тип ингредиента

    @NotNull
    private int preparationTime; // минуты

    @NotNull
    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    enum Type {
        DOUGH, MEAT, VEGETABLES, SAUCE
    }
    // Как только будем добавляеть ингредиенты, просто будем перечислять их в data.sql,
    // а уже с БД будем брать ингредиенты для готовых рецептов пицц
}
