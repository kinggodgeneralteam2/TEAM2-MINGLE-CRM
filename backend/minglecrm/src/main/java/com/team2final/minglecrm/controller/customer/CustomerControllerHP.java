    package com.team2final.minglecrm.controller.customer;

    import com.team2final.minglecrm.dto.CustomerListResponseDTO;
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
        public ResponseEntity<List<CustomerListResponseDTO>> getAllCustomers(HttpServletRequest request) {
            // 토큰 검증 구현
            String header = request.getHeader("Authorization");
            if (header == null || !header.startsWith("Bearer ")) {
                System.out.println("유효하지 않은 토큰입니다.");
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }

            String token = header.substring(7);
            try {
                Subject subject = jwtProvider.getSubject(token);
                System.out.println("정보를 가져옵니다.");
                List<CustomerListResponseDTO> customers = customerServiceHP.getAllCustomer();
                return new ResponseEntity<>(customers, HttpStatus.OK);
            } catch (Exception e) {
                System.out.println("유효하지 않은 토큰입니다.");
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        }

        // 유저 이름으로 고객 조회
        @GetMapping("/username/{username}")
        public ResponseEntity<List<CustomerListResponseDTO>> getCustomersByUserId(@PathVariable("username") String userName, HttpServletRequest request) {
            String header = request.getHeader("Authorization");
            if (header == null || !header.startsWith("Bearer ")) {
                System.out.println("유효하지 않은 토큰입니다.");
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
            String token = header.substring(7);
            try {
                Subject subject = jwtProvider.getSubject(token);
                System.out.println("정보를 가져옵니다.");
                List<CustomerListResponseDTO> customersByUserId = customerServiceHP.getCustomersByUserId(userName);
                return ResponseEntity.ok(customersByUserId);
            } catch (Exception e) {
                System.out.println("유효하지 않은 토큰입니다.");
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        }

        // 고객 그룹으로 고객 조회
        @GetMapping("/group/{customerGroup}")
        public ResponseEntity<List<CustomerListResponseDTO>> getCustomersByCustomerGroup(@PathVariable("customerGroup") String customerGroup, HttpServletRequest request) {
            String header = request.getHeader("Authorization");
            if (header == null || !header.startsWith("Bearer ")) {
                System.out.println("유효하지 않은 토큰입니다.");
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
            String token = header.substring(7);
            try {
                Subject subject = jwtProvider.getSubject(token);
                System.out.println("정보를 가져옵니다.");
                List<CustomerListResponseDTO> customersByGroup = customerServiceHP.getCustomersByCustomerGroup(customerGroup);
                return ResponseEntity.ok(customersByGroup);
            } catch (Exception e) {
                System.out.println("유효하지 않은 토큰입니다.");
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        }

        // 고객 정보 수정
        @PatchMapping("/{customerId}")
        public ResponseEntity<Void> updateCustomer(@PathVariable ("customerId") Long Id, @RequestBody CustomerUpdateDTO customerUpdateDTO, HttpServletRequest request) {
            String header = request.getHeader("Authorization");
            if (header == null || !header.startsWith("Bearer ")) {
                System.out.println("유효하지 않은 토큰입니다.");
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
            String token = header.substring(7);
            try {
                Subject subject = jwtProvider.getSubject(token);
                System.out.println("정보를 가져옵니다.");
                customerServiceHP.updateCustomer(Id, customerUpdateDTO);
                return ResponseEntity.ok().build();
            } catch (Exception e) {
                System.out.println("유효하지 않은 토큰입니다.");
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        }
    }
