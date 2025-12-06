package com.kt.aivle_central_4_8.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "BOOK_CD", nullable = false, length = 36)
    private String bookCd;

    @Column(name = "BOOK_NM", nullable = false, length = 200)
    private String bookNm;

    @Column(name = "BOOK_SUMMARY_DC", nullable = false, columnDefinition = "TEXT")
    private String bookSummaryDc;

    @Column(name = "BOOK_CONTENT_DC", nullable = false, columnDefinition = "TEXT")
    private String bookContentDc;

    @Column(name = "BOOK_GENRE_FG", nullable = false, length = 20)
    private String bookGenreFg;

    @Column(name = "BOOK_CREATE_DT", nullable = false)
    private LocalDateTime bookCreateDt;

    @Column(name = "BOOK_MODIFY_DT")
    private LocalDateTime bookModifyDt;

    @Column(name = "USER_CD", nullable = false, length = 36)
    private String userCd;

    @Column(name = "COVER_CD", nullable = false, length = 36)
    private String coverCd;
}
