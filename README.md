## Kakao 장소 검색 연동 플로우

공연장 이름을 입력받아 해당 공연장의 좌표를 조회하고,
그 좌표를 중심으로 반경 1km 내의 특정 카테고리(예: 지하철역, 편의점) 장소를 검색하는 기능

1. 주의 사항: 카카오 디벨로퍼스 - 내 애플리케이션에서 맵 기능을 활성화 해야함
2. 참고 링크 : https://developers.kakao.com/docs/latest/ko/local/dev-guide

### 전체 요청 흐름
```
[HTTP 요청]
GET /search?keyword=YES24 LIVE HALL&category_group_code=SW8

        ⬇
[KaKaoMapController]
→ keyword(공연장명), categoryGroupCode(검색할 카테고리) 전달

        ⬇
[PlaceSearchService]
→ 1. 공연장 키워드로 장소 검색 → 좌표 추출
→ 2. 좌표 기준 카테고리 장소 검색 수행

        ⬇
[KaKaoSearchClient (Feign)]
→ /v2/local/search/keyword.json
→ /v2/local/search/category.json

        ⬇
[응답]
공연장 기준 반경 1km 내의 장소 리스트 반환
```


### 참고사항
- 카카오 REST API 키는 KaKaoFeignConfig를 통해 헤더로 삽입됨 (Authorization: KakaoAK {API_KEY})
- 검색 반경은 고정값 1000m로 설정
- 반환되는 KaKaoSearchResponse의 documents는 장소 리스트, meta는 페이징 정보 포함


### 인증 및 설정 (application.yml)
``` yaml
kakao:
  rest-api-key: ${KAKAO_REST_API_KEY}
```
