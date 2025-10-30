package pizza.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Ingredient {

    @Id
    private Long id;
    private String name;
    private Meat meat;
    private Vegetables vegetables;
    private Sauce sauce;

    public enum Meat {
        CHICKEN, SAUSAGES, SHRIMP, HAM, BACON;
    } // Мясо

    public enum Vegetables {
        TOMATOES, CUCUMBERS, GARLIC, SWEET_PEPPERS, RED_ONION, PINEAPPLES, CHAMPIGNONS, MOZZARELLA;
    } // Овощи

    public enum Sauce {
        SIGNATURE_TOMATO, SAUCE_ALFREDOS_SIGNATURE;
    } // Соусы
}
