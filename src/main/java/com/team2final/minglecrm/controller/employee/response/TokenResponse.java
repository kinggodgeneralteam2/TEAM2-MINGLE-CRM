package com.team2final.minglecrm.controller.employee.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class TokenResponse {

    private String status;
    private Tokens data;
    private class Tokens {
        private String atk;
        private String rtk;

        public Tokens(String atk, String rtk) {
            this.atk = atk;
            this.rtk = rtk;
        }
    }

    @Builder
    public TokenResponse(String status, String atk, String rtk) {
        this.status = status;
        this.data = new Tokens(atk, rtk);
    }
}
