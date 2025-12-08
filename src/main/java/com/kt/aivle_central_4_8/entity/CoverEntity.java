package com.kt.aivle_central_4_8.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cover_tb")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoverEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cover_cd", nullable = false)
    private Long coverCd;

    @Column(name = "book_cd", nullable = false)
    private Long bookCd;

    @Column(name = "cover_file_en", columnDefinition = "TEXT", nullable = false)
    @Lob
    private String coverFileEn;

    @Column(name = "cover_prompt_dc", columnDefinition = "TEXT")
    private String coverPromptDc;

    @Column(name = "cover_select_yn", nullable = false)
    private Boolean coverSelectYn;
}
