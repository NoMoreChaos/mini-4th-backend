package com.kt.aivle_central_4_8.repository;

import com.kt.aivle_central_4_8.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    @Query("SELECT COUNT(b) FROM BookEntity b")
    int countAllBooks();

    @Query("SELECT b FROM BookEntity b " +
            "WHERE (:genre IS NULL OR b.bookGenreFg = :genre) " +
            "ORDER BY b.bookCreateDt DESC")
    List<BookEntity> findBooks(String genre, Pageable pageable);

    @Query("SELECT COUNT(b) FROM BookEntity b " +
            "WHERE (:genre IS NULL OR b.bookGenreFg = :genre)")
    int countBooks(String genre);
}
