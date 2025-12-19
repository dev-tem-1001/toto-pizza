package pizza.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

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
    private String deliveryName; // Название заказа

    @NotNull
    //@ManyToMany(cascade = CascadeType.ALL)
    @ElementCollection
    private List<Long> pizzaIds = new ArrayList<>(); // список заказов

    @CreationTimestamp
    private LocalDateTime createdAt = LocalDateTime.now(); // дата создания

    @NotNull
    private int preparationTime; // общее время готовки

    @NotNull
    @Column(precision = 10, scale = 2)
    private BigDecimal totalPrice; // Цена за весь заказ

    @NotBlank(message="Введите название города")
    private String deliveryCity;

    @NotBlank(message = "Введите улицу")
    private String deliveryStreet;

    @NotNull(message = "Введите номер дома")
    private int deliveryHouseNumber;

    @NotNull(message="Введите номер квартиры")
    private int deliveryFlat;

    public void addPizza(Pizza pizza) {
        this.pizzaIds.add(pizza.getId());
    }

}
