package com.Utils;

import com.github.javafaker.Faker;
import java.util.Random;

public class DataGenerator {
    public static Faker faker = new Faker();

    public static String getUserFirstName(){
        return  faker.name().firstName();
    }

    public static String getUserLastName(){
        return  faker.name().lastName();
    }

    public static String getUserJob(){
        return faker.job().title();
    }

    public static String getUserEmail(){
        return  faker.bothify("?????@gmail.com");
    }

    public static int validUserID(){
        Random rand = new Random();
        return rand.nextInt(13);
    }

    public static int invalidUserID(){
        Random rand = new Random();
        return rand.nextInt(1000) + 13;
    }

    public static String getAvatar(){
        return "https://reqres.in/img/faces/12-image.jpg";
    }

    public static String getUrl(){
        return "https://reqres.in/#support-heading";
    }

    public static String getText(){
        return "To keep ReqRes free, contributions towards server costs are appreciated!";
    }
}
