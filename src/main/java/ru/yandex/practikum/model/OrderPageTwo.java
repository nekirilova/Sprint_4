package ru.yandex.practikum.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPageTwo {
    //локаторы
    //форма для заполнения данных заказа - 2 страница

    //поле для выбора даты
    private static final By DATE_INPUT = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //поле для выбора срока аренды
    private static final By RENT_DAYS = By.xpath(".//div[@class='Dropdown-placeholder']");
    //поле для выбора цвета самоката
    private static final By SCOOTER_COLOR = By.xpath("//div/label[1]/text()");
    //поле для ввода комментария
    private static final By COMMENT = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //кнопка заказа самоката
    private static final By ORDER_BUTTON = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");


    private WebDriver driver;
    public OrderPageTwo(WebDriver driver) {

        this.driver = driver;
    }

    //Геттер для поля выбора дата
    public By getDateInput(){

        return DATE_INPUT;
    }

    //Геттер для поля выбора срока аренды
    public By getRentDays(){

        return RENT_DAYS;
    }

    //Геттер для поля выбора цвета
    public By getScooterColor(){

        return SCOOTER_COLOR;
    }

    //Геттер для поля ввода комментария
    public By getComment(){

        return COMMENT;
    }
}
