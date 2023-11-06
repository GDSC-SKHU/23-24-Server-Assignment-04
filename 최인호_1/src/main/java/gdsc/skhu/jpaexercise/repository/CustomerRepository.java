package gdsc.skhu.jpaexercise.repository;

import gdsc.skhu.jpaexercise.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
