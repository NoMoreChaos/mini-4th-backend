package com.kt.aivle_central_4_8.dto.book.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BookCreateRequest {
    @NotBlank
    private String userCd;          // 생성자 코드
    @NotBlank
    private String bookNm;          // 도서명
    @NotBlank
    private String bookSummaryDc;   // 작품소개 (요약)
    @NotBlank
    private String bookContentDc;   // 내용
    @NotBlank
    private String bookGenreFg;     // 장르
    @NotBlank
    private String coverFileEn;     // 표지 이미지 url

    private String coverPromptDc;   // 표지 생성 프롬프트 내용
}
