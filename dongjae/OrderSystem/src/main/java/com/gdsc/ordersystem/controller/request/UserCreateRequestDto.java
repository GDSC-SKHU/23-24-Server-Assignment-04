package com.gdsc.ordersystem.controller.request;

import com.gdsc.ordersystem.domain.user.User;
import com.gdsc.ordersystem.domain.user.UserType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserCreateRequestDto {

    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotNull
    private UserType userType;

    @Builder
    public UserCreateRequestDto(String name, String email, UserType userType) {
        this.name = name;
        this.email = email;
        this.userType = userType;
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .userType(userType)
                .build();
    }
}
