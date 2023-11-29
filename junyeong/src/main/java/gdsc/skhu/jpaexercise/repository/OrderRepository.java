package gdsc.skhu.jpaexercise.repository;

import gdsc.skhu.jpaexercise.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
