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
    private static final By SCOOTER_COLOR = By.xpath(".//*[@id='black']");
    //поле для ввода комментария
    private static final By COMMENT = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //кнопка заказа самоката
    private static final By ORDER_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //кнопка подтверждения заказа
    private static final By CONFIRM_ORDER = By.xpath(".//div/button[text()='Да']");
    //модальное окно с данными заказа
    private static final By ORDER_MODAL = By.xpath(".//div[text()='Заказ оформлен']");
    private WebDriver driver;
    public OrderPageTwo(WebDriver driver) {

        this.driver = driver;
    }

    public void fillDateInput(By date) {
        driver.findElement(DATE_INPUT).click();
        driver.findElement(date).click();
    }

    public void fillRentDays(By rent) {
        driver.findElement(RENT_DAYS).click();
        driver.findElement(rent).click();
    }

    public void fillScooterColor() {
        driver.findElement(SCOOTER_COLOR).click();

    }
    public void fillComment(String comment) {
        driver.findElement(COMMENT).sendKeys(comment);
    }
    //Геттер для поля выбора дата
//    public By getDateInput(){
//
//        return DATE_INPUT;
//    }
//
//    //Геттер для поля выбора срока аренды
//    public By getRentDays(){
//
//        return RENT_DAYS;
//    }
//
//    //Геттер для поля выбора цвета
//    public By getScooterColor(){
//
//        return SCOOTER_COLOR;
//    }
//
//    //Геттер для поля ввода комментария
//    public By getComment(){
//
//        return COMMENT;
//    }
//
    //геттер для кнопки заказа

    public By getOrderButton() {
        return ORDER_BUTTON;
    }
    //геттер для кнопки подтверждения
    public By getConfirmOrder() {
        return CONFIRM_ORDER;
    }

    //геттер для модального окна об успешном создании заказа
    public By getOrderModal() {
        return ORDER_MODAL;
    }
}
