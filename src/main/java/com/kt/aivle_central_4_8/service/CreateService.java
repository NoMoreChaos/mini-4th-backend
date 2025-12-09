package com.kt.aivle_central_4_8.service;

import com.kt.aivle_central_4_8.dto.book.request.BookCreateRequest;
import com.kt.aivle_central_4_8.entity.BookEntity;
import com.kt.aivle_central_4_8.entity.CoverEntity;
import com.kt.aivle_central_4_8.repository.BookRepository;
import com.kt.aivle_central_4_8.repository.CoverRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class CreateService {
    private final BookRepository bookRepository;
    private final CoverRepository coverRepository;

    // 책 등록
    @Transactional
    public String createBook(BookCreateRequest dto){

        //  마지막 book_cd 조회
        String lastBookCd = bookRepository.findLastBookCd();
        // 다음 ID 계산
        String nextBookCd;
        if(lastBookCd == null) {
            nextBookCd = "B0001";
        }
        else {
            String numberPart = lastBookCd.substring(1); // B0001 -> 0001로 B제거
            long nextNumber = Long.parseLong(numberPart) + 1; // 정수(long) 로 바꾼 뒤 +1 증가
            String nextNumberStr = String.format("%04d", nextNumber); // 다시 문자열 "0002" 로 바꾸는 코드
            nextBookCd = "B"+nextNumberStr;
        }

        // BookEntity 생성 (Dto -> Entity 매핑)
        BookEntity book = new BookEntity();
        book.setBookCd(nextBookCd);
        book.setUserCd(dto.getUserCd());
        book.setBookNm(dto.getBookNm());
        book.setBookSummaryDc(dto.getBookSummaryDc());
        book.setBookContentDc(dto.getBookContentDc());
        book.setBookGenreFg(dto.getBookGenreFg());
        book.setBookCreateDt(LocalDateTime.now());
        book.setBookModifyDt(LocalDateTime.now());

        bookRepository.save(book);

        //  마지막 book_cd 조회
        String lastCoverCd = coverRepository.findLastCoverCd();
        // 다음 ID 계산
        String nextCoverCd;
        if(lastCoverCd == null) {
            nextCoverCd = "C0001";
        }
        else {
            String numberPart = lastCoverCd.substring(1); // C0001 -> 0001로 C제거
            long nextNumber = Long.parseLong(numberPart) + 1; // 정수(long) 로 바꾼 뒤 +1 증가
            String nextNumberStr = String.format("%04d", nextNumber); // 다시 문자열 "0002" 로 바꾸는 코드
            nextCoverCd = "C"+nextNumberStr;
        }

        // URL -> Base64 변환
        String base64Image = convertImageUrlToBase64(dto.getCoverFileEn());
        // 변환이 잘 되는지 확인
        System.out.println("before insert length = " + base64Image.length());

        // CoverEntity 생성
        CoverEntity cover = CoverEntity.builder()
                .coverCd(nextCoverCd)
                .bookCd(nextBookCd)
                .coverFileEn(base64Image) // (이미지 Base64 저장)
                .coverPromptDc(dto.getCoverPromptDc())
                .coverSelectYn(true)
                .build();

        coverRepository.save(cover);

        return nextBookCd;
    }

    // 이미지 변환 메서드 url -> base64
    private String convertImageUrlToBase64(String imageUrl) {
        try {
            // 이미지 url 연결
            URI uri = URI.create(imageUrl);
            URL url = uri.toURL();

            // URL로 스트림 열기
            try (InputStream inputStream = url.openStream();
                 ByteArrayOutputStream outputStream = new ByteArrayOutputStream()
            ) {
                // 버퍼로 스트림에서 바이트 읽기 8KB짜리 임시 메모리 공간
                byte[] buffer = new byte[8192];
                int bytesRead;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }

                // 이미지 바이트 배열
                byte[] imageBytes = outputStream.toByteArray();

                // Base64 문자열로 인코딩
                String base64Img = Base64.getEncoder().encodeToString(imageBytes);

                return "data:image/png;base64," + base64Img;
            }
        } catch (Exception e) {
            throw new RuntimeException("image URL to Base64 변환중 오류 발생: " + imageUrl, e);
        }
    }
}
