    package com.team2final.minglecrm.controller.customer;

    import com.team2final.minglecrm.dto.CustomerListResponseDTO;
    import com.team2final.minglecrm.dto.CustomerUpdateDTO;
    import com.team2final.minglecrm.service.customer.CustomerServiceHP;
    import lombok.RequiredArgsConstructor;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequiredArgsConstructor
    @RequestMapping("/api/v1/customers")
    public class CustomerControllerHP {

        private final CustomerServiceHP customerServiceHP;

        // 토큰 있다는 가정
//        private final JwtService jwtService;


        @GetMapping("")
        public ResponseEntity<List<CustomerListResponseDTO>> getAllCustomers() {
//            String token = jwtService.extractTokenFromRequest(request);
//            String userEmail = jwtService.extractUserName(token);
//            User user = userService.findByEmail(userEmail);
//
//            if(!user.isAdminYn()) {
//                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//            }
            List<CustomerListResponseDTO> customers = customerServiceHP.getAllCustomer();
            return ResponseEntity.ok(customers);
        }

        @GetMapping("/username/{username}")
        public ResponseEntity<List<CustomerListResponseDTO>> getCustomersByUserId(@PathVariable("username") String userName) {
//            String token = jwtService.extractTokenFromRequest(request);
//            String userEmail = jwtService.extractUserName(token);
//            User user = userService.findByEmail(userEmail);
//
//            if(!user.isAdminYn()) {
//                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//            }
            List<CustomerListResponseDTO> customersByUserId = customerServiceHP.getCustomersByUserId(userName);
            return ResponseEntity.ok(customersByUserId);
        }

        @GetMapping("/group/{customerGroup}")
        public ResponseEntity<List<CustomerListResponseDTO>> getCustomersByCustomerGroup(@PathVariable("customerGroup") String customerGroup) {
//            String token = jwtService.extractTokenFromRequest(request);
//            String userEmail = jwtService.extractUserName(token);
//            User user = userService.findByEmail(userEmail);
//
//            if(!user.isAdminYn()) {
//                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//            }
            List<CustomerListResponseDTO> customersByGroup = customerServiceHP.getCustomersByCustomerGroup(customerGroup);
            return ResponseEntity.ok(customersByGroup);
        }

        @PatchMapping("/{customerId}")
        public ResponseEntity<Void> updateCustomer(@PathVariable ("customerId") Long Id, @RequestBody CustomerUpdateDTO customerUpdateDTO) {
            customerServiceHP.updateCustomer(Id, customerUpdateDTO);
            return ResponseEntity.ok().build();
        }
    }
