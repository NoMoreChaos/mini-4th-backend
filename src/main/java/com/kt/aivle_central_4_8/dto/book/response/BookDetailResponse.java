package com.kt.aivle_central_4_8.dto.book.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class BookDetailResponse {

    private Long bookCd;
    private String bookNm;
    private String bookSummaryDc;
    private String bookContentDc;
    private Long userCd;
    private String userNickNm;
    private String bookGenreFg;
    private LocalDateTime bookCreateDt;
    private LocalDateTime bookModifyDt;
    private String coverFileEn;
    private Long coverCd;
}
