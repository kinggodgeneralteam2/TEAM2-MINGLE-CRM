package com.team2final.minglecrm.controller.customer;

import com.team2final.minglecrm.controller.customer.response.CustomerResponse;
import com.team2final.minglecrm.service.customer.CustomerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerApi {
    private final CustomerService customerService;

    // 고객 전체 List
    // TODO : paging 처리
    @GetMapping()
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        List<CustomerResponse> customers = customerService.getAllCustomer();
        return ResponseEntity.ok(customers);
    }

    // 고객 상세 조회 페이지
//    @GetMapping()

//    @GetMapping("/employee/{employee}")
//    public ResponseEntity<List<CustomerResponse>> getCustomersByUserId(
//            @PathVariable("employee") String employeeName) {
//        List<CustomerResponse> customersByUserId = customerService.getCustomersByUserId(
//                employeeName);
//        return ResponseEntity.ok(customersByUserId);
//    }
//
//    @GetMapping("/group/{customerGroup}")
//    public ResponseEntity<List<CustomerResponse>> getCustomersByCustomerGroup(
//            @PathVariable("customerGroup") String customerGroup) {
//        List<CustomerResponse> customersByGroup = customerService.getCustomersByCustomerGroup(
//                customerGroup);
//        return ResponseEntity.ok(customersByGroup);
//    }
//
//    @PatchMapping("/{customerId}")
//    public ResponseEntity<Void> updateCustomer(@PathVariable("customerId") Long Id,
//            @RequestBody CustomerUpdateRequest customerUpdateRequest) {
//        customerService.updateCustomer(Id, customerUpdateRequest);
//        return ResponseEntity.ok().build();
//    }
//
//    @GetMapping("/test")
//    public ResponseEntity<Void> test() {
//        return ResponseEntity.ok().build();
//    }
}
