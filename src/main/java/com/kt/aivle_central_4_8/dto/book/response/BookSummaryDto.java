package com.kt.aivle_central_4_8.dto.book.response;

import com.kt.aivle_central_4_8.entity.BookEntity;
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

    public static BookSummaryDto from(BookEntity entity) {
        return new BookSummaryDto(
                entity.getBookCd(),
                entity.getBookNm(),
                entity.getBookSummaryDc(),
                entity.getBookGenreFg(),
                entity.getBookCreateDt().toString(),
                entity.getBookModifyDt().toString()
        );
    }
}
