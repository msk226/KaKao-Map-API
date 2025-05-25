package kr.kakaomap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients // Feign 클라이언트 활성화
@SpringBootApplication
public class KakaoMapApplication {

    public static void main(String[] args) {
        SpringApplication.run(KakaoMapApplication.class, args);
    }

}
