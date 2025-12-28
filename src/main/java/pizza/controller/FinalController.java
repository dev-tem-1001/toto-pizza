package pizza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import pizza.entity.PizzaOrder;
import pizza.entity.PizzaRef;

import java.util.List;

@Controller
@RequestMapping("/order/final")
@SessionAttributes("pizzaOrder")
public class FinalController {

    @GetMapping
    public String showFinalPage(@ModelAttribute PizzaOrder pizzaOrder,
                                Model model) {

        long orderNumber = pizzaOrder.getId();

        model.addAttribute("orderNumber", orderNumber);
        model.addAttribute("orderName", pizzaOrder.getDeliveryName());
        model.addAttribute("preparationTime", pizzaOrder.getReadyTime());
        model.addAttribute("finalAt", pizzaOrder.getFormattedReadyTime());


        List<PizzaRef> pizzas = pizzaOrder.getPizzas();
        model.addAttribute("pizzas", pizzas);

        // Очищаем сессию
        model.addAttribute("pizzaOrder", new PizzaOrder());

        return "final";
    }
}
