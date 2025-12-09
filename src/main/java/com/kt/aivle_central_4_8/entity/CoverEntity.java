package com.kt.aivle_central_4_8.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cover_tb")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoverEntity {
    @Id
    @Column(name = "cover_cd", nullable = false, length = 36)
    private String coverCd;

    @Column(name = "book_cd", nullable = false, length = 36)
    private String bookCd;

    @Column(name = "cover_file_en", columnDefinition = "LONGTEXT", nullable = false)
    @Lob
    private String coverFileEn;

    @Column(name = "cover_prompt_dc", columnDefinition = "TEXT")
    private String coverPromptDc;

    @Column(name = "cover_select_yn", nullable = false)
    private Boolean coverSelectYn;
}
