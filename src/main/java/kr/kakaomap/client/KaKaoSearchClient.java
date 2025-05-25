package kr.kakaomap.client;

import kr.kakaomap.config.KaKaoFeignConfig;
import kr.kakaomap.presentation.dto.KaKaoSearchResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "kakaoSearchClient",
        url = "https://dapi.kakao.com",
        configuration = KaKaoFeignConfig.class
)
public interface KaKaoSearchClient {

    /*
        * 키워드로 장소를 검색합니다.
        * @param query 검색할 키워드
        * @param page 페이지 번호 (기본값: 1)
        * @param size 페이지당 결과 수 (기본값: 10)
        * @return 카카오 API로부터 받은 장소 검색 결과
     */
    @GetMapping("/v2/local/search/keyword.json")
    KaKaoSearchResponse searchKeyword(
            @RequestParam("query") String query,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size
    );

    /*
        * 카테고리 그룹 코드에 해당하는 장소를 검색합니다.
        * @param categoryGroupCode 카테고리 그룹 코드 (예: SW8 - 지하철역)
        * @param x 검색 중심 좌표의 경도
        * @param y 검색 중심 좌표의 위도
        * @param radius 검색 반경 (미터 단위)
        * @param sort 정렬 기준 (기본값: distance)
        * @param page 페이지 번호 (기본값: 1)
        * @param size 페이지당 결과 수 (기본값: 10)
        * @return 카카오 API로부터 받은 장소 검색 결과
     */
    @GetMapping("/v2/local/search/category.json")
    KaKaoSearchResponse searchByCategory(
            @RequestParam("category_group_code") String categoryGroupCode,
            @RequestParam("x") double x,
            @RequestParam("y") double y,
            @RequestParam("radius") int radius,
            @RequestParam(value = "sort", defaultValue = "distance") String sort,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size
    );
}
