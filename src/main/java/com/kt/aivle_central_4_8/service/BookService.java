package com.kt.aivle_central_4_8.service;

import com.kt.aivle_central_4_8.dto.book.request.BookListRequest;
import com.kt.aivle_central_4_8.dto.book.response.BookListResponse;
import com.kt.aivle_central_4_8.dto.book.response.BookSummaryDto;
import com.kt.aivle_central_4_8.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService { //

    private final BookRepository bookRepository;

    public BookListResponse getBookList(BookListRequest req) {

        int page = req.getPage() - 1;
        int size = req.getLimit();
        var pageable = PageRequest.of(page, size);

        // 장르 처리
        String genre = req.getBookGenreFg();
        if (genre != null && genre.isBlank()) genre = null;

        // 전체 책 권수
        int total = bookRepository.countAllBooks();

        // Repository 가 DTO 형태로 반환하므로 그대로 사용
        List<BookSummaryDto> list = bookRepository.findBooks(genre, pageable);

        return new BookListResponse(total, list);
    }
}
