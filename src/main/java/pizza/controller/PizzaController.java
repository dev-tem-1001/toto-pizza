package pizza.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import pizza.entity.Ingredient;
import pizza.entity.IngredientRef;
import pizza.entity.Pizza;
import pizza.entity.PizzaOrder;
import pizza.entity.dto.PizzaFormDto;
import pizza.repository.IngredientRepository;

import pizza.entity.Ingredient.Type;
import pizza.repository.PizzaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Controller

@SessionAttributes("pizzaOrder")
public class PizzaController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping("/custom")
    public String showForm(Model model) {
        //List<Ingredient> ingredients = ingredientRepository.findAll();

        //model.addAttribute("ingredients", ingredients);

        return "custom";
    }

    @PostMapping("/custom")
    public String processPizzaCustom(@Valid PizzaFormDto pizzaForm,
                                     Errors errors,
                                     @ModelAttribute PizzaOrder pizzaOrder) { // это метод нужный для обработки данных из формы

        if (errors.hasErrors()) {
            return "custom";
        }

        Pizza pizza = createPizzaFromDto(pizzaForm);

        //pizza = pizzaRepository.save(pizza);
        pizza = pizzaRepository.save(pizza);

        pizzaOrder.addPizza(pizza); // это метод для добавления taco в заказ

        return "redirect:/order";
    }

    private Pizza createPizzaFromDto(PizzaFormDto dto) {
        Pizza pizza = new Pizza();
        pizza.setName(dto.getName());

        for (String ingredientId : dto.getIngredientIds()) {
            Ingredient ingredient = ingredientRepository.findById(ingredientId)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid ingredient ID: " + ingredientId));

            pizza.addIngredient(ingredient);

        }

        BigDecimal totalPrice = BigDecimal.ZERO;
        int totalTime = 0;

        for (IngredientRef ingredientRef : pizza.getIngredients()) {
            totalPrice = totalPrice.add(ingredientRef.getPrice()); // СУММИРУЕМ
            totalTime += ingredientRef.getPreparationTime(); // СУММИРУЕМ
        }

        pizza.setPrice(totalPrice);
        pizza.setPreparationTime(totalTime);

        return pizza;
    }

    @ModelAttribute
    public void addIngredientsModel(Model model) {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "pizzaForm")
    public PizzaFormDto pizzaForm() {
        return new PizzaFormDto();
    }

    // это метод для фильтрации ингредиентов по типу
    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream() // это метод для преобразования списка в поток
                .filter(x -> x.getType().equals(type)) // это метод для фильтрации по типу ингредиента (в данном случае по типу WRAP)
                .collect(Collectors.toList()); // это метод для преобразования потока в список и возврата его в метод filterByType
    }
}
