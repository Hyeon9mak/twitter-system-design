# 트위터 시스템 디자인 테스트 (진행중)

## 소개

> [코맹탈출 채널의 트위터 시스템 디자인 완전정복 | 1억 유저 처리의 비밀](https://www.youtube.com/watch?v=6QwqtdBx0oE) 영상을 보고 간소하게 테스트 해본 내용입니다.

영상 내용에 따른 3가지 시스템 디자인을 브랜치 별로 나누어 두었습니다.

- `simple-tweet`: 트윗 포스트를 간단하게 만들고, 피드 요청시 복잡성 처리
- `simple-feed`: 피드 요청을 간단하게 만들고, 트윗 포스트시 복잡성 처리
- `simple-feed-and-influencer`: 피드 요청을 간단하게 만들고, 트윗 포스트시 복잡성 처리, 인플루언서 처리

<br>

## 로컬 빌드

1. `/docker/docker-compose.yml` 를 통해 영속계층을 준비합니다.
2. `./gradlew clean build` 명령을 통해 스프링 프로젝트를 실행합니다.

<br>

## 프로젝트 설정 및 테스트 환경

- SpringBoot 2.7.8
- Kotlin 1.7
- JAVA 17
- mariadb 10.5.18
- CPU Apple M1 Pro / Memory 32GB / OS Ventura 13.1
