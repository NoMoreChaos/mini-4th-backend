//UserController
// - 사용자 관련 API 요청을 처리하는 컨트롤러
// - 현재는 api/user/login 기능만 제공함.(20251207)

package com.kt.aivle_central_4_8.controller;

import com.kt.aivle_central_4_8.dto.user.request.LoginRequest;
import com.kt.aivle_central_4_8.dto.ApiResponse;
import com.kt.aivle_central_4_8.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    // 로그인 처리 메서드
    // - 이메일/비밀번호를 입력받아 인증을 시도한다.
    // - 성공 시 사용자 식별자(UserCd)를 포함한 성공 응답 반환
    // - 실패 시 에러 메시지 포함 실패 응답 반환
    @PostMapping("/login")
    public ApiResponse<?> login(@RequestBody LoginRequest request) {

        return userService.login(request.getUserEmailDc(), request.getUserPwDc())
                .map(ApiResponse::success)
                .orElseGet(() -> ApiResponse.failure("Invalid email or password"));
    }
}
