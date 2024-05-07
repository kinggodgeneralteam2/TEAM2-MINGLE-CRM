    package com.team2final.minglecrm.controller.customer;

    import com.team2final.minglecrm.dto.CustomerListResponseDTO;
    import com.team2final.minglecrm.dto.CustomerResponse;
    import com.team2final.minglecrm.dto.CustomerUpdateDTO;
    import com.team2final.minglecrm.service.customer.CustomerServiceHP;
    import com.team2final.minglecrm.service.jwt.JwtProvider;
    import com.team2final.minglecrm.vo.Subject;
    import jakarta.servlet.http.HttpServletRequest;
    import lombok.RequiredArgsConstructor;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequiredArgsConstructor
    @RequestMapping("/api/v1/customers")
    public class CustomerControllerHP {

        private final CustomerServiceHP customerServiceHP;

        private final JwtProvider jwtProvider;

        // 고객 전체 조회
        @GetMapping("")
        public ResponseEntity<List<CustomerListResponseDTO>> getAllCustomers() {
            List<CustomerListResponseDTO> customers = customerServiceHP.getAllCustomer();
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }

        // 유저 이름으로 고객 조회
        @GetMapping("/username/{username}")
        public ResponseEntity<List<CustomerListResponseDTO>> getCustomersByUserId(@PathVariable("username") String userName) {
            List<CustomerListResponseDTO> customersByUserId = customerServiceHP.getCustomersByUserId(userName);
            return ResponseEntity.ok(customersByUserId);
        }

        // 고객 그룹으로 고객 조회
        @GetMapping("/group/{customerGroup}")
        public ResponseEntity<List<CustomerListResponseDTO>> getCustomersByCustomerGroup(@PathVariable("customerGroup") String customerGroup) {
            List<CustomerListResponseDTO> customersByGroup = customerServiceHP.getCustomersByCustomerGroup(customerGroup);
            return ResponseEntity.ok(customersByGroup);
        }

        // 고객 정보 수정
        @PutMapping("/{customerId}")
        public ResponseEntity<Void> updateCustomer(@PathVariable ("customerId") Long Id, @RequestBody CustomerUpdateDTO customerUpdateDTO) {
            customerServiceHP.updateCustomer(Id, customerUpdateDTO);
            return ResponseEntity.ok().build();
        }

        @GetMapping("/{customerId}")
        public CustomerResponse find(@PathVariable ("customerId") Long id) {
            return customerServiceHP.findById(id);
        }
    }
