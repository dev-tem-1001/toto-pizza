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
    private Long id; // заказ номер 11 ...

    @NotBlank(message="Введите название заказа")
    private String name;

    @NotNull
    @OneToMany(cascade = CascadeType.ALL)
    private List<Pizza> pizzas = new ArrayList<>();

    @NotNull
    private LocalDateTime createdAt;

    @NotNull
    private int preparationTime;

    @NotNull
    @Column(precision = 10, scale = 2)
    private BigDecimal totalPrice;

    @NotBlank(message="Введите название города")
    private String deliveryCity;

    @NotBlank(message = "Введите улицу")
    private String deliveryStreet;

    @NotBlank(message = "Введите номер дома")
    private String deliveryHouseNumber;

    @NotBlank(message="Введите номер квартиры")
    private String deliveryFlat;

}
