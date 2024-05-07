package com.team2final.minglecrm.controller.user.dto;

import com.team2final.minglecrm.domain.User;
import lombok.Getter;

@Getter
public class SignInResponseDTO {

    private final Long id;
    private final String email;
    private final String authority;

    private SignInResponseDTO(Long id, String email, String authority) {
        this.id = id;
        this.email = email;
        this.authority = authority;
    }

    public static SignInResponseDTO of(User user) {
        return new SignInResponseDTO(
                user.getId(),
                user.getEmail(),
                user.getAuthority()
        );
    }
}
