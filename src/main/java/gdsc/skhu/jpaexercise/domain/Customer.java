package gdsc.skhu.jpaexercise.domain;

import gdsc.skhu.jpaexercise.dto.CustomerDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;

    @Column(name = "customer_name")
    private String name;

    @Column(name = "customer_age")
    private Integer age;


    public CustomerDto toDto() {
        return CustomerDto.builder()
                .id(this.id)
                .name(this.name)
                .age(this.age)
                .build();
    }

    public void update(Customer customer) {
        this.name = customer.name;
        this.age = customer.age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        if(age<0){
            throw new IllegalArgumentException("나이는 0보다 작을 수 없습니다.");
        }
        this.age = age;
    }
}




