package com.Utils;

import com.github.javafaker.Faker;
import java.util.Random;

public class UserGenerator {
    public static Faker faker = new Faker();

    public static String getUserName(){
        return  faker.name().firstName();
    }

    public static String getUserJob(){
        return faker.job().title();
    }

    public static int validUserID(){
        Random rand = new Random();
        return rand.nextInt(13);
    }

    public static int invalidUserID(){
        Random rand = new Random();
        return rand.nextInt(1000) + 13;
    }
}
