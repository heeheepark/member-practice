# Member CRUD Practice

Spring Boot와 Spring Data JPA를 사용하여 회원(Member) CRUD 기능을 구현한 REST API 프로젝트입니다.
회원 등록(Create), 조회(Read), 수정(Update), 삭제(Delete) 기능을 구현하며 REST API와 JPA의 기본 동작을 학습했습니다.

## Tech Stack

* Java 21
* Spring Boot
* Spring Data JPA
* MySQL
  
## Features

* 회원 등록 (Create)
* 전체 회원 조회 (Read All)
* 회원 단건 조회 (Read One)
* 회원 정보 수정 (Update)
* 회원 삭제 (Delete)

## API

| Method | URL                  | Description |
| ------ | -------------------- | ----------- |
| POST   | `/member`            | 회원 등록       |
| GET    | `/member`            | 전체 회원 조회    |
| GET    | `/member/{memberId}` | 회원 단건 조회    |
| PUT    | `/member/{memberId}` | 회원 정보 수정    |
| DELETE | `/member/{memberId}` | 회원 삭제       |

## Entity

### Member

| Field | Type   |
| ----- | ------ |
| id    | Long   |
| name  | String |
| email | String |

