package ru.yandex.practikum.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    //константы
    //кнопка "принять все куки"
    private final static By COOKIE_CONFIRM_BUTTON = By.cssSelector("#rcc-confirm-button");

    //Кнопка с первым вопросом в FAQ
    private final static By FIRST_BUTTON = By.xpath(".//div[@id='accordion__heading-0']");
    //Кнопка со вторым вопросом в FAQ
    private final static By SECOND_BUTTON = By.xpath(".//div[@id='accordion__heading-1']");
    //Кнопка с третьим вопросом в FAQ
    private final static By THIRD_BUTTON = By.xpath(".//div[@id='accordion__heading-2']");
    //Кнопка с четвертым вопросом в FAQ
    private final static By FOURTH_BUTTON = By.xpath(".//div[@id='accordion__heading-3']");
    //Кнопка с пятым вопросом в FAQ
    private final static By FIFTH_BUTTON = By.xpath(".//div[@id='accordion__heading-4']");
    //Кнопка с шестым вопросом в FAQ
    private final static By SIXTH_BUTTON = By.xpath(".//div[@id='accordion__heading-5']");
    //Кнопка с седьмым вопросом в FAQ
    private final static By SEVENTH_BUTTON = By.xpath(".//div[@id='accordion__heading-6']");
    //Кнопка с восьмым вопросом в FAQ
    private final static By EIGHTH_BUTTON = By.xpath(".//div[@id='accordion__heading-6']");
    private final static By buttons[] = {FIRST_BUTTON, SECOND_BUTTON, THIRD_BUTTON, FOURTH_BUTTON,
    FIFTH_BUTTON, SIXTH_BUTTON, SEVENTH_BUTTON, EIGHTH_BUTTON};

    //Текст первого ответа в FAQ
    public final static By ACTUAL_TEXT_1 = By.xpath(".//div[@id='accordion__panel-0']/p");
    //Текст второго ответа в FAQ
    private final static By ACTUAL_TEXT_2 = By.xpath(".//div[@id='accordion__panel-1']/p");
    //Текст третьего ответа в FAQ
    private final static By ACTUAL_TEXT_3 = By.xpath(".//div[@id='accordion__panel-2']/p");
    //Текст четвертого  ответа в FAQ
    private final static By ACTUAL_TEXT_4 = By.xpath(".//div[@id='accordion__panel-3']/p");
    //Текст пятого ответа в FAQ
    private final static By ACTUAL_TEXT_5 = By.xpath(".//div[@id='accordion__panel-4']/p");
    //Текст шестого ответа в FAQ
    private final static By ACTUAL_TEXT_6 = By.xpath(".//div[@id='accordion__panel-5']/p");
    //Текст седьмого ответ в FAQ
    private final static By ACTUAL_TEXT_7 = By.xpath(".//div[@id='accordion__panel-6']/p");
    //Текст восьмого ответ в FAQ
    private final static By ACTUAL_TEXT_8 = By.xpath(".//div[@id='accordion__panel-7']/p");
    private final static By[] actualTextAnswers = {ACTUAL_TEXT_1, ACTUAL_TEXT_2, ACTUAL_TEXT_3, ACTUAL_TEXT_4,
            ACTUAL_TEXT_5, ACTUAL_TEXT_6, ACTUAL_TEXT_7, ACTUAL_TEXT_8};

    //кнопка Заказать вверху страницы
    private static final By ORDER_BUTTON_ON_TOP = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");

    //кнопка Заказать внизу страницы
    private static final By ORDER_BUTTON_ON_BOTTOM =By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");

    private final WebDriver driver;

   //Создаем конструктор класса:
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //геттер для получения селектора для кнопки с вопросом
    public By getButton(int index) {
        return buttons[index];
    }
    //геттер для получения селектора для текста ответа:
    public By getActualText(int index) {
         return actualTextAnswers[index];
        }

    // геттер для получения селектора кнопки "принять все куки"
    public By getCookieConfirmButton(){
        return COOKIE_CONFIRM_BUTTON;
    }
    //метод для закрытия панели с сообщением про куки
    public void closeCookiePanel(){
        driver.findElement(COOKIE_CONFIRM_BUTTON).click();
    }


    public By getOrderButtonOnTop() {
        return ORDER_BUTTON_ON_TOP;
    }

    public By getOrderButtonOnBottom() {
        return ORDER_BUTTON_ON_BOTTOM;
    }



}
