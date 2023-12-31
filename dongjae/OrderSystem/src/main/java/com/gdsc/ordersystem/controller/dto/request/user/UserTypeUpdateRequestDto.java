package com.gdsc.ordersystem.controller.dto.request.user;

import com.gdsc.ordersystem.domain.user.UserType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserTypeUpdateRequestDto {
    @NotNull
    private UserType userType;
}
