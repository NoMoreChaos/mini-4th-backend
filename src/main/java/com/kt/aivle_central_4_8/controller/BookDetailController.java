package com.kt.aivle_central_4_8.controller;

import com.kt.aivle_central_4_8.dto.ApiResponse;
import com.kt.aivle_central_4_8.dto.BookDetailResponse;
import com.kt.aivle_central_4_8.repository.BookRepository;
import com.kt.aivle_central_4_8.service.BookDetailService;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

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
