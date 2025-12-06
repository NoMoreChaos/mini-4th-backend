package com.kt.aivle_central_4_8.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class BookDetailResponse {

    private String bookCd;
    private String bookNm;
    private String bookSummaryDc;
    private String bookContentDc;
    private String userCd;
    private String userNickNm;
    private String bookGenreFg;
    private Date bookCreateDt;
    private Date bookModifyDt;
    private String coverFileEn;
    private String coverCd;
}
