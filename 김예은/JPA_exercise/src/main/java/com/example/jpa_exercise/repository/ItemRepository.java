package com.example.jpa_exercise.repository;


import java.util.Optional;

import com.example.jpa_exercise.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    Optional<Item> findItemByName(String itemname);
}
