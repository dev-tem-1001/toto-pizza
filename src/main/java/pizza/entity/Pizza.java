package pizza.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;

// @Data

@Entity
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;

    @NotNull
    private int price;

    @ManyToMany
    @Size(min=1, message="You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;

    private Date createAt;

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }
}
