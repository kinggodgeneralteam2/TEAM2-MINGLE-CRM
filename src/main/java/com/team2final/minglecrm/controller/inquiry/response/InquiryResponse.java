package com.team2final.minglecrm.controller.inquiry.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class InquiryResponse {
    private Long id;
    private String customerName;
    private String customerPhone;
    private LocalDateTime date;
    private String type;
    private Boolean isReply;
    private String employName;
    private String inquiryTitle;
    private String inquiryContent;

    @Builder
    public InquiryResponse(Long id, String customerName, String customerPhone, LocalDateTime date, String type, Boolean isReply, String employName, String inquiryTitle, String inquiryContent) {
        this.id = id;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.date = date;
        this.type = type;
        this.isReply = isReply;
        this.employName = employName;
        this.inquiryTitle = inquiryTitle;
        this.inquiryContent = inquiryContent;
    }
}
