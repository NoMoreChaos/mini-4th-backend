// LoginRequest
// - 로그인 요청 시 전달되는 사용자 이메일과 비밀번호를 담는 DTO
package com.kt.aivle_central_4_8.dto.user.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequest {
    private String userEmailDc; //이메일
    private String userPwDc; //비밀번호
}