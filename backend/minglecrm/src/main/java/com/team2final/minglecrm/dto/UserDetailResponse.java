package com.team2final.minglecrm.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDetailResponse {

    private Long id;
    private String name;
    private String email;
    private String password;


}
