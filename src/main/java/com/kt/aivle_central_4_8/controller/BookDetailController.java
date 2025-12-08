package com.kt.aivle_central_4_8.controller;

import com.kt.aivle_central_4_8.dto.ApiResponse;
import com.kt.aivle_central_4_8.dto.book.response.BookDetailResponse;
import com.kt.aivle_central_4_8.service.BookDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookDetailController {

    public final BookDetailService bookDetailService;

    @GetMapping("/detail")
    public ApiResponse<BookDetailResponse> getBookDetail(
            @RequestParam Long userCd,
            @RequestParam Long bookCd
    ){
        BookDetailResponse response =  bookDetailService.getBookDetail(userCd, bookCd);
        return ApiResponse.success(response);
    }

}
