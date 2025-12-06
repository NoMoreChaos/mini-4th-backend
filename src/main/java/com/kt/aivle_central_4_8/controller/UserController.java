package com.kt.aivle_central_4_8.controller;

import com.kt.aivle_central_4_8.controller.dto.LoginRequest;
import com.kt.aivle_central_4_8.dto.ApiResponse;
import com.kt.aivle_central_4_8.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ApiResponse<?> login(@RequestBody LoginRequest request) {

        return userService.login(request.getUserEmailDc(), request.getUserPwDc())
                .map(ApiResponse::success)
                .orElseGet(() -> ApiResponse.failure("Invalid email or password"));
    }
}
