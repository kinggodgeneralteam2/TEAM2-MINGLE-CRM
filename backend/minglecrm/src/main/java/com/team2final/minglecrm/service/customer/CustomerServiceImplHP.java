package com.team2final.minglecrm.service.customer;

import com.team2final.minglecrm.domain.Customer;
import com.team2final.minglecrm.domain.User;
import com.team2final.minglecrm.dto.CustomerListResponseDTO;
import com.team2final.minglecrm.dto.CustomerUpdateDTO;
import com.team2final.minglecrm.repository.CustomerRepositoryHP;
import com.team2final.minglecrm.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImplHP implements CustomerServiceHP{

    private final CustomerRepositoryHP customerRepositoryHP;
    private final UserRepository userRepository;

    // 고객 조회
    @Override
    @Transactional
    public List<CustomerListResponseDTO> getAllCustomer() {
        return customerRepositoryHP.findAll().stream()
                .map(customer -> new CustomerListResponseDTO(
                        customer.getId(),
                        customer.getName(),
                        customer.getCustomer_group(),
                        customer.getPhone(),
                        customer.getAddress(),
                        customer.getUser().getName(),
                        customer.getMemo(),
                        customer.getGender(),
                        customer.getBirth()
                ))
                .collect(Collectors.toList());
    }

    // 담당자별 고객 조회
    @Override
    @Transactional
    public List<CustomerListResponseDTO> getCustomersByUserId(String userName) {
        return customerRepositoryHP.findByUserName(userName).stream()
                .map(customer -> new CustomerListResponseDTO(
                        customer.getId(),
                        customer.getName(),
                        customer.getCustomer_group(),
                        customer.getPhone(),
                        customer.getAddress(),
                        customer.getUser().getName(),
                        customer.getMemo(),
                        customer.getGender(),
                        customer.getBirth()
                ))
                .collect(Collectors.toList());
    }

    // 고객 그룹별 고객 조회
    @Override
    @Transactional
    public List<CustomerListResponseDTO> getCustomersByCustomerGroup(String customerGroup) {
        return customerRepositoryHP.findByCustomer_group(customerGroup).stream() // 여기염
                .map(customer -> new CustomerListResponseDTO(
                        customer.getId(),
                        customer.getName(),
                        customer.getCustomer_group(),
                        customer.getPhone(),
                        customer.getAddress(),
                        customer.getUser().getName(),
                        customer.getMemo(),
                        customer.getGender(),
                        customer.getBirth()
                ))
                .collect(Collectors.toList());
    }

    // 고객 정보 수정
    @Override
    @Transactional
    public void updateCustomer(Long id, CustomerUpdateDTO param) {
        Customer customer = customerRepositoryHP.findById(id).orElseThrow();

        customer.setName(param.getName());
        customer.setCustomer_group(param.getCustomerGroup());
        customer.setPhone(param.getPhone());
        customer.setAddress(param.getAddress());
        customer.setMemo(param.getMemo());
        customer.setGender(param.getGender());
        User user = userRepository.findById(customer.getUser().getId()).orElseThrow();
        user.setName(param.getUserName());

        customerRepositoryHP.save(customer);
        userRepository.save(user);
    }
}