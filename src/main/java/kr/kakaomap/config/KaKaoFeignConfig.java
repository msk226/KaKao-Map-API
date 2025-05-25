package kr.kakaomap.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KaKaoFeignConfig {

    /*
        * Kakao API를 호출하기 위한 Feign 클라이언트 설정 클래스입니다.
        * 이 클래스는 Kakao REST API 키를 사용하여 요청 헤더를 설정합니다.
     */
    @Value("${kakao.rest-api-key}")
    private String kakaoApiKey;


    /*
        * Feign 클라이언트가 Kakao API를 호출할 때 필요한 헤더를 설정합니다.
        * Authorization 헤더에 Kakao REST API 키를 포함시키고,
        * Content-Type 헤더를 application/json으로 설정합니다.
     */
    @Bean
    public RequestInterceptor kakaoRequestInterceptor() {
        return template -> {
            template.header("Authorization", "KakaoAK " + kakaoApiKey);
            template.header("Content-Type", "application/json");
        };
    }
}
