package com.example.carrot.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public enum Category {
    CATE1("디지털기기"),
    CATE2("생활가전"),
    CATE3("가구/인테리어"),
    CATE4("생활/주방"),
    CATE5("유아동"),
    CATE6("여성의류"),
    CATE7("여성잡화"),
    CATE8("남성패션/잡화"),
    CATE9("뷰티/미용"),
    CATE10("스포츠/레저"),
    CATE11("취미/게임/음반"),
    CATE12("도서"),
    CATE13("티켓/교환권"),
    CATE14("가공식품"),
    CATE15("반려동물용품"),
    CATE16("식물"),
    CATE17("기타 중고물품"),
    CATE18("삽니다");

    private final String kor;
}
