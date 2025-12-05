package pizza.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PizzaOrderController {

    @GetMapping("/order")
    public String showOrder() {
        return "order"; // вернет order.html
    }

}
