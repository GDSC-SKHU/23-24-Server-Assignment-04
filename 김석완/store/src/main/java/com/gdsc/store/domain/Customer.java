package com.gdsc.store.domain;

import com.gdsc.store.dto.CustomerDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "CUSTOMER_ID")
    private int id;
    @Column(name = "CUSTOMER_NAME")
    private String name;
    @Column(name = "CUSTOMER_ADDRESS")
    private String address;


    public CustomerDto toDto() {
        return CustomerDto.builder()
                .id(this.id)
                .name(this.name)
                .address(this.address)
                .build();
    }

    public void update(Customer customer) {
        this.id = customer.id;
        this.name = customer.name;
        this.address = customer.address;
        ;
    }

    public int getId() {
        return this.id;
    }
}
