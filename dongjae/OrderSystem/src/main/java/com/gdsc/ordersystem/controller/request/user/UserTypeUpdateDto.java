package com.gdsc.ordersystem.controller.request.user;

import com.gdsc.ordersystem.domain.user.UserType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserTypeUpdateDto {
    @NotNull
    private UserType userType;
}
