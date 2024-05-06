package com.team2final.minglecrm.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerUpdateDTO {

    private String name;
    private String customerGroup;
    private String phone;
    private String address;
    private String userName;
    private String memo;
    private String gender;

    @Builder
    public CustomerUpdateDTO(String name, String customerGroup, String phone, String address, String userName, String memo, String gender) {
        this.name = name;
        this.customerGroup = customerGroup;
        this.phone = phone;
        this.address = address;
        this.userName = userName;
        this.memo = memo;
        this.gender = gender;
    }
}
