package com.example.itemcustomerdjpa.repository;

import com.example.itemcustomerdjpa.domain.Customer;
import com.example.itemcustomerdjpa.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    Optional<Item> findByName(String name);
}
