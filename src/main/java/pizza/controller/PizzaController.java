package pizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import pizza.entity.Ingredient;
import pizza.repository.IngredientRepository;
import pizza.repository.PizzaRepository;

import java.util.List;

@Controller

@SessionAttributes("pizzaOrder")
public class PizzaController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping("/custom")
    public String menu(Model model) {
        List<Ingredient> ingredients = ingredientRepository.findAll();

        model.addAttribute("ingredients", ingredients);

        return "custom";
    }
}
