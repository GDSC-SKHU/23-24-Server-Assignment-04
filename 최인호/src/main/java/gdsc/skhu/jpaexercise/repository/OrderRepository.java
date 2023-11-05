package gdsc.skhu.jpaexercise.repository;

import gdsc.skhu.jpaexercise.domain.Customer;
import gdsc.skhu.jpaexercise.domain.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomer(Customer customer);
}
