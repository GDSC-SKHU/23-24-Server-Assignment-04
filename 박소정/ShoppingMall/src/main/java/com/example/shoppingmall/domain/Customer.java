package com.example.shoppingmall.domain;

import com.example.shoppingmall.dto.CustomerDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity // 테이블과 매핑, @Entity가 붙은 클래스는 JPA가 관리
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id // 기본키 지정, @GeneratedValue 없으면 직접 할당
    @GeneratedValue // 기본키 자동 생성(데이터베이스에게 위임)
    @Column(name = "CUSTOMER_ID") // 객체 필드를 테이블의 컬럼에 매핑
    private Integer id;

    @Column(name = "CUSTOMER_NAME", nullable = false) // DDL 생성 시 null 값의 허용 여부 결정, false로 설정 시 not null 제약조건
    private String name;

    @Column(name = "CUSTOMER_PHONE", nullable = false)
    private String phoneNumber;

    @Column(name = "CUSTOMER_ADDRESS", nullable = false)
    private String address;

    public CustomerDto toDto() {
        return CustomerDto.builder()
                .id(this.id)
                .name(this.name)
                .phoneNumber(this.phoneNumber)
                .address(this.address)
                .build();
    }

    public void update(Customer customer) {
        this.id = customer.id;
        this.name = customer.name;
        this.phoneNumber = customer.phoneNumber;
        this.address = customer.address;
    }
}
