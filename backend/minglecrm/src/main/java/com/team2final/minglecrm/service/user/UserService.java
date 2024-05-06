package com.team2final.minglecrm.service.user;

import com.team2final.minglecrm.controller.user.SignInRequestDTO;
import com.team2final.minglecrm.controller.user.SignInResponseDTO;
import com.team2final.minglecrm.controller.user.SignUpRequestDTO;
import com.team2final.minglecrm.controller.user.SignUpResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


public interface UserService {

    @Transactional
    SignUpResponseDTO signUp(SignUpRequestDTO signUpRequestDTO);

    @Transactional
    SignInResponseDTO signIn(SignInRequestDTO signInRequestDTO);

//    @Transactional
//    Void logout(String atk);
}
