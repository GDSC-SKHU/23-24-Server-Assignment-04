package com.gdsc.ordersystem.controller.dto.request.user;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserNameUpdateRequestDto {
    @NotBlank
    private String name;
}
