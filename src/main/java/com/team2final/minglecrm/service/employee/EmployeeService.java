package com.team2final.minglecrm.service.employee;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.team2final.minglecrm.controller.employee.request.SignInRequest;
import com.team2final.minglecrm.controller.employee.response.SignInResponse;
import com.team2final.minglecrm.controller.employee.request.SignUpRequest;
import com.team2final.minglecrm.controller.employee.response.SignUpResponse;
import com.team2final.minglecrm.persistence.repository.employee.EmployeeRepository;
import com.team2final.minglecrm.service.jwt.JwtProvider;
import com.team2final.minglecrm.persistence.dao.RedisDao;
import com.team2final.minglecrm.controller.employee.vo.Subject;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final RedisDao redisDao;

    @Transactional
    public SignUpResponse signUp(SignUpRequest signUpRequest) {

        if (employeeRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }

        // 비밀번호 유효성 검사
        String password = signUpRequest.getPassword();
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("비밀번호는 최소 8자 이상이어야 합니다.");
        }

        String encodedPassword = passwordEncoder.encode(password);
        com.team2final.minglecrm.entity.employee.Employee employee = com.team2final.minglecrm.entity.employee.Employee.builder()
                .email(signUpRequest.getEmail())
                .password(encodedPassword)
                .name(signUpRequest.getName())
                .authority("ROLE_STAFF")
                .build();

        employeeRepository.save(employee);
        return SignUpResponse.of(employee);
    }

    @Transactional(readOnly = true)
    public SignInResponse signIn(SignInRequest signInRequest) {
        com.team2final.minglecrm.entity.employee.Employee employee = employeeRepository.findByEmail(signInRequest.getEmail()).get();

        boolean matches = passwordEncoder.matches(signInRequest.getPassword(), employee.getPassword());
        if (!matches) {
            return null;
        }
        return SignInResponse.of(employee);
    }

    @Transactional
    public Void logout(String atk) throws JsonProcessingException {
        Subject subject = jwtProvider.getSubject(atk);
        redisDao.getValues(subject.getEmail());
        redisDao.deleteValues(subject.getEmail());
        System.out.println(subject.getEmail() + "로그아웃이요");
        return null;
    }
}
