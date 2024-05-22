package com.team2final.minglecrm.controller.customer.request;


import lombok.Getter;

@Getter
public class CustomerUpdateRequest {

    private String name;
    private String customerGroup;
    private String phone;
    private String address;
    private String employeeName;
    private String memo;
    private String gender;

}
