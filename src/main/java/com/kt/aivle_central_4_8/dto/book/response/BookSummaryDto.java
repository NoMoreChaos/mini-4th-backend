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
    private String coverFileEn;   // book_cover의 선택된 커버 URL/파일명

    /**
     * BookEntity + 선택된 커버 URL(or 파일명)으로 DTO 생성
     *
     * @param entity     BookEntity
     * @param coverFileEn 선택된 커버의 URL 또는 파일 엔코딩 값 (없으면 null 가능)
     */
    public static BookSummaryDto from(BookEntity entity, String coverFileEn) {
        return new BookSummaryDto(
                entity.getBookCd(),
                entity.getBookNm(),
                entity.getBookSummaryDc(),
                entity.getBookGenreFg(),
                entity.getBookCreateDt().toString(),
                entity.getBookModifyDt().toString(),
                coverFileEn
        );
    }
}
