package com.example.jpa3.domain;

import com.example.jpa3.dto.CustomerDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "CUSTOMER_ID")
    Integer id;

    @Column(name = "CUSTOMER_NAME")
    String name;

    @Column(name = "CUSTOMER_AGE")
    int age;

    @Column(name = "CUSTOMER_SEX")
    String sex;

    public CustomerDto toDto(){
        return CustomerDto.builder()
                .id(this.id)
                .name(this.name)
                .age(this.age)
                .sex(this.sex)
                .build();
    }

    public void update(Customer customer){
        this.id = customer.id;
        this.name = customer.name;
        this.age = customer.age;
        this.sex = customer.sex;
    }
}