package com.example.carrot.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api() {
        Info info = new Info()
                .title("NOW SOPT 당근 마켓 클론 코딩 API Docs")
                .version("1.0")
                .description("NOW SOPT 2주차 실습 과제 API 명세서입니다.");

        return new OpenAPI()
                .info(info);
    }
}
