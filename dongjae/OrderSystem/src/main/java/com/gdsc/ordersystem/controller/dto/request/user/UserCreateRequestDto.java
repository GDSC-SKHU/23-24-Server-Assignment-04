package com.gdsc.ordersystem.controller.dto.request.user;

import com.gdsc.ordersystem.domain.user.User;
import com.gdsc.ordersystem.domain.user.UserType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequestDto {

    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotNull
    private UserType userType;

    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .userType(userType)
                .build();
    }
}
