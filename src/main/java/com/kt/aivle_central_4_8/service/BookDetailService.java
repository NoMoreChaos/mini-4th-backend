package com.kt.aivle_central_4_8.service;

import com.kt.aivle_central_4_8.dto.book.response.BookDetailResponse;
import com.kt.aivle_central_4_8.entity.BookEntity;
import com.kt.aivle_central_4_8.entity.CoverEntity;
import com.kt.aivle_central_4_8.entity.UserEntity;
import com.kt.aivle_central_4_8.repository.BookRepository;
import com.kt.aivle_central_4_8.repository.CoverRepository;
import com.kt.aivle_central_4_8.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BookDetailService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final CoverRepository coverRepository;

    // 도서 상세정보 조회 로직
    public BookDetailResponse getBookDetail(Long userCd, Long bookCd){

        // userCd 유효성 검증 (null 또는 빈 문자열인지 확인)
        if(userCd == null){
            throw new RuntimeException("userCd는 필수 입력 값입니다.");
        }

        // bookCd 유효성 검증 (null 또는 빈 문자열인지 확인)
        if(bookCd == null){
            throw new RuntimeException("bookCd는 필수 입력 값입니다.");
        }

        // DB에서 User 조회
        UserEntity user = userRepository.findById(userCd)
                .orElseThrow(() -> new RuntimeException("해당 사용자가 존재하지 않습니다."));

        // DB에서 Book 조회
        BookEntity book = bookRepository.findById(bookCd)
                .orElseThrow(() -> new RuntimeException("해당 도서가 존재하지 않습니다."));

        // DB에서 해당 도서의 Cover 조회
        List<CoverEntity> covers = coverRepository.findAllByBookCd(bookCd);
        if (covers.isEmpty()) {
            throw new RuntimeException("해당 도서의 표지가 존재하지 않습니다.");
        }

        // 선택된 표지 찾기
        CoverEntity selectedCover = covers.stream()
                .filter(cover -> Boolean.TRUE.equals(cover.getCoverSelectYn()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("선택된 표지가 없습니다."));

        // DTO 변환
        BookDetailResponse response = new BookDetailResponse(
                book.getBookCd(),
                book.getBookNm(),
                book.getBookSummaryDc(),
                book.getBookContentDc(),
                book.getUserCd(),
                user.getUserNickNm(),
                book.getBookGenreFg(),
                book.getBookCreateDt(),
                book.getBookModifyDt(),
                selectedCover.getCoverFileEn(),
                selectedCover.getCoverCd()
        );

        // 반환
        return response;
    }
}
