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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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


    @NotNull(message = "Список пицц не может быть нулевым")
    @ElementCollection
    private List<PizzaRef> pizzas = new ArrayList<>(); // список заказов

    @CreationTimestamp
    private LocalDateTime createdAt = LocalDateTime.now(); // дата создания

    private LocalDateTime finalAt = LocalDateTime.now(); // готовый заказ

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

    // Метод, добавляющий пиццу в заказ
    public void addPizza(Pizza pizza) {

        for (PizzaRef pizzaRef: pizzas) {
            // Если пицца с таким id есть в заказе, то ->
            if (pizzaRef.getPizzaId().equals(pizza.getId())) {
                pizzaRef.setQuantity(pizzaRef.getQuantity() + 1);
                pizzaRef.setPizzaPreparationTime(pizzaRef.getPizzaPreparationTime() + pizza.getPreparationTime());
                pizzaRef.setPizzaPrice(pizzaPrice(pizza, pizzaRef.getQuantity()));
                return;
            }
        }
        // Если нету такой пиццы, то создаем ее
        PizzaRef newPizza = new PizzaRef();

        newPizza.setPizzaId(pizza.getId());
        newPizza.setPizzaName(pizza.getName());
        newPizza.setPizzaPreparationTime(pizza.getPreparationTime());
        newPizza.setPizzaPrice(pizza.getPrice());

        pizzas.add(newPizza);
    }

    // Функция которая будет плюсовать цену чтобы не была цена за 6 пицц как за 1 пиццу
    // Саам решуу :D
    public BigDecimal pizzaPrice(Pizza pizza, int quantity) {
        return pizza.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    // Получаем время готовности заказа
    public LocalDateTime getReadyTime() {
        return createdAt.plusMinutes(preparationTime);
    }

    public String getFormattedReadyTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return getReadyTime().format(formatter);
    }
}
