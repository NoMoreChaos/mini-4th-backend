# Book System Backend  
AI 기반 도서관리서비스를 위한 Backend API 서버입니다.  
도서 정보와 표지 데이터를 안정적으로 저장·조회·수정하며  
프론트엔드와 연동되는 REST API를 제공합니다.

Frontend README : [https://github.com/NoMoreChaos/mini-4th-frontend](https://github.com/NoMoreChaos/mini-4th-frontend/blob/main/README.md)

---
## Summary

- 도서/커버 관리에 특화된 REST API 제공  
- base64 이미지 저장 · 사용자별 선택 관리 · 페이징 & 필터링 지원  
- Spring Boot + JPA 기반 데이터 무결성 보장  
---

## Tech Stack
<p>
  <img src="https://img.shields.io/badge/Java_21-007396?style=flat&logo=openjdk&logoColor=white"/>
  <img src="https://img.shields.io/badge/Spring_Boot_3-6DB33F?style=flat&logo=springboot&logoColor=white"/>
  <img src="https://img.shields.io/badge/Spring_Web-6DB33F?style=flat&logo=spring&logoColor=white"/>
  <img src="https://img.shields.io/badge/Spring_Data_JPA-59666C?style=flat&logo=hibernate&logoColor=white"/>
  <img src="https://img.shields.io/badge/Hibernate-59666C?style=flat&logo=hibernate&logoColor=white"/>
  <img src="https://img.shields.io/badge/Lombok-BC2B2B?style=flat&logo=lombok&logoColor=white"/>
  <img src="https://img.shields.io/badge/Gradle-02303A?style=flat&logo=gradle&logoColor=white"/>
  <img src="https://img.shields.io/badge/MariaDB-003545?style=flat&logo=mariadb&logoColor=white"/>
</p>

---

## Project Structure

```
src/main/java/com/kt/aivle_central_4_8
├─ config/          # 전역 설정(CORS, Swagger, 보안, Bean 등록 등)
│
├─ controller/      # REST API 엔드포인트 (요청 처리 → 서비스 호출 → 응답 반환)
│
├─ dto/             # API 요청/응답 데이터 구조(DTO) 모음
│  ├─ book/         # 도서 CRUD 관련 DTO
│  └─ user/         # 사용자 로그인/정보 관련 DTO
│
├─ entity/          # JPA 엔티티 (DB 테이블 매핑)
│
├─ repository/      # DB 접근 계층(JPA Repository)
│
├─ service/         # 비즈니스 로직 계층(도서/사용자 기능 처리)
│
└─ AivleCentral48Application.java   # Spring Boot 메인 실행 파일

```


---

## Database Design (ERD)
![](https://velog.velcdn.com/images/didi_code/post/05b900b6-b0c2-4af2-8ed6-82ad0cca314c/image.png)

본 프로젝트는 도서, 표지 이미지, 사용자 정보를 관리하기 위해  
다음과 같은 3개의 핵심 테이블 구조로 설계되었습니다.

- **USER_TB** : 사용자 정보 저장
- **BOOK_TB** : 도서 기본 정보 및 내용 관리
- **COVER_TB** : 도서 표지 이미지 및 현재 선택 상태 관리

### Entity Relationship
- 1명의 사용자(User)는 여러 도서(Book)를 생성할 수 있음 (1:N)
- 1개의 도서(Book)는 여러 표지(Cover)를 가질 수 있음 (1:N)
- Cover 테이블은 ‘대표 이미지 여부(cover_select_yn)’ 값을 통해 대표 표지를 관리

---

## API Overview
| API 명               | Method | Endpoint                    | 설명 |
|----------------------|--------|------------------------------|-------------------------------------------------------------|
| 사용자 로그인         | POST   | /api/user/login              | 이메일·비밀번호를 입력받아 사용자 인증 수행 |
| 도서 목록 조회        | GET    | /api/books                   | 페이징, 장르 필터링을 포함한 도서 목록 조회 |
| 도서 등록             | POST   | /api/books                   | 새로운 도서 생성 + 표지 이미지(Base64) 저장 |
| 도서 상세 조회        | GET    | /api/books/detail            | 단일 도서의 상세 정보 + 표지 이미지 조회 |
| 도서 삭제             | DELETE | /api/books/delete            | 특정 도서를 삭제 |
| 도서 수정 조회(초기값)| GET    | /api/books/modify/{bookCd}   | 도서 수정 페이지 호출 시 기존 정보 + 커버 히스토리 제공 |
| 도서 수정(저장)       | PUT    | /api/books/modify   | 도서 정보 및 표지 업데이트 내용 저장 |




---

## ⚙ 실행 방법 (Local Setup)

```
1) Gradle 빌드  
        ./gradlew build

2) 애플리케이션 실행  
        ./gradlew bootRun

3) DB 설정(application.yml)
        spring:
          datasource:
            url: jdbc:mariadb://localhost:3306/bookdb
            username: root
            password: yourpassword
          jpa:
            hibernate:
              ddl-auto: update
```
             
