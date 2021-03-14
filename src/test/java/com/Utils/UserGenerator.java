package com.Utils;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {
    public static Faker faker = new Faker();

    public static String getUserName(){
        return  faker.name().firstName();
    }

    public static String getUserJob(){
        return faker.job().title();
    }

    public static int validUserID(){
        return Integer.parseInt(faker.regexify("[1-12]{1}"));
    }

    public static int invalidUserID(){
        int id = 0;
        while (id < 13) {
            id = Integer.parseInt(faker.regexify("[1-9]{2}"));
            break;
        }
        return id;
    }
}
