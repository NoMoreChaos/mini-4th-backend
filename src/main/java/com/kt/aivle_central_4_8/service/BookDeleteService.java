package com.kt.aivle_central_4_8.service;

import com.kt.aivle_central_4_8.entity.BookEntity;
import com.kt.aivle_central_4_8.entity.UserEntity;
import com.kt.aivle_central_4_8.repository.BookRepository;
import com.kt.aivle_central_4_8.repository.CoverRepository;
import com.kt.aivle_central_4_8.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class BookDeleteService {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final CoverRepository coverRepository;

    // 도서 삭제 로직
    public void deleteBook(String userCd, String bookCd){

        // userCd 유효성 검증 (null 또는 빈 문자열인지 확인)
        if(userCd == null || userCd.isEmpty()){
            throw new RuntimeException("userCd는 필수 입력 값입니다.");
        }

        // bookCd 유효성 검증 (null 또는 빈 문자열인지 확인)
        if(bookCd == null || bookCd.isEmpty()){
            throw new RuntimeException("bookCd는 필수 입력 값입니다.");
        }

        // DB에서 User 조회
        UserEntity user = userRepository.findById(userCd)
                .orElseThrow(() -> new RuntimeException("해당 사용자가 존재하지 않습니다."));

        // DB에서 Book 조회
        BookEntity book = bookRepository.findById(bookCd)
                .orElseThrow(() -> new RuntimeException("해당 도서가 존재하지 않습니다."));

        // Book의 소유자가 User인지 확인
        if(!userCd.equals(book.getUserCd())){
            throw new RuntimeException("해당 책을 삭제할 권한이 없습니다.");
        }

        // bookCd가 일치하는 모든 표지 삭제
        coverRepository.deleteAllByBookCd(bookCd);

        // 도서 삭제
        bookRepository.deleteById(bookCd);
    }
}
