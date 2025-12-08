package com.kt.aivle_central_4_8.repository;

import com.kt.aivle_central_4_8.dto.book.response.BookSummaryDto;
import com.kt.aivle_central_4_8.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, String> {
    @Query("SELECT COUNT(b) FROM BookEntity b")
    int countAllBooks();

    @Query("SELECT b FROM BookEntity b " +
            "WHERE (:genre IS NULL OR b.bookGenreFg = :genre) " +
            "ORDER BY b.bookCreateDt DESC")
    List<BookEntity> findBooks(String genre, Pageable pageable);

    @Query("SELECT COUNT(b) FROM BookEntity b " +
            "WHERE (:genre IS NULL OR b.bookGenreFg = :genre)")
    int countBooks(String genre);


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