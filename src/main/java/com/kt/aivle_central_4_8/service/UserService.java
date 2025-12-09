// UserService
// - 사용자 계정 관련 로직을 처리하는 서비스 클래스
package com.kt.aivle_central_4_8.service;

import com.kt.aivle_central_4_8.dto.user.response.LoginResultDto;
import com.kt.aivle_central_4_8.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    // 로그인 권한 체크 메서드 (사용자 정보 조회 후 로그인 성공여부 반환)
    // - 요청 : 이메일,pw
    // - 성공 시 반환 : usercd
    public Optional<LoginResultDto> login(String email, String pw) {

        return userRepository.findByUserEmailDcAndUserPwDc(email, pw)
                .map(user -> new LoginResultDto(user.getUserCd()));
    }
}
