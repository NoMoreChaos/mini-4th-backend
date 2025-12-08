package com.kt.aivle_central_4_8.repository;

import com.kt.aivle_central_4_8.dto.book.response.BookSummaryDto;
import com.kt.aivle_central_4_8.entity.BookEntity;
import com.kt.aivle_central_4_8.entity.CoverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, String> {

    // 전체 책 권수
    @Query("SELECT COUNT(b) FROM BookEntity b")
    int countAllBooks();

    //  Book + Cover 조인해서 DTO 로 반환
    @Query("""
        SELECT new com.kt.aivle_central_4_8.dto.book.response.BookSummaryDto(
            b.bookCd,
            b.bookNm,
            b.bookSummaryDc,
            b.bookGenreFg,
            b.bookCreateDt,
            b.bookModifyDt,
            c.coverFileEn
        )
        FROM BookEntity b
        LEFT JOIN CoverEntity c
            ON c.bookCd = b.bookCd
           AND c.coverSelectYn = true
        WHERE (:genre IS NULL OR :genre = '' OR b.bookGenreFg = :genre)
        ORDER BY b.bookCreateDt DESC
        """)
    List<BookSummaryDto> findBooks(String genre, Pageable pageable);

    // 숫자로 비교했을 때 제일 큰 book_cd 가져오기
    @Query(
            value = "SELECT book_cd " +
                    "FROM book_tb " +
                    "ORDER BY CAST(SUBSTRING(book_cd, 2) AS UNSIGNED) DESC " +
                    "LIMIT 1",
            nativeQuery = true
    )
    String findLastBookCd();   // 없으면 null

}