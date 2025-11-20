package pizza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pizza.entity.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, String> {
}
