package pizza.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class PizzaOrder {

    @Id
    private Long id; // заказ номер 11 ...

    private String name; // введите имя пользователя

    private List<Pizza> pizzas = new ArrayList<>();

    private Date createAt;

}
