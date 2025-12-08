//BookController
package com.kt.aivle_central_4_8.controller;

import com.kt.aivle_central_4_8.dto.ApiResponse;
import com.kt.aivle_central_4_8.dto.book.request.BookListRequest;
import com.kt.aivle_central_4_8.dto.book.response.BookListResponse;
import com.kt.aivle_central_4_8.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;

    @GetMapping("/books")
    public ApiResponse<BookListResponse> getBooks(BookListRequest req) {
        return ApiResponse.success(bookService.getBookList(req));
    }
}
