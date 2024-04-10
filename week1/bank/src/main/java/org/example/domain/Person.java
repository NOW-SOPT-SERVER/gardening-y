package org.example.domain;

public class Person {
    private String firstName;
    private String lastName;
    private String birth;
    private Gender gender;
    private String phoneNumber;

    public Person(String firstName, String lastName, String birth, Gender gender, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth = birth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirth() {
        return birth;
    }

    public Gender getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
