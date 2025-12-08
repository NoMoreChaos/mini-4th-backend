package com.kt.aivle_central_4_8.repository;

import com.kt.aivle_central_4_8.entity.CoverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoverRepository extends JpaRepository<CoverEntity, String> {

    List<CoverEntity> findAllByBookCd(String bookCd);

    void deleteAllByBookCd(String bookCd);
  
    // 숫자로 비교했을 때 제일 큰 cover_cd 가져오기
    @Query(
            value = "SELECT cover_cd " +
                    "FROM cover_tb " +
                    "ORDER BY CAST(SUBSTRING(cover_cd, 2) AS UNSIGNED) DESC " +
                    "LIMIT 1",
            nativeQuery = true
    )
    String findLastCoverCd();   // 없으면 null
}
