package com.team2final.minglecrm.service.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.team2final.minglecrm.controller.user.dto.SignInRequestDTO;
import com.team2final.minglecrm.controller.user.dto.SignInResponseDTO;
import com.team2final.minglecrm.controller.user.dto.SignUpRequestDTO;
import com.team2final.minglecrm.controller.user.dto.SignUpResponseDTO;
import com.team2final.minglecrm.controller.user.dto.UpdateUserRequest;
import com.team2final.minglecrm.dto.UserResponse;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserService {

    @Transactional
    SignUpResponseDTO signUp(SignUpRequestDTO signUpRequestDTO);

    @Transactional
    SignInResponseDTO signIn(SignInRequestDTO signInRequestDTO);

    @Transactional
    Void logout(String atk) throws JsonProcessingException;

    List<UserResponse> findAll();

    void updateUser(Long userId, UpdateUserRequest updateUserRequest);

}
