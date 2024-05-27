package com.team2final.minglecrm.controller.customer;

import com.team2final.minglecrm.controller.customer.request.CustomerUpdateRequest;
import com.team2final.minglecrm.controller.customer.response.CustomerListResponse;
import com.team2final.minglecrm.service.customer.CustomerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("")
    public ResponseEntity<List<CustomerListResponse>> getAllCustomers() {
        List<CustomerListResponse> customers = customerService.getAllCustomer();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/employee/{employee}")
    public ResponseEntity<List<CustomerListResponse>> getCustomersByUserId(
            @PathVariable("employee") String employeeName) {
        List<CustomerListResponse> customersByUserId = customerService.getCustomersByUserId(
                employeeName);
        return ResponseEntity.ok(customersByUserId);
    }

    @GetMapping("/group/{customerGroup}")
    public ResponseEntity<List<CustomerListResponse>> getCustomersByCustomerGroup(
            @PathVariable("customerGroup") String customerGroup) {
        List<CustomerListResponse> customersByGroup = customerService.getCustomersByCustomerGroup(
                customerGroup);
        return ResponseEntity.ok(customersByGroup);
    }

    @PatchMapping("/{customerId}")
    public ResponseEntity<Void> updateCustomer(@PathVariable("customerId") Long Id,
            @RequestBody CustomerUpdateRequest customerUpdateRequest) {
        customerService.updateCustomer(Id, customerUpdateRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/test")
    public ResponseEntity<Void> test() {
        return ResponseEntity.ok().build();
    }
}
