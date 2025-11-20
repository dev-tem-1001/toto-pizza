package pizza.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pizza.entity.PizzaOrder;

public interface PizzaOrderRepository extends JpaRepository<PizzaOrder, Long> {
}
