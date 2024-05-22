package com.team2final.minglecrm.controller.employee.response;

import com.team2final.minglecrm.entity.employee.Employee;
import lombok.Getter;

@Getter
public class SignInResponse {

    private final Long id;
    private final String email;
    private final String authority;

    private SignInResponse(Long id, String email, String authority) {
        this.id = id;
        this.email = email;
        this.authority = authority;
    }

    public static SignInResponse of(Employee employee) {
        return new SignInResponse(
                employee.getId(),
                employee.getEmail(),
                employee.getAuthority()
        );
    }
}
