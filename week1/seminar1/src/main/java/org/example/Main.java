package org.example;

import org.example.classes.Person;
import org.example.classes.PersonBuilder;

public class Main {
    public static void main(String[] args) {
        //Person 클래스의 객체 생성
//        Person person = new Person();
        Person person = new Person("garden", 20, "female");
        //Person 클래스 내부 메소드 호출
        person.walk();

        System.out.println(person.getName());

        person.setName("정원");
        System.out.println(person.getName());

        Person.run();

        Person personWithBuilder = new PersonBuilder()
                .name("윤정원")
                .age(24)
                .sex("female")
                .build();

        System.out.println(personWithBuilder.getName());

//        personWithBuilder.setName("정원");


        System.out.println("안녕하세요"); //매개변수가 문자열로 전달
        System.out.println(1); //매개변수가 숫자로 전달
        System.out.println(true); //배개변수가 boolean 값으로 전달
    }
}