package com.kt.aivle_central_4_8.service;

import com.kt.aivle_central_4_8.dto.ApiResponse;
import com.kt.aivle_central_4_8.dto.book.request.ModifyRequest;
import com.kt.aivle_central_4_8.dto.book.response.ModifyLoadDto;
import com.kt.aivle_central_4_8.entity.BookEntity;
import com.kt.aivle_central_4_8.entity.CoverEntity;
import com.kt.aivle_central_4_8.repository.ModifyBookRepository;
import com.kt.aivle_central_4_8.repository.ModifyCoverRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.*;

@Service
@AllArgsConstructor
public class ModifyService {
    private final ModifyCoverRepository modifyCoverRepository;
    private final ModifyBookRepository modifyBookRepository;

    public ModifyLoadDto getModifier(String bookCd){
        var book = modifyBookRepository.getBook(bookCd);
        var historyImageList = modifyCoverRepository.getCoverList(bookCd);
        List<Map<String, String>> historyList = new ArrayList<>();
        for(var cover : historyImageList){
            Map<String, String> data = HashMap.newHashMap(2);
            data.put("coverFileEn", cover.getCoverFileEn());
            data.put("coverSelectYn", cover.getCoverSelectYn().toString());
            historyList.add(data);
        }
        return ModifyLoadDto.builder()
                .bookCd(bookCd)
                .bookNm(book.getBookNm())
                .bookSummaryDc(book.getBookSummaryDc())
                .bookContentDc(book.getBookContentDc())
                .userCd(book.getUserCd())
                .userNickNm(modifyBookRepository.getUserNickName(book.getUserCd()))
                .bookGenreFg(book.getBookGenreFg())
                .coverFileEn(modifyCoverRepository.getCover(bookCd))
                .coverCd(modifyCoverRepository.getCoverCd(bookCd))
                .historyImageList(historyList).build();
    }

    public Boolean putModified(ModifyRequest request){
        BookEntity book = modifyBookRepository.getBook(request.getBookCd());
        book.setBookCd(request.getBookCd());
        book.setBookSummaryDc(request.getBookSummaryDc());
        book.setBookGenreFg(request.getBookGenreFg());
        book.setBookNm(request.getBookNm());
        book.setUserCd(request.getUserCd());
        book.setBookContentDc(request.getBookContentDc());

        String coverFileEn = convertImageUrlToBase64(request.getCoverFileEn());
        CoverEntity cover = new CoverEntity();
        List<CoverEntity> coverList = modifyCoverRepository.getCoverList(request.getBookCd());

        for(CoverEntity c : coverList){
            if(c.getCoverFileEn().equals(coverFileEn)){
                cover = c;
            }
            c.setCoverSelectYn(false);
        }
        cover.setBookCd(request.getBookCd());
        cover.setCoverFileEn(coverFileEn);
        cover.setCoverSelectYn(true);
        modifyBookRepository.save(book);
        modifyCoverRepository.save(cover);

        return true;
    }
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
                return "data:image/png;base64," + Base64.getEncoder().encodeToString(imageBytes);
            }
        } catch (Exception e) {
            throw new RuntimeException("image URL to Base64 변환중 오류 발생: " + imageUrl, e);
        }
    }
}
