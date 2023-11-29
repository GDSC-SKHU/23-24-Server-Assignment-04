package gdsc.skhu.jpaexercise.repository;

import gdsc.skhu.jpaexercise.domain.Customer;
import gdsc.skhu.jpaexercise.dto.CustomerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    Optional<Customer> findByName(String name);
}
