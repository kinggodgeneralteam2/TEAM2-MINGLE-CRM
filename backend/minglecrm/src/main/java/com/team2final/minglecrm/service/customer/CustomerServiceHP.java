package com.team2final.minglecrm.service.customer;


import com.team2final.minglecrm.dto.CustomerListResponseDTO;
import com.team2final.minglecrm.dto.CustomerUpdateDTO;

import java.util.List;

public interface CustomerServiceHP {

    // 고객 목록 조회
    List<CustomerListResponseDTO> getAllCustomer();

    // 담당자별 고객 조회
    List<CustomerListResponseDTO> getCustomersByUserId(String userName);

    // 그룹별 고객 조회
    List<CustomerListResponseDTO> getCustomersByCustomerGroup(String customerGroup);

    // 고객 정보 수정
    void updateCustomer(Long id, CustomerUpdateDTO param);
}
