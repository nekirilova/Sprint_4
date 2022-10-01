import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.practikum.model.MainPage;

import java.time.Duration;

public class FaqAnswersTest {
    private WebDriver driver;

    //Текст первого ответа
    private final static String FIRST_TEXT = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    //Текст второго ответа
    private final static String SECOND_TEXT = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    //Текст третьего ответа
    private final static String THIRD_TEXT = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    //Текст четвертого ответа
    private final static String FOURTH_TEXT = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    //Текст пятого ответа
    private final static String FIFTH_TEXT = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    //Текст шестого ответа
    private final static String SIXTH_TEXT = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    //Текст седьмого ответа
    private final static String SEVENTH_TEXT = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    //Текст восьмого ответа
    private final static String EIGHTH_TEXT = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";


    @Before
    public void openSamokatApp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        //открываем страницу приложения Самокат
        driver.get("https://qa-scooter.praktikum-services.ru/");

    }
    @Test
    public void clickAccordionButtonOneShowsTextCorrect() {
        //ищем кнопку, которая закроет сообщение о куках
        MainPage mainPage = new MainPage(driver);
        new WebDriverWait(driver,Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(mainPage.getCookieConfirmButton()));
        mainPage.closeCookiePanel();

       //Ищем первую кнопку
        WebElement firstButton = driver.findElement(mainPage.getButton(0));
        // Скроллим до нее, чтобы она оказалась в поле видимости, ждем, пока она станет кликабельной,
        // потом кликаем на кнопку
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", firstButton);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(firstButton));
        firstButton.click();

        //Получаем текст, который отображается при клике на первую кнопку
        String firstText = driver.findElement(mainPage.getActualText(0)).getText();
        //Проверяем, что текст соответствует ожидаемому тексту
        Assert.assertTrue("Текст не соответствует шаблону", firstText.equals(FIRST_TEXT));

    }
    @Test
    public void clickAccordionButtonTwoShowsTextCorrect() {
        MainPage mainPage = new MainPage(driver);
        new WebDriverWait(driver,Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(mainPage.getCookieConfirmButton()));
        mainPage.closeCookiePanel();

        WebElement secondButton = driver.findElement(mainPage.getButton(1));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", secondButton);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(secondButton));
        secondButton.click();

        String secondText = driver.findElement(mainPage.getActualText(1)).getText();
        Assert.assertTrue("Текст не соответствует шаблону", secondText.equals(SECOND_TEXT));

    }

    @Test
    public void clickAccordionButtonThreeShowsTextCorrect() {
        MainPage mainPage = new MainPage(driver);
        new WebDriverWait(driver,Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(mainPage.getCookieConfirmButton()));
        mainPage.closeCookiePanel();

        WebElement thirdButton = driver.findElement(mainPage.getButton(2));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", thirdButton);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(thirdButton));
        thirdButton.click();

        String thirdText = driver.findElement(mainPage.getActualText(2)).getText();
        Assert.assertTrue("Текст не соответствует шаблону", thirdText.equals(THIRD_TEXT));

    }

    @Test
    public void clickAccordionButtonFourShowsTextCorrect() {
        MainPage mainPage = new MainPage(driver);
        new WebDriverWait(driver,Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(mainPage.getCookieConfirmButton()));
        mainPage.closeCookiePanel();

        WebElement fourthButton = driver.findElement(mainPage.getButton(3));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", fourthButton);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(fourthButton));
        fourthButton.click();

        String fourthText = driver.findElement(mainPage.getActualText(3)).getText();
        Assert.assertTrue("Текст не соответствует шаблону", fourthText.equals(FOURTH_TEXT));

    }
    @Test
    public void clickAccordionButtonFiveShowsTextCorrect() {
        MainPage mainPage = new MainPage(driver);
        new WebDriverWait(driver,Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(mainPage.getCookieConfirmButton()));
        mainPage.closeCookiePanel();

        WebElement fifthButton = driver.findElement(mainPage.getButton(4));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", fifthButton);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(fifthButton));
        fifthButton.click();

        String fifthText = driver.findElement(mainPage.getActualText(4)).getText();
        Assert.assertTrue("Текст не соответствует шаблону", fifthText.equals(FIFTH_TEXT));

    }

    @Test
    public void clickAccordionButtonSixShowsTextCorrect() {
        MainPage mainPage = new MainPage(driver);
        new WebDriverWait(driver,Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(mainPage.getCookieConfirmButton()));
        mainPage.closeCookiePanel();

        WebElement sixthButton = driver.findElement(mainPage.getButton(5));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", sixthButton);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(sixthButton));
        sixthButton.click();

        String sixthText = driver.findElement(mainPage.getActualText(5)).getText();
        Assert.assertTrue("Текст не соответствует шаблону", sixthText.equals(SIXTH_TEXT));

    }

    @Test
    public void clickAccordionButtonSevenShowsTextCorrect() {
        MainPage mainPage = new MainPage(driver);
        new WebDriverWait(driver,Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(mainPage.getCookieConfirmButton()));
        mainPage.closeCookiePanel();

        WebElement seventhButton = driver.findElement(mainPage.getButton(6));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", seventhButton);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(seventhButton));
        seventhButton.click();

        String seventhText = driver.findElement(mainPage.getActualText(6)).getText();
        Assert.assertTrue("Текст не соответствует шаблону", seventhText.equals(SEVENTH_TEXT));

    }
    @Test
    public void clickAccordionButtonEightShowsTextCorrect() {
        MainPage mainPage = new MainPage(driver);
        new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(mainPage.getCookieConfirmButton()));
        mainPage.closeCookiePanel();

        WebElement eighthButton = driver.findElement(mainPage.getButton(7));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", eighthButton);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(eighthButton));
        eighthButton.click();

        String eighthText = driver.findElement(mainPage.getActualText(7)).getText();
        Assert.assertTrue("Текст не соответствует шаблону", eighthText.equals(EIGHTH_TEXT));

    }

    @After
    public void tearDown(){

        driver.quit();
    }
}
