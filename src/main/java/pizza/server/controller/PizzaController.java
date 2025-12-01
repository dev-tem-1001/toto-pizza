package pizza.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pizza.repository.PizzaRepository;

@Controller
public class PizzaController {

    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping("/custom")
    public String menu(Model model) {
        model.addAttribute("pizzas", pizzaRepository.findAll());
        return "custom";
    }
}
