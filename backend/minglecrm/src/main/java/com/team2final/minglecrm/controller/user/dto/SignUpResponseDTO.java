package com.team2final.minglecrm.controller.user.dto;

import com.team2final.minglecrm.domain.User;
import lombok.Getter;

@Getter
public class SignUpResponseDTO {
    private final Long id;
    private final String email;
    private final String authority;

    private SignUpResponseDTO(Long id, String email, String authority) {
        this.id = id;
        this.email = email;
        this.authority = authority;
    }
    public static SignUpResponseDTO of(User user) {
        return new SignUpResponseDTO(
                user.getId(),
                user.getEmail(),
                user.getAuthority());
    }

}
