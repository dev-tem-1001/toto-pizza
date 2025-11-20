package pizza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pizza.entity.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {
}
