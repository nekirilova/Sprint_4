package ru.yandex.practikum.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPageOne {
    //URL первой страницы с формой для заказа
    private final String ORDER_PAGE_URL = "https://qa-scooter.praktikum-services.ru/order";

    //локаторы
    //форма для заполнения данных заказа - 1 страница
    private final By ORDER_FORM_1 = By.cssSelector(".Order_Content__bmtHS");
    //поле ввода Имя
    private final By NAME_INPUT = By.xpath(".//input[@placeholder='* Имя']");
    //Поле ввода Фамилия
    private final By LAST_NAME_INPUT = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле ввода Адрес
    private final By ADDRESS_INPUT = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Выпадающий список Станция метро
    private final By SUBWAY_LIST = By.xpath(".//input[@placeholder='* Станция метро']");
    //ЛОкаторы для станций, которые будут использоваться в тестах:
    private By[] subway = {By.xpath(".//div/ul/li/button/div[text()='Черкизовская']"),
    By.xpath(".//div/ul/li/button/div[text()='Сокольники']")};
    //Поле ввода Телефон
    private final By PHONE_INPUT = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка Далее
    private final  By NEXT_BUTTON = By.xpath(".//div/button[text()='Далее']");

    //конструктор класса:
    private WebDriver driver;
    public OrderPageOne(WebDriver driver) {

        this.driver = driver;
    }
    //метод, который открывает страницу с формой заказа
    public void getOrderPageURL() {
        driver.get(ORDER_PAGE_URL);
    }
    //Метод для заполнения поля Имя
    public void fillNameInput(String name) {
       driver.findElement(NAME_INPUT).sendKeys(name);
    }
    //Метод для заполнения поля Фамилия
    public void fillLastNameInput(String lastname) {
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastname);
    }
    //Метод для заполнения поля Адрес
    public void fillAddressInput(String address) {
        driver.findElement(ADDRESS_INPUT).sendKeys(address);
    }

    //Метод для выбора станции метро
    public void fillSubwayList(int index) {
        driver.findElement(SUBWAY_LIST).click(); //кликаем на выпадающий список
        driver.findElement(subway[index]).click(); //выбираем нужную станцию
    }
    //Метод для заполнения поля Телефон
    public void fillPhoneInput(String phone) {
        driver.findElement(PHONE_INPUT).sendKeys(phone);
    }

    public void clickNextButton() {
        driver.findElement(NEXT_BUTTON).click();
    }
    //WebElement orderFormOne = driver.findElement(orderPageOne.getOrderForm1());
    public WebElement getOrderFormOne() {
        return driver.findElement(ORDER_FORM_1);
    }

}
