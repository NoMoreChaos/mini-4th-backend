package com.kt.aivle_central_4_8.repository;

import com.kt.aivle_central_4_8.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ModifyBookRepository extends JpaRepository<BookEntity, String> {
    @Query("select b from BookEntity b where b.bookCd = :bookCd")
    BookEntity getBook(String bookCd);
    @Query("select u.userNickNm from UserEntity u where u.userCd = :userCd")
    String getUserNickName(String userCd);

}
