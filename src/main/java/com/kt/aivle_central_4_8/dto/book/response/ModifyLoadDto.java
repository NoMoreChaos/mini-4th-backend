package com.kt.aivle_central_4_8.dto.book.response;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModifyLoadDto {
    private String bookCd;
    private String bookNm;
    private String bookSummaryDc;
    private String userCd;
    private String userNickNm;
    private String bookGenreFg;
    private String coverFileEn;
    private List<Map<String, String>> historyImageList;
    private String coverCd;
}
