package com.example.shoppingmall.repository;

import com.example.shoppingmall.domain.Customer;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findCustomerByName(String customerName);
    // Optional<T> 클래스: NullPointerException 방지, null이 올 수 있는 값을 감싸는 Wrapper 클래스
}
// JpaRepository의 제네릭 타입 Customer는 엔티티 클래스, Integer는 해당 엔티티의 기본 키 (Primary Key)의 데이터 타입