// LoginResultDto
// - 로그인 성공 시 사용자 식별값(userCd)을 전달하는 응답 DTO
package com.kt.aivle_central_4_8.dto.user_tb;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResultDto {
    private String userCd;
}
