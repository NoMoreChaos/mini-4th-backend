package com.kt.aivle_central_4_8.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

    @Id
    @Column(name = "user_cd", nullable = false, length = 36)
    private String userCd;

    @Column(name = "user_email_dc", nullable = false, length = 150)
    private String userEmailDc;

    @Column(name = "user_pw_dc", nullable = false, length = 300)
    private String userPwDc;

    @Column(name = "user_nick_nm", nullable = false, length = 20)
    private String userNickNm;

    @Column(name = "user_join_dt", nullable = false)
    private LocalDateTime userJoinDt;

    @Column(name = "user_modify_dt")
    private LocalDateTime userModifyDt;
}
