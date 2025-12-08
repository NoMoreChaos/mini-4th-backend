package com.kt.aivle_central_4_8.controller;

import com.kt.aivle_central_4_8.dto.ApiResponse;
import com.kt.aivle_central_4_8.dto.book.request.BookCreateRequest;
import com.kt.aivle_central_4_8.service.CreateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CreateController {
    private final CreateService createService;

    // 책 등록
    @PostMapping("/books")
    public ApiResponse<String> createBook (
            @Valid @RequestBody BookCreateRequest dto) {

        String bookCd = createService.createBook(dto);
        return ApiResponse.success(bookCd);
    }
}
