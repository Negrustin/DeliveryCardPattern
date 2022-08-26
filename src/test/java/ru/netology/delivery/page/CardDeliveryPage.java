package ru.netology.delivery.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CardDeliveryPage {

    private final SelenideElement cityInput = $("[data-test-id=city]  input");
    private final SelenideElement nameInput  = $("[data-test-id=name]  input");
    private final SelenideElement phoneInput = $("[data-test-id=phone]  input");
    private final SelenideElement dateInput = $("[data-test-id=date] input");
    private final SelenideElement checkBox = $x("//*[@class = 'checkbox__text']");
    private final SelenideElement button = $x("//span[contains(text(),'Запланировать')]");
    private final SelenideElement rescheduleAMeetingButton = $x("//span[contains(text(),'Перепланировать')]");



    public void setFullNameToInput(String name){
        nameInput.setValue(name);

    }

    public void scheduledWindow(String str) {
        $(".notification__content")
                .shouldBe(Condition.visible,Condition.text(str));
    }
    public void clickToRescheduleAMeetingButton(){
        rescheduleAMeetingButton.click();
    }


    public void setPhoneToInput(String phone){
    phoneInput.setValue(phone);
    }

    public void setDateToDateInput(String date){

        dateInput.doubleClick().sendKeys(Keys.BACK_SPACE);
        dateInput.setValue(date);
    }

    public void setCityToInput(String city){
        cityInput.setValue(city);
    }
    public void clickOnTheCheckBox (){
        checkBox.click();
    }
    public void clickOnTheButton(){
        button.click();
    }



}
