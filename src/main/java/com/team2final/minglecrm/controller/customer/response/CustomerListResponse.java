package com.team2final.minglecrm.controller.customer.response;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class CustomerListResponse {

    private Long id;
    private String name;
    private String customerGroup;
    private String phone;
    private String address;
    private String employeeName;
    private String memo;
    private String gender;
    private LocalDate birth;

    @Builder
    public CustomerListResponse(Long id, String name, String customerGroup, String phone, String address, String employeeName, String memo, String gender, LocalDate birth) {
        this.id = id;
        this.name = name;
        this.customerGroup = customerGroup;
        this.phone = phone;
        this.address = address;
        this.employeeName = employeeName;
        this.memo = memo;
        this.gender = gender;
        this.birth = birth;
    }
}
