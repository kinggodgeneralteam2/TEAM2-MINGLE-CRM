package com.team2final.minglecrm.controller.employee.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class TokenResponse {
    private final String atk;
    private final String rtk;

    @Builder
    public TokenResponse(String atk, String rtk) {
        this.atk = atk;
        this.rtk = rtk;
    }
}
