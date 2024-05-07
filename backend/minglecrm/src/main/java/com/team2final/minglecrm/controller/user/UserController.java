package com.team2final.minglecrm.controller.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.team2final.minglecrm.controller.user.dto.*;
import com.team2final.minglecrm.dto.UserResponse;
import com.team2final.minglecrm.service.jwt.JwtProvider;
import com.team2final.minglecrm.service.user.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtProvider jwtProvider;

    @PostMapping("/api/v1/auth/signup")
    public ResponseEntity<SignUpResponseDTO> signUp(@RequestBody SignUpRequestDTO requestDTO) {
        SignUpResponseDTO responseDTO = userService.signUp(requestDTO);
        return new ResponseEntity<SignUpResponseDTO>(responseDTO, HttpStatus.CREATED);
    }

    @PostMapping("/api/v1/auth/signin")
    public ResponseEntity<TokenResponseDTO> signIn(@RequestBody SignInRequestDTO requestDTO) throws JsonProcessingException {
        SignInResponseDTO responseDTO = userService.signIn(requestDTO);
        TokenResponseDTO tokenResponseDTO = jwtProvider.createTokensBySignIn(responseDTO);
        return new ResponseEntity<TokenResponseDTO>(tokenResponseDTO, HttpStatus.ACCEPTED);
    }


    @GetMapping("/api/v1/auth/renew")
    public ResponseEntity<TokenResponseDTO> reNew(HttpServletRequest request) throws JsonProcessingException {
        String rtk = request.getHeader("Authorization").substring(7);
        TokenResponseDTO responseDTO = jwtProvider.renewToken(rtk);
        return new ResponseEntity<TokenResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/api/v1/auth/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request) throws JsonProcessingException {
        String atk = request.getHeader("Authorization").substring(7);
        userService.logout(atk);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/api/v1/users")
    public List<UserResponse> userResponse() {
        return userService.findAll();
    }

    @PutMapping("/api/v1/{userId}")
    public void updateUser(@PathVariable Long userId, @RequestBody UpdateUserRequest updateUserRequest) {
        userService.updateUser(userId,updateUserRequest);
    }
}
