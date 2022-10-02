package ru.yandex.practikum.model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;


    //Создаем конструктор класса:
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    //константы

    private final By COOKIE_CONFIRM_BUTTON = By.cssSelector("#rcc-confirm-button"); //кнопка "принять все куки"

    private final String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru/"; //URL главной страницы

    //Кнопка с первым вопросом в FAQ
    private final By FIRST_BUTTON = By.xpath(".//div[@id='accordion__heading-0']");
    //Кнопка со вторым вопросом в FAQ
    private final By SECOND_BUTTON = By.xpath(".//div[@id='accordion__heading-1']");
    //Кнопка с третьим вопросом в FAQ
    private final By THIRD_BUTTON = By.xpath(".//div[@id='accordion__heading-2']");
    //Кнопка с четвертым вопросом в FAQ
    private final By FOURTH_BUTTON = By.xpath(".//div[@id='accordion__heading-3']");
    //Кнопка с пятым вопросом в FAQ
    private final By FIFTH_BUTTON = By.xpath(".//div[@id='accordion__heading-4']");
    //Кнопка с шестым вопросом в FAQ
    private final By SIXTH_BUTTON = By.xpath(".//div[@id='accordion__heading-5']");
    //Кнопка с седьмым вопросом в FAQ
    private final By SEVENTH_BUTTON = By.xpath(".//div[@id='accordion__heading-6']");
    //Кнопка с восьмым вопросом в FAQ
    private final By EIGHTH_BUTTON = By.xpath(".//div[@id='accordion__heading-7']");
    private final By buttons[] = {FIRST_BUTTON, SECOND_BUTTON, THIRD_BUTTON, FOURTH_BUTTON,
    FIFTH_BUTTON, SIXTH_BUTTON, SEVENTH_BUTTON, EIGHTH_BUTTON};

    //Текст первого ответа в FAQ
    public final By ACTUAL_TEXT_1 = By.xpath(".//div[@id='accordion__panel-0']/p");
    //Текст второго ответа в FAQ
    private final By ACTUAL_TEXT_2 = By.xpath(".//div[@id='accordion__panel-1']/p");
    //Текст третьего ответа в FAQ
    private final By ACTUAL_TEXT_3 = By.xpath(".//div[@id='accordion__panel-2']/p");
    //Текст четвертого  ответа в FAQ
    private final By ACTUAL_TEXT_4 = By.xpath(".//div[@id='accordion__panel-3']/p");
    //Текст пятого ответа в FAQ
    private final By ACTUAL_TEXT_5 = By.xpath(".//div[@id='accordion__panel-4']/p");
    //Текст шестого ответа в FAQ
    private final By ACTUAL_TEXT_6 = By.xpath(".//div[@id='accordion__panel-5']/p");
    //Текст седьмого ответ в FAQ
    private final By ACTUAL_TEXT_7 = By.xpath(".//div[@id='accordion__panel-6']/p");
    //Текст восьмого ответ в FAQ
    private final By ACTUAL_TEXT_8 = By.xpath(".//div[@id='accordion__panel-7']/p");
    private final By[] actualTextAnswers = {ACTUAL_TEXT_1, ACTUAL_TEXT_2, ACTUAL_TEXT_3, ACTUAL_TEXT_4,
            ACTUAL_TEXT_5, ACTUAL_TEXT_6, ACTUAL_TEXT_7, ACTUAL_TEXT_8};


    //Текст первого ответа
    private final String FIRST_TEXT = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    //Текст второго ответа
    private final String SECOND_TEXT = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    //Текст третьего ответа
    private final String THIRD_TEXT = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    //Текст четвертого ответа
    private final String FOURTH_TEXT = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    //Текст пятого ответа
    private final String FIFTH_TEXT = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    //Текст шестого ответа
    private final String SIXTH_TEXT = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    //Текст седьмого ответа
    private final String SEVENTH_TEXT = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    //Текст восьмого ответа
    private final String EIGHTH_TEXT = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    private String[] expectedText = {FIRST_TEXT, SECOND_TEXT, THIRD_TEXT, FOURTH_TEXT,
    FIFTH_TEXT, SIXTH_TEXT, SEVENTH_TEXT, EIGHTH_TEXT};

    //кнопка Заказать вверху страницы
    private final By ORDER_BUTTON_ON_TOP = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");

    //кнопка Заказать внизу страницы
    private final By ORDER_BUTTON_ON_BOTTOM = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");


    //геттер для получения урла главной страницы

    public String getMainPageURL() {
        return MAIN_PAGE_URL;
    }

    //геттер для получения селектора для кнопки с вопросом
    public By getButton(int index) {
        return buttons[index];
    }

    //геттер для получения ожидаемого текста ответа:
    public String getExpectedText(int index) {
        return expectedText[index];
    }

    //метод для закрытия панели с сообщением про куки
    public void closeCookiePanel(){
        WebElement cookieButton = driver.findElement(COOKIE_CONFIRM_BUTTON);
        new WebDriverWait(driver,Duration.ofSeconds(3)).until(ExpectedConditions.
                elementToBeClickable(cookieButton));
        cookieButton.click();
    }
    //метод, который кликает на кнопку с вопросом в FAQ
    public void clickFaqButton(int index) {
        WebElement faqButton = driver.findElement(buttons[index]);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", faqButton);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.
                elementToBeClickable(faqButton));
        faqButton.click();
    }
    //метод, который получает текст ответа
    public String getActualText(int index) {
        return driver.findElement(actualTextAnswers[index]).getText();
    }
    //метод для клика по кнопке заказа вверху страницы
    public void clickOrderButtonOnTop() {
       WebElement buttonOnTop = driver.findElement(ORDER_BUTTON_ON_TOP); //находим кнопку
       new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.
               elementToBeClickable(buttonOnTop)); //ждем, пока она станет кликабельной
       buttonOnTop.click(); //кликаем на нее

    }
    //метод для клика по кнопке заказа внизу страницы
    public void clickOrderButtonOnBottom() {
        driver.findElement(ORDER_BUTTON_ON_BOTTOM).click();
    }
    //метод, который скроллит страницу до кнопки заказа внизу и кликает на нее
    public void scrollAndClickOrderButtonOnBottom() {
        WebElement buttonOnBottom = driver.findElement(ORDER_BUTTON_ON_BOTTOM); //находим кнопку
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", buttonOnBottom);//скроллим до нее
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.
                elementToBeClickable(buttonOnBottom)); //ждем, пока кнопка станет кликабельной
        buttonOnBottom.click(); //кликаем на нее
    }


}
