package com.example.orderitem.member.dto;

import com.example.orderitem.domain.Address;
import com.example.orderitem.domain.Delivery;
import com.example.orderitem.domain.Member;
import jakarta.validation.constraints.NotBlank;

public record AddMemberRequest(
        @NotBlank
        String name,
        @NotBlank
        String city,
        @NotBlank
        String street,
        @NotBlank
        String zipcode
) {
        public Member toEntity() {
                return Member.builder()
                        .name(this.name)
                        .address(Address.builder().city(this.city).street(this.street).zipcode(this.zipcode).build())
                        .build();
        }
}
