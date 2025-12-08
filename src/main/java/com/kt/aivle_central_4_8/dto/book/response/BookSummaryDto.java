package com.kt.aivle_central_4_8.dto.book.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookSummaryDto {

    private String bookCd;
    private String bookNm;
    private String bookSummaryDc;
    private String bookGenreFg;
    private String bookCreateDt;
    private String bookModifyDt;
    private String coverFileEn; // Cover 테이블에서 가져온 실제 base64
}
