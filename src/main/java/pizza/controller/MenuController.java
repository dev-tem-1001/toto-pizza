package pizza.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pizza.entity.Pizza;
import pizza.entity.PizzaOrder;
import pizza.repository.PizzaRepository;

import java.util.List;

@Slf4j
@Controller
//@RequestMapping("/")
//@SessionAttributes("pizzaOrder")
public class MenuController {

    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping("/menu")
    public String menu(Model model) {
        List<Pizza> pizzas = pizzaRepository.findAll(); // Получаем список всех пицц

        model.addAttribute("pizzas", pizzas); // Передаем эту переменную в html страницу, как посылку

        return "menu";
    }

    // 2. ОБРАБОТКА формы (POST запрос)

    @PostMapping("/menu")
    public String processPizza(
            @RequestParam("pizzaId") Long pizzaId,          // Данные из формы → объект Taco
            @ModelAttribute PizzaOrder pizzaOrder) { // Заказ из сессии

        Pizza pizza = pizzaRepository.findById(pizzaId)
                .orElseThrow(() -> new IllegalArgumentException("Пицца не найдена"));

        pizzaOrder.addPizza(pizza);

        // Добавляем taco в заказ

        // Перенаправляем на следующую страницу
        return "redirect:/order";
    }



}


