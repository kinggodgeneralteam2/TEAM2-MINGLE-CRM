package com.team2final.minglecrm.controller.employee.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignInRequest {
    private String email;
    private String password;
}
