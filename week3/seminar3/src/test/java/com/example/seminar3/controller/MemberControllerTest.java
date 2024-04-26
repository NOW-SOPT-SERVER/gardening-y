package com.example.seminar3.controller;

import com.example.seminar3.config.ApiTest;
import com.example.seminar3.domain.Part;
import com.example.seminar3.dto.request.MemberCreateRequest;
import com.example.seminar3.repository.MemberRepository;
import com.example.seminar3.service.MemberService;
import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

class MemberControllerTest extends ApiTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Nested // 여러 테스트?
    @DisplayName("멤버 생성 테스트")
    public class CreateMember {

        @Test
        @DisplayName("요청 성공 테스트")
        public void createMemberSuccess() throws Exception {
            // given
            final var request = new MemberCreateRequest(
                    "윤정원",
                    Part.SERVER,
                    20
            );

            // when
            final var response = RestAssured.given()
                    .log().all()
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
//                    .contentType("application/json")
                    .body(request)
                    .when()
                    .post("/api/v1/member")
                    .then().log().all().extract();
//                   .statusCode(201)
//                   .extract()
//                   .jsonPath()
//                   .getObject("data", MemberCreateDto.class);

            // then
            Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
        }
    }
}