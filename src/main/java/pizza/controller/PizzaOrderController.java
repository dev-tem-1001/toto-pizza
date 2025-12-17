package pizza.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import pizza.entity.Pizza;
import pizza.entity.PizzaOrder;
import pizza.repository.PizzaOrderRepository;

import java.util.List;

@Slf4j
@Controller
//@RequestMapping("/order")
@SessionAttributes("pizzaOrder")
public class PizzaOrderController {

    private PizzaOrderRepository pizzaOrderRepository;

    @GetMapping("/order")
    public String order(@ModelAttribute PizzaOrder pizzaOrder,
                        Model model) {

        List<Pizza> pizzas = pizzaOrder.getPizzas(); // Получаем список всех пицц

        model.addAttribute("pizzas", pizzas); // Передаем эту переменную в html страницу, как посылку

        return "order"; // вернет order.html
    }

    @PostMapping("/order")
    public String processOrder(@Valid PizzaOrder order, Errors errors,
                               SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "menu";
        }

        pizzaOrderRepository.save(order);

        log.info("Order submitted: {}", order); // эта строка для логирования
        sessionStatus.setComplete();

        return "redirect:/adminPanel"; // перенаправление на
    }
}
