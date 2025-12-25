package pizza.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PizzaFormDto {

    @NotBlank(message = "Название обязательно")
    @Size(min = 5, message = "Минимум 5 символов")
    private String name;

    @Size(min = 3, message = "Выберите хотя бы 3 ингредиентa")
    private List<String> ingredientIds = new ArrayList<>();
}
