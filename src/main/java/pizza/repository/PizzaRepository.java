package pizza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pizza.entity.Pizza;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {

}
