package com.team2final.minglecrm.service.customer;

import com.team2final.minglecrm.controller.customer.request.CustomerUpdateRequest;
import com.team2final.minglecrm.controller.customer.response.CustomerListResponse;
import com.team2final.minglecrm.entity.customer.Customer;
import com.team2final.minglecrm.entity.employee.Employee;
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
    public List<CustomerListResponse> getAllCustomer() {
        return customerRepository.findAll().stream()
                .map(customer -> new CustomerListResponse(
                        customer.getId(),
                        customer.getName(),
                        customer.getCustomerGroup(),
                        customer.getPhone(),
                        customer.getAddress(),
                        customer.getEmployee().getName(),
                        customer.getMemo(),
                        customer.getGender(),
                        customer.getBirth()
                ))
                .collect(Collectors.toList());
    }

    // 담당자별 고객 조회
    @Transactional
    public List<CustomerListResponse> getCustomersByUserId(String employee) {
        return customerRepository.findByEmployeeName(employee).stream()
                .map(customer -> new CustomerListResponse(
                        customer.getId(),
                        customer.getName(),
                        customer.getCustomerGroup(),
                        customer.getPhone(),
                        customer.getAddress(),
                        customer.getEmployee().getName(),
                        customer.getMemo(),
                        customer.getGender(),
                        customer.getBirth()
                ))
                .collect(Collectors.toList());
    }

    // 고객 그룹별 고객 조회
    @Transactional
    public List<CustomerListResponse> getCustomersByCustomerGroup(String customerGroup) {
        return customerRepository.findByCustomerGroup(customerGroup).stream()
                .map(customer -> new CustomerListResponse(
                        customer.getId(),
                        customer.getName(),
                        customer.getCustomerGroup(),
                        customer.getPhone(),
                        customer.getAddress(),
                        customer.getEmployee().getName(),
                        customer.getMemo(),
                        customer.getGender(),
                        customer.getBirth()
                ))
                .collect(Collectors.toList());
    }

    // 고객 정보 수정
    @Transactional
    public void updateCustomer(Long id, CustomerUpdateRequest param) {
        Customer customer = customerRepository.findById(id).orElseThrow();

        customer.setName(param.getName());
        customer.setCustomerGroup(param.getCustomerGroup());
        customer.setPhone(param.getPhone());
        customer.setAddress(param.getAddress());
        customer.setMemo(param.getMemo());
        customer.setGender(param.getGender());

        Employee employee = employeeRepository.findById(customer.getEmployee().getId()).orElseThrow();
        employee.setName(param.getEmployeeName());

        customerRepository.save(customer);
        employeeRepository.save(employee);
    }
}