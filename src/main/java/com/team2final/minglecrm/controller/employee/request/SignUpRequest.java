package com.team2final.minglecrm.controller.employee.request;


import lombok.Builder;
import lombok.Getter;

@Getter
public class SignUpRequest {

    private String email;
    private String name;
    private String password;

    @Builder
    public SignUpRequest(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }
}
