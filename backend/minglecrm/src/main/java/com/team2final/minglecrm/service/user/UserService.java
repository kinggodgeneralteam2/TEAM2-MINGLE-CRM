package com.team2final.minglecrm.service.user;

import com.team2final.minglecrm.controller.user.dto.SignInRequestDTO;
import com.team2final.minglecrm.controller.user.dto.SignInResponseDTO;
import com.team2final.minglecrm.controller.user.dto.SignUpRequestDTO;
import com.team2final.minglecrm.controller.user.dto.SignUpResponseDTO;
import org.springframework.transaction.annotation.Transactional;


public interface UserService {

    @Transactional
    SignUpResponseDTO signUp(SignUpRequestDTO signUpRequestDTO);

    @Transactional
    SignInResponseDTO signIn(SignInRequestDTO signInRequestDTO);

//    @Transactional
//    Void logout(String atk);
}
