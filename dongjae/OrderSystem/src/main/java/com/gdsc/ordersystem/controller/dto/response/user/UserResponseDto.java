package com.gdsc.ordersystem.controller.dto.response.user;

import com.gdsc.ordersystem.domain.user.UserType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class UserResponseDto {

    private Long userId;
    private String name;
    private String email;
    private UserType userType;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public static UserResponseDto of(Long id, String name, String email, UserType userType, LocalDateTime createAt, LocalDateTime updateAt) {
        return new UserResponseDto(id, name, email, userType, createAt, updateAt);
    }

}
