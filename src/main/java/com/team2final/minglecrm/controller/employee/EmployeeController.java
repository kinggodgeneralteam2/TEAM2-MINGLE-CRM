package com.team2final.minglecrm.controller.employee;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.team2final.minglecrm.controller.employee.request.SignInRequest;
import com.team2final.minglecrm.controller.employee.request.SignUpRequest;
import com.team2final.minglecrm.controller.employee.response.SignInResponse;
import com.team2final.minglecrm.controller.employee.response.SignUpResponse;
import com.team2final.minglecrm.controller.employee.response.TokenResponse;
import com.team2final.minglecrm.service.jwt.JwtProvider;
import com.team2final.minglecrm.service.employee.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final JwtProvider jwtProvider;

    @PostMapping("/api/v1/auth/signup")
    public ResponseEntity<SignUpResponse> signUp(@RequestBody SignUpRequest requestDTO) {
        SignUpResponse responseDTO = employeeService.signUp(requestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @PostMapping("/api/v1/auth/signin")
    public ResponseEntity<TokenResponse> signIn(@RequestBody SignInRequest requestDTO) throws JsonProcessingException {
        SignInResponse responseDTO = employeeService.signIn(requestDTO);
        TokenResponse tokenResponse = jwtProvider.createTokensBySignIn(responseDTO);
        return new ResponseEntity<>(tokenResponse, HttpStatus.ACCEPTED);
    }


    @GetMapping("/api/v1/auth/renew")
    public ResponseEntity<TokenResponse> reNew(HttpServletRequest request) throws JsonProcessingException {
        String rtk = request.getHeader("Authorization").substring(7);
        TokenResponse responseDTO = jwtProvider.renewToken(rtk);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/api/v1/auth/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request) throws JsonProcessingException {
        String atk = request.getHeader("Authorization").substring(7);
        employeeService.logout(atk);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
