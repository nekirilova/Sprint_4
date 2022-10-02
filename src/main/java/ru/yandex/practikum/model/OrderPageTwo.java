package ru.yandex.practikum.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPageTwo {
    //локаторы
    //форма для заполнения данных заказа - 2 страница

    //поле для выбора даты
    private final By DATE_INPUT = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //массив значений локаторов для выбора даты
    private By[] datepicker = { By.xpath("//div[@class='react-datepicker__day react-datepicker__day--004']"),
            By.xpath(".//div[@aria-label='Choose пятница, 30-е сентября 2022 г.']") };
    //поле для выбора срока аренды
    private final By RENT_DAYS = By.xpath(".//div[@class='Dropdown-placeholder']");

    //массив значений локаторов для выбора срока аренды
    private By[] rentDays = {By.xpath(".//div[@class='Dropdown-menu']/div[text()='трое суток']"),
            By.xpath(".//div[@class='Dropdown-menu']/div[text()='семеро суток']") };
    //поле для выбора цвета самоката
    private final By SCOOTER_COLOR = By.xpath(".//*[@id='black']");
    //поле для ввода комментария
    private final By COMMENT = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //кнопка заказа самоката
    private final By ORDER_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //кнопка подтверждения заказа
    private final By CONFIRM_ORDER = By.xpath(".//div/button[text()='Да']");
    //модальное окно с данными заказа
    private final By ORDER_MODAL = By.xpath(".//div[text()='Заказ оформлен']");
    private WebDriver driver;
    public OrderPageTwo(WebDriver driver) {

        this.driver = driver;
    }
    //метод, который выбирает дату
    public void fillDateInput(int index) {
        driver.findElement(DATE_INPUT).click();
        driver.findElement(datepicker[index]).click();
    }
//метод, которыф выбирает срок аренды
    public void fillRentDays(int index) {
        driver.findElement(RENT_DAYS).click();
        driver.findElement(rentDays[index]).click();
    }
//метод, который выбирает цвет самоката
    public void fillScooterColor() {
        driver.findElement(SCOOTER_COLOR).click();

    }
    //метод, который пишет комментарий
    public void fillComment(String comment) {
        driver.findElement(COMMENT).sendKeys(comment);
    }
    //Геттер для поля выбора дата
    public By getDateInput(){
        return DATE_INPUT;
    }

    //метод для нажатия кнопки Заказать
    public void clickOrderButton() {
        driver.findElement(ORDER_BUTTON).click();
    }
    //метод для нажатия кнопки Подтверждения
    public void clickConfirmOrder() {
        driver.findElement(CONFIRM_ORDER).click();
    }

    //метод, который ищет модальное окно об успешном создании заказа
    public WebElement findOrderModal() {
       return driver.findElement(ORDER_MODAL);
    }
}
