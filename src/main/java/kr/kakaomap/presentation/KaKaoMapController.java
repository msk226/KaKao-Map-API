package kr.kakaomap.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class KaKaoMapController {

    @GetMapping("/api/health-check")
    public String healthCheck() {
        return "Kakao Map API is running!";
    }


}
