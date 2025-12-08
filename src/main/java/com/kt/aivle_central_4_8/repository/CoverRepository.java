package com.kt.aivle_central_4_8.repository;

import com.kt.aivle_central_4_8.entity.CoverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoverRepository extends JpaRepository<CoverEntity, Long> {

    List<CoverEntity> findAllByBookCd(Long bookCd);

    void deleteAllByBookCd(Long bookCd);
}
