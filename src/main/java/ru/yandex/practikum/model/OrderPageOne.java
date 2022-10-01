package ru.yandex.practikum.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPageOne {
    //локаторы
    //форма для заполнения данных заказа - 1 страница
    private static final By ORDER_FORM_1 = By.cssSelector(".Order_Content__bmtHS");
    //поле ввода Имя
    private static final By NAME_INPUT = By.xpath(".//input[@placeholder='* Имя']");
    //Поле ввода Фамилия
    private static final By LAST_NAME_INPUT = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле ввода Адрес
    private static final By ADDRESS_INPUT = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Выпадающий список Станция метро
    private static final By SUBWAY_LIST = By.xpath(".//input[@placeholder='* Станция метро']");
    //Поле ввода Телефон
    private static final By PHONE_INPUT = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");


    //конструктор класса:
    private WebDriver driver;
    public OrderPageOne(WebDriver driver) {
        this.driver = driver;
    }

    public void fillNameInput(String name) {
       driver.findElement(NAME_INPUT).sendKeys(name);
    }
    public void fillLastNameInput(String lastname) {
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastname);
    }
    public void fillAddressInput(String address) {
        driver.findElement(ADDRESS_INPUT).sendKeys(address);
    }
    public void fillSubwayList(By subwayStation) {
        driver.findElement(SUBWAY_LIST).click();
        driver.findElement(subwayStation).click();
    }
    public void fillPhoneInput(String phone) {
        driver.findElement(PHONE_INPUT).sendKeys(phone);
    }
    //Геттер для формы заказа на странице 1
 public By getOrderForm1(){
       return ORDER_FORM_1;
    }
//    //Геттер для поля ввода Имя
//    public By getNameInput(){
//        return NAME_INPUT;
//    }
//    //Геттер для поля ввода Фамилия
//    public By getLastNameInput(){
//        return LAST_NAME_INPUT;
//    }
//    //Геттер для поля ввода Адрес
//    public By getAddressInput(){
//        return ADDRESS_INPUT;
//    }
//    //Геттер для поля списка Станции метро
//    public By getSubwayList(){
//        return SUBWAY_LIST;
//    }
//    //Геттер для поля ввода Телефон
//    public By getPhoneInput(){
//        return PHONE_INPUT;
//    }
}
