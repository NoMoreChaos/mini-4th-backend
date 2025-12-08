package com.kt.aivle_central_4_8.dto.book.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class BookListResponse {
    private int totalCount;
    private List<BookSummaryDto> bookList;
}

