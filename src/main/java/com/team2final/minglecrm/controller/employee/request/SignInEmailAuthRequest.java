package com.team2final.minglecrm.controller.employee.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

@Getter
@RequiredArgsConstructor
public class SignInEmailAuthRequest {

    private final String email;
    private final String password;
}
