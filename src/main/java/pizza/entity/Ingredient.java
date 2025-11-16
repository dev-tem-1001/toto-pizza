package pizza.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


// @Data не стоит использовать для сущностей, тк может вызывать проблемы с производительностью

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ingredient {

    @Id
    private Long id;
    private String name;
    private Dough dough; // Тесто
    private Sauce sauce; // Соус
    private List<Meat> meat = new ArrayList<>(); // Мясо
    private List<Vegetables> vegetables = new ArrayList<>(); // Овощи

    enum Dough {
        SUBTLE, TRADITIONAL
    }

    enum Sauce {
        SIGNATURE_TOMATO, SAUCE_ALFREDOS_SIGNATURE;
    }

    enum Meat {
        CHICKEN, SAUSAGES, SHRIMP, HAM, BACON;
    }

    enum Vegetables {
        TOMATOES, CUCUMBERS, GARLIC, SWEET_PEPPERS, RED_ONION, PINEAPPLES, CHAMPIGNONS;
    }




}
