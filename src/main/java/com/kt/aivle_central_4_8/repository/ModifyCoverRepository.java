package com.kt.aivle_central_4_8.repository;

import com.kt.aivle_central_4_8.entity.CoverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModifyCoverRepository extends JpaRepository<CoverEntity, String>  {

    @Query("select c from CoverEntity c where c.bookCd = :bookCd")
    List<CoverEntity> getCoverList(String bookCd);
    @Query("select c.coverFileEn from CoverEntity c where c.bookCd = :bookCd and c.coverSelectYn is true")
    String getCover(String bookCd);
    @Query("select c.coverCd from CoverEntity c where c.bookCd = :bookCd and c.coverSelectYn is true")
    String getCoverCd(String bookCd);
    @Query("select c from CoverEntity c where c.bookCd = :bookCd")
    CoverEntity getCoverEntity(String bookCd);


}
