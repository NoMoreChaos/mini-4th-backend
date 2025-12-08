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
public class BookService {

    private final BookRepository bookRepository;

    public BookListResponse getBookList(BookListRequest req) {

        int page = req.getPage() - 1;
        int size = req.getLimit();
        var pageable = PageRequest.of(page, size);

        // userCd는 받지만, 조회 조건에는 사용하지 않음
        String genre = req.getBookGenreFg();

        // 전체 책 권수 (장르/사용자 상관 없이 전체)
        int total = bookRepository.countAllBooks();

        // 장르 필터 + 페이지네이션 적용된 책 목록 조회
        List<BookSummaryDto> list = bookRepository
                .findBooks(genre, pageable)
                .stream()
                .map(BookSummaryDto::from)
                .toList();

        return new BookListResponse(total, list);
    }
}
