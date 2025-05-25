package kr.kakaomap.presentation;

import kr.kakaomap.application.PlaceSearchService;
import kr.kakaomap.presentation.dto.KaKaoSearchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KaKaoMapController {

    private final PlaceSearchService placeSearchService;

    @GetMapping("/search")
    public KaKaoSearchResponse search(@RequestParam String keyword,
                                      @RequestParam(name = "category_group_code") String categoryGroupCode) {
        return placeSearchService.search(keyword, categoryGroupCode);
    }
}
