package com.kt.aivle_central_4_8.dto.book.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookListRequest {

    private int limit = 10;
    private int page = 1;

    private String userCd;       // 필터링에는 사용 X
    private String bookGenreFg;  // Optional 장르 필터
}
