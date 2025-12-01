package pizza.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pizza.entity.Pizza;
import pizza.repository.PizzaRepository;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping("/")
    public String menu(Model model) {
        List<Pizza> allPizzas = pizzaRepository.findAll();
        model.addAttribute("pizzas", allPizzas);
        return "menu";
    }

}
