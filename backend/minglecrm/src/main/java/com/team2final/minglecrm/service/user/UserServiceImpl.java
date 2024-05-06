package com.team2final.minglecrm.service.user;

import com.team2final.minglecrm.controller.user.SignInRequestDTO;
import com.team2final.minglecrm.controller.user.SignInResponseDTO;
import com.team2final.minglecrm.controller.user.SignUpRequestDTO;
import com.team2final.minglecrm.controller.user.SignUpResponseDTO;
import com.team2final.minglecrm.domain.User;
import com.team2final.minglecrm.repository.UserRepository;
import com.team2final.minglecrm.service.jwt.JwtProvider;
import com.team2final.minglecrm.vo.Subject;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Override
    @Transactional
    public SignUpResponseDTO signUp(SignUpRequestDTO signUpRequestDTO) {

        if (userRepository.existsByEmail(signUpRequestDTO.getEmail())) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        // 비밀번호 유효성 검사
        String password = signUpRequestDTO.getPassword();
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("비밀번호는 최소 8자 이상이어야 합니다.");
        }

        String encodedPassword = passwordEncoder.encode(password);
        User user = User.builder()
                .email(signUpRequestDTO.getEmail())
                .password(encodedPassword)
                .name(signUpRequestDTO.getName())
                .authority("ROLE_STAFF")
                .build();

        userRepository.save(user);
        return SignUpResponseDTO.of(user);
    }

    @Override
    @Transactional(readOnly = true)
    public SignInResponseDTO signIn(SignInRequestDTO signInRequestDTO) {
        User user = userRepository.findByEmail(signInRequestDTO.getEmail()).get();

        boolean matches = passwordEncoder.matches(signInRequestDTO.getPassword(), user.getPassword());
        if (!matches) {
            return null;
        }
        return SignInResponseDTO.of(user);
    }

//    @Override
//    @Transactional
//    public Void logout(String atk) {
//
//    }
}
