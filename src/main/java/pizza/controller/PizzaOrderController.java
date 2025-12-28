package pizza.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import pizza.entity.PizzaOrder;
import pizza.entity.PizzaRef;
import pizza.repository.PizzaOrderRepository;
import pizza.repository.PizzaRepository;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/order")
@SessionAttributes("pizzaOrder")
public class PizzaOrderController {

    @Autowired
    private PizzaOrderRepository pizzaOrderRepository;

    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping
    public String showOrder(@ModelAttribute PizzaOrder pizzaOrder,
                        Model model) {

        List<PizzaRef> pizzas = pizzaOrder.getPizzas();

        BigDecimal total = BigDecimal.ZERO;
        int time = 0;

        for (PizzaRef pizza : pizzas) {
            total = total.add(pizza.getPizzaPrice());
            time = time + pizza.getPizzaPreparationTime();
        }

        pizzaOrder.setTotalPrice(total);
        pizzaOrder.setPreparationTime(time);

        model.addAttribute("pizzas", pizzas); // Передаем эту переменную в html страницу, как посылку
        model.addAttribute("pizzaOrder", pizzaOrder);

        return "order";
    }

    @PostMapping
    public String processOrder(@Valid PizzaOrder order, Errors errors) {

        if (errors.hasErrors()) {
            return "menu";
        }

        pizzaOrderRepository.save(order);

        //log.info("Order submitted: {}", order); // для логирования

        return "redirect:/order/final"; // перенаправление на
    }
}
