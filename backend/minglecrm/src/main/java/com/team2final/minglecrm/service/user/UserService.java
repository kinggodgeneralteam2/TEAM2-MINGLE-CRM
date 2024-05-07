package com.team2final.minglecrm.service.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.team2final.minglecrm.controller.user.dto.*;
import com.team2final.minglecrm.dto.UserDetailResponse;
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

    @Transactional
    void updateUserDetail(Long userId, UserUpdateRequest userUpdateRequest);

    @Transactional
    UserDetailResponse findUser(Long userId);
}
