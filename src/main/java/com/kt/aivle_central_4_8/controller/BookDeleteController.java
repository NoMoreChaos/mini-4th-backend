package com.kt.aivle_central_4_8.controller;

import com.kt.aivle_central_4_8.dto.ApiResponse;
import com.kt.aivle_central_4_8.service.BookDeleteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books/delete")
@RequiredArgsConstructor
public class BookDeleteController {

    public final BookDeleteService bookDeleteService;

    public ApiResponse<Void> deleteBook(
            @RequestParam String userCd,
            @RequestParam String bookCd
    ) {
        bookDeleteService.deleteBook(userCd, bookCd);
        return ApiResponse.success(null);
    }
}
