package com.team2final.minglecrm.controller.employee.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class TokenResponse {

    private String status;
    private Tokens data;

    @Builder
    @Getter
    public static class Tokens {
        private String atk;
        private String rtk;
    }

    @Builder
    public TokenResponse(String status, String atk, String rtk) {
        this.status = status;
        this.data = Tokens
                    .builder()
                    .atk(atk)
                    .rtk(rtk)
                    .build();
    }
}
