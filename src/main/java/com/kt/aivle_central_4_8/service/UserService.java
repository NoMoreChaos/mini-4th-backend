package com.kt.aivle_central_4_8.service;

import com.kt.aivle_central_4_8.dto.user_tb.LoginResultDto;
import com.kt.aivle_central_4_8.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<LoginResultDto> login(String email, String pw) {

        return userRepository.findByUserEmailDcAndUserPwDc(email, pw)
                .map(user -> new LoginResultDto(user.getUserCd()));
    }
}
