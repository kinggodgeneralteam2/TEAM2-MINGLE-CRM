package com.team2final.minglecrm.controller.inquiry.response;

import com.team2final.minglecrm.entity.customer.Customer;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class InquiryResponse {
    private LocalDateTime date;
    private String inquiry;
    private String type;
    private String name;
    private Long customerId;

    @Builder
    public InquiryResponse(LocalDateTime date, String inquiry, String type, String name, Long customerId) {
        this.date = date;
        this.inquiry = inquiry;
        this.type = type;
        this.name = name;
        this.customerId = customerId;
    }
}
