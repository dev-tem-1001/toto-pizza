package pizza.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import pizza.entity.Pizza;
import pizza.entity.PizzaOrder;
import pizza.repository.PizzaOrderRepository;
import pizza.repository.PizzaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
//@RequestMapping("/order")
@SessionAttributes("pizzaOrder")
public class PizzaOrderController {

    @Autowired
    private PizzaOrderRepository pizzaOrderRepository;

    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping("/order")
    public String order(@ModelAttribute PizzaOrder pizzaOrder,
                        Model model) {

        List<Pizza> pizzas = pizzaOrder.getPizzaIds().stream()
                .map(id -> pizzaRepository.findById(id).orElseThrow())
                .collect(Collectors.toList());
        // Расчет итоговой стоимости заказа
        // и времени готовки
        BigDecimal total = BigDecimal.ZERO;
        int time = 0;

        for (Pizza pizza : pizzas) {
            total = total.add(pizza.getPrice());
            time = time + pizza.getPreparationTime();
        }

        pizzaOrder.setTotalPrice(total);
        pizzaOrder.setPreparationTime(time);

        model.addAttribute("pizzas", pizzas); // Передаем эту переменную в html страницу, как посылку
        model.addAttribute("pizzaOrder", pizzaOrder);

        return "order"; // вернет order.html
    }

    @PostMapping("/order")
    public String processOrder(@Valid PizzaOrder order, Errors errors) {
        if (errors.hasErrors()) {
            return "menu";
        }

        pizzaOrderRepository.save(order);

        log.info("Order submitted: {}", order); // эта строка для логирования

        return "redirect:/final"; // перенаправление на
    }
}
