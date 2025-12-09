package com.kt.aivle_central_4_8.dto.book.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ModifyRequest {
    private String bookCd;
    private String bookNm;
    private String bookSummaryDc;
    private String bookContentDc;
    private String userCd;
    private String bookGenreFg;
    private String coverFileEn; //url방식
    private String coverCd;
}
