package pizza.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // аннотация для указания пути к контроллеру
    public String home() {
        return "home";
    }

}
