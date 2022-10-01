import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.practikum.model.MainPage;
import ru.yandex.practikum.model.OrderPageOne;

import java.time.Duration;

public class CheckOrderButtons {
    private WebDriver driver;

    @Before
    public void openSamokatApp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        //открываем страницу приложения Самокат
        driver.get("https://qa-scooter.praktikum-services.ru/");

    }

    //Проверяем, что по клику на кнопку Заказа вверху страницы открывается форма заказа
    @Test
    public void clickOrderButtonOnTopOpensOrderForm() {
        MainPage mainPage = new MainPage(driver);

       //Ищем кнопку заказа вверху страницы и кликаем на нее
        driver.findElement(mainPage.getOrderButtonOnTop()).click();

        OrderPageOne orderPageOne = new OrderPageOne(driver);

        //Ищем форму заказа на странице и задаем ожидание, пока она не станет видимой
        WebElement orderFormOne = driver.findElement(orderPageOne.getOrderForm1());
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(orderFormOne));

        //Проверяем, что форма есть
        Assert.assertTrue("Форма заказа не загрузилась", orderFormOne.isDisplayed());
    }

    //Проверяем, что по клику на кнопку Заказа внизу страницы открывается форма заказа
    @Test
    public void clickOrderButtonOnBottomOpensOrderForm() {
        MainPage mainPage = new MainPage(driver);

        //Ищем кнопку заказа внизу страницы и скроллим до нее
        WebElement orderButtonOnBottom = driver.findElement(mainPage.getOrderButtonOnBottom());
        //Ждем, пока кнопка станет кликабельной и кликаем на нее
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", orderButtonOnBottom);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(orderButtonOnBottom));
        orderButtonOnBottom.click();

        OrderPageOne orderPageOne = new OrderPageOne(driver);

        //Ищем форму заказа на странице и задаем ожидание, пока она не станет видимой
        WebElement orderFormOne = driver.findElement(orderPageOne.getOrderForm1());
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(orderFormOne));

        //Проверяем, что форма есть
        Assert.assertTrue("Форма заказа не загрузилась", orderFormOne.isDisplayed());
    }

    @After
    public void tearDown() {
    driver.quit();
    }
}
