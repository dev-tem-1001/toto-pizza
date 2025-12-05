package pizza.server.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pizza.entity.Ingredient;
import pizza.entity.Pizza;
import pizza.entity.PizzaOrder;
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

    @PostMapping
    public String processTaco(@Valid Pizza pizza, Errors errors,
                              @ModelAttribute PizzaOrder pizzaOrder) { // это метод нужный для обработки данных из формы
        if (errors.hasErrors()) {
            return "menu";
        }
        pizzaOrder.addPizza(pizza); // это метод для добавления тaco в заказ

        return "redirect:/order"; // префикс "redirect:", сообщающий,
        // что это представление с перенаправлением, то есть после завершения processTaco()
        // браузер пользователя должен открыть другую страницу, отправив запрос GET с путем /orders/current.
    }

}
