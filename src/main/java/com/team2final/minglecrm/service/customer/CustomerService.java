package com.team2final.minglecrm.service.customer;

import com.team2final.minglecrm.controller.customer.request.CustomerUpdateRequest;
import com.team2final.minglecrm.controller.customer.response.CustomerResponse;
import com.team2final.minglecrm.entity.customer.Customer;
import com.team2final.minglecrm.persistence.repository.customer.CustomerRepository;
import com.team2final.minglecrm.persistence.repository.employee.EmployeeRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final EmployeeRepository employeeRepository;

    // 고객 조회
    @Transactional
    public List<CustomerResponse> getAllCustomer() {
        return customerRepository.findAll().stream()
                .map(customer -> new CustomerResponse(
                        customer.getId(),
                        customer.getName(),
                        customer.getGrade(),
                        customer.getPhone(),
                        customer.getAddress(),
                        customer.getEmployee().getName(),
                        customer.getMemo(),
                        customer.getGender(),
                        customer.getBirth(),
                        customer.getReward().getAmount()
                ))
                .collect(Collectors.toList());
    }

    public CustomerResponse findById(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();

        if (customer.getIsDeleted()) {
            throw new RuntimeException("없슴둥");
        }

        CustomerResponse customerResponse = CustomerResponse.builder()
                .id(customer.getId())
                .address(customer.getAddress())
                .amount(customer.getReward().getAmount())
                .grade(customer.getGrade())
                .memo(customer.getMemo())
                .birth(customer.getBirth())
                .employeeName(customer.getEmployee().getName())
                .phone(customer.getPhone())
                .name(customer.getName())
                .gender(customer.getGender())
                .build();

        return customerResponse;
    }

    @Transactional
    public void updateCustomer(Long customerId, CustomerUpdateRequest customerUpdateRequest) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        customer.updateCustomerDetail(customerUpdateRequest);

    }

    @Transactional
    public void deleteCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow();
        customer.deleteCustomer();
    }

    // 담당자별 고객 조회
//    @Transactional
//    public List<CustomerResponse> getCustomersByUserId(String employee) {
//        return customerRepository.findByEmployeeName(employee).stream()
//                .map(customer -> new CustomerResponse(
//                        customer.getId(),
//                        customer.getName(),
//                        customer.getGrade(),
//                        customer.getPhone(),
//                        customer.getAddress(),
//                        customer.getEmployee().getName(),
//                        customer.getMemo(),
//                        customer.getGender(),
//                        customer.getBirth()
//                ))
//                .collect(Collectors.toList());
//    }
//
//    // 고객 그룹별 고객 조회
//    @Transactional
//    public List<CustomerResponse> getCustomersByCustomerGroup(String customerGroup) {
//        return customerRepository.findByGrade(customerGroup).stream()
//                .map(customer -> new CustomerResponse(
//                        customer.getId(),
//                        customer.getName(),
//                        customer.getGrade(),
//                        customer.getPhone(),
//                        customer.getAddress(),
//                        customer.getEmployee().getName(),
//                        customer.getMemo(),
//                        customer.getGender(),
//                        customer.getBirth()
//                ))
//                .collect(Collectors.toList());
//    }
//
//    // 고객 정보 수정
//    @Transactional
//    public void updateCustomer(Long id, CustomerUpdateRequest param) {
//        Customer customer = customerRepository.findById(id).orElseThrow();
//
////        customer.setName(param.getName());
////        customer.setGrade(param.getGrade());
////        customer.setPhone(param.getPhone());
////        customer.setAddress(param.getAddress());
////        customer.setMemo(param.getMemo());
////        customer.setGender(param.getGender());
//
//        Employee employee = employeeRepository.findById(customer.getEmployee().getId()).orElseThrow();
//        employee.setName(param.getEmployeeName());
//
//        customerRepository.save(customer);
//        employeeRepository.save(employee);
//    }
}