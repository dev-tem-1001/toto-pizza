package pizza.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PizzaOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Введите название заказа")
    private String name; // Название заказа

    @NotNull
    @OneToMany(cascade = CascadeType.ALL)
    private List<Pizza> pizzas = new ArrayList<>(); // список заказов

    @NotNull
    private LocalDateTime createdAt; // дата создания

    @NotNull
    private int preparationTime; // общее время готовки

    @NotNull
    @Column(precision = 10, scale = 2)
    private BigDecimal totalPrice; // Цена за весь заказ

    @NotBlank(message="Введите название города")
    private String deliveryCity;

    @NotBlank(message = "Введите улицу")
    private String deliveryStreet;

    @NotBlank(message = "Введите номер дома")
    private String deliveryHouseNumber;

    @NotBlank(message="Введите номер квартиры")
    private String deliveryFlat;

    public void addPizza(Pizza pizza) {
        this.pizzas.add(pizza);
    }

}
