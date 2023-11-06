package com.example.orderitem.member.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateMemberRequest(
        @NotBlank
        String name,
        @NotBlank
        String city,
        @NotBlank
        String street,
        @NotBlank
        String zipcode
) {
}
