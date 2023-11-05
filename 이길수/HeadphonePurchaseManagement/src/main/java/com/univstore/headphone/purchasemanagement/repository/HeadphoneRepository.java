package com.univstore.headphone.purchasemanagement.repository;

import com.univstore.headphone.purchasemanagement.domain.Headphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeadphoneRepository extends JpaRepository<Headphone, Integer> {
    Optional<Headphone> findHeadphoneByName(String productName);
}
