package com.team2final.minglecrm.controller.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class TokenResponseDTO {
    private final String atk;
    private final String rtk;

    @Builder
    public TokenResponseDTO(String atk, String rtk) {
        this.atk = atk;
        this.rtk = rtk;
    }
}
