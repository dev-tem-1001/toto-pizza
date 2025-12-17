package pizza.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import pizza.entity.PizzaOrder;
import pizza.repository.PizzaOrderRepository;

@Slf4j
@Controller
//@RequestMapping("/order")
//@SessionAttributes("pizzaOrder")
public class PizzaOrderController {

    private PizzaOrderRepository pizzaOrderRepository;

    @GetMapping("/order")
    public String order(@ModelAttribute PizzaOrder pizzaOrder,
                        Model model) {
        return "order"; // вернет order.html
    }

    @PostMapping
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
