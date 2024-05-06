package com.team2final.minglecrm.dto;


import com.team2final.minglecrm.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class CustomerListResponseDTO {

    private Long id;
    private String name;
    private String customerGroup;
    private String phone;
    private String address;
    private String userName;
    private String memo;
    private String gender;
    private LocalDate birth;

    @Builder
    public CustomerListResponseDTO(Long id, String name, String customerGroup, String phone, String address, String userName, String memo, String gender, LocalDate birth) {
        this.id = id;
        this.name = name;
        this.customerGroup = customerGroup;
        this.phone = phone;
        this.address = address;
        this.userName = userName;
        this.memo = memo;
        this.gender = gender;
        this.birth = birth;
    }
}
