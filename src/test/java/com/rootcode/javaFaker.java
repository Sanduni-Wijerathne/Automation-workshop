package com.rootcode;

import com.github.javafaker.Faker;

public class javaFaker {
    public static void main(String[] args) {

        Faker faker = new Faker();
        String phone_number = faker.phoneNumber().phoneNumber();
        System.out.println(String.format("random phone number is %s",phone_number));

        Faker faker2 = new Faker();
        String address = faker.address().fullAddress();
        System.out.println(String.format("random address is %s",address));
        
    }
}
