//UserRepository
//- UserEntity에 대한 디비 조회 기능을 제공하는 JPA 리포지토리
package com.kt.aivle_central_4_8.repository;

import java.util.Optional;

import com.kt.aivle_central_4_8.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    // 이메일 + 비밀번호로 사용자 조회
    Optional<UserEntity> findByUserEmailDcAndUserPwDc(String userEmailDc, String userPwDc);
}