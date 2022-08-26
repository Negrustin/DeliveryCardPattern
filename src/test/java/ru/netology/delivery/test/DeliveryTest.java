package ru.netology.delivery.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.delivery.page.CardDeliveryPage;
import ru.netology.delivery.data.DataGenerator;

import java.text.ParseException;
import static com.codeborne.selenide.Selenide.*;

public class DeliveryTest {
    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }
    @Test
    @DisplayName("Should successful plan and replan meeting")
    void shouldSuccessfulPlanAndReplanMeeting() throws ParseException {
        CardDeliveryPage deliveryPage = new CardDeliveryPage();
        var validUser = DataGenerator.Registration.generateUser("ru");
        var firstMeetingDate = DataGenerator.generateDate(36);
        var secondMeetingDate = DataGenerator.generateDate(20);

        deliveryPage.setCityToInput(validUser.getCity());
        deliveryPage.setDateToDateInput(firstMeetingDate);
        deliveryPage.setFullNameToInput(validUser.getName());
        deliveryPage.setPhoneToInput(validUser.getPhone());
        deliveryPage.clickOnTheCheckBox();
        deliveryPage.clickOnTheButton();

        deliveryPage.scheduledWindow("Встреча успешно запланирована на " + firstMeetingDate);

        deliveryPage.setDateToDateInput(secondMeetingDate);

        deliveryPage.clickOnTheButton();
        deliveryPage.clickToRescheduleAMeetingButton();

        deliveryPage.scheduledWindow("Встреча успешно запланирована на " + secondMeetingDate);
    }

}
