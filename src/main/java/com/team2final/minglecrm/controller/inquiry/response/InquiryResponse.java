package com.team2final.minglecrm.controller.inquiry.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class InquiryResponse {
    private LocalDateTime date;
    private String inquiry;
    private String type;

    @Builder
    public InquiryResponse(LocalDateTime date, String inquiry, String type) {
        this.date = date;
        this.inquiry = inquiry;
        this.type = type;
    }
}
