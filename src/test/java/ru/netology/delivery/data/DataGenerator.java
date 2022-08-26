package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class DataGenerator {
    private DataGenerator() {
    }



    public static String generateDate(int shift) throws ParseException {
        Faker faker = new Faker();

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        String firstDateString = date.plusDays(3).format(formatters);
        String secondDateString = date.plusDays(shift).format(formatters);


        java.util.Date startDate = new SimpleDateFormat("dd.MM.yyyy").parse(firstDateString);
        java.util.Date endDate = new SimpleDateFormat("dd.MM.yyyy").parse(secondDateString);

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String randomDate = sdf.format(faker.date().between(startDate,endDate));

        return randomDate;
    }


    public static String generateCity() {
        List<String> towns = new ArrayList<>();
        towns.add("Москва");
        towns.add("Петрозаводск");
        towns.add("Йошкар-Ола");
        towns.add("Ставрополь");
        towns.add("Вологда");
        towns.add("Ростов-на-Дону");
        towns.add("Челябинск");
        towns.add("Биробиджан");
        towns.add("Санкт-Петербург");
        towns.add("Новосибирск");
        towns.add("Иркутск");

        Random random = new Random();
        String city = towns.get(random.nextInt(towns.size()));
        return city;
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String name = faker.name().fullName();
        return name;
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String phone = faker.phoneNumber().phoneNumber();

        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            UserInfo user = new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
            return user;
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
