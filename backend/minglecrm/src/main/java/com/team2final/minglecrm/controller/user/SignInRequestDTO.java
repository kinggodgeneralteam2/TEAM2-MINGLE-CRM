package com.team2final.minglecrm.controller.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignInRequestDTO {
    private String email;
    private String password;
}
