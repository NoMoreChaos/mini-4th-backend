package com.kt.aivle_central_4_8.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "book_tb")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_cd", nullable = false, length = 36)
    private String bookCd;

    @Column(name = "book_nm", nullable = false, length = 200)
    private String bookNm;

    @Column(name = "book_summary_dc", nullable = false, columnDefinition = "TEXT")
    private String bookSummaryDc;

    @Column(name = "book_content_dc", nullable = false, columnDefinition = "TEXT")
    private String bookContentDc;

    @Column(name = "book_genre_fg", nullable = false, length = 20)
    private String bookGenreFg;

    @Column(name = "book_create_dt", nullable = false)
    private LocalDateTime bookCreateDt;

    @Column(name = "book_modify_dt")
    private LocalDateTime bookModifyDt;

    @Column(name = "user_cd", nullable = false, length = 36)
    private String userCd;

}
 