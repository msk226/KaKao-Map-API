package kr.kakaomap.application;

import kr.kakaomap.client.KaKaoSearchClient;
import kr.kakaomap.presentation.dto.KaKaoSearchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaceSearchService {

    private final KaKaoSearchClient kaKaoSearchClient;
    private static final String CATEGORY_GROUP_CODE = "SW8";

    /**
     * 주어진 키워드로 카카오 API를 통해 장소를 검색합니다.
     *
     * @param keyword 검색할 키워드
     * @return 카카오 API로부터 받은 장소 검색 결과
     */
    public KaKaoSearchResponse search(String keyword) {
        // 공연장의 좌표를 가져오기 위해 키워드로 검색
        KaKaoSearchResponse venueResult = kaKaoSearchClient.searchKeyword(
                keyword, 1, 10);

        // 공연장의 좌표 획득
        KaKaoSearchResponse.Document venue = venueResult.getDocuments().get(0);
        double x = Double.parseDouble(venue.getX());
        double y = Double.parseDouble(venue.getY());


        // 공연장 좌표를 기준으로 카테고리 검색 카테고리는 아래 주석 참고
        return kaKaoSearchClient.searchByCategory(
                CATEGORY_GROUP_CODE, x, y, 1000, "distance", 1, 10);
    }

//    MT1	대형마트
//    CS2	편의점
//    PS3	어린이집, 유치원
//    SC4	학교
//    AC5	학원
//    PK6	주차장
//    OL7	주유소, 충전소
//    SW8	지하철역
//    BK9	은행
//    CT1	문화시설
//    AG2	중개업소
//    PO3	공공기관
//    AT4	관광명소
//    AD5	숙박
//    FD6	음식점
//    CE7	카페
//    HP8	병원
//    PM9	약국
}
