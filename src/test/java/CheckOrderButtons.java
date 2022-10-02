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

//Создаем класс для тестов, которые проверяют работу кнопки "Заказать" вверху и внизу страницы
public class CheckOrderButtons {
    private WebDriver driver;



    @Before
    public void openSamokatApp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        MainPage mainPage = new MainPage(driver);
        //открываем страницу приложения Самокат
        driver.get(mainPage.getMainPageURL());

    }

    //Проверяем, что по клику на кнопку Заказа вверху страницы открывается форма заказа
    @Test
    public void clickOrderButtonOnTopOpensOrderForm() {
        MainPage mainPage = new MainPage(driver);
        OrderPageOne orderPageOne = new OrderPageOne(driver);
       //Ищем кнопку заказа вверху страницы и кликаем на нее
        mainPage.clickOrderButtonOnTop();

        //Ищем форму заказа на странице и задаем ожидание, пока она не станет видимой
        WebElement orderFormOne = orderPageOne.getOrderFormOne();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(orderFormOne));

        //Проверяем, что форма есть
        Assert.assertTrue("Форма заказа не загрузилась", orderFormOne.isDisplayed());
    }

    //Проверяем, что по клику на кнопку Заказа внизу страницы открывается форма заказа
    @Test
    public void clickOrderButtonOnBottomOpensOrderForm() {
        MainPage mainPage = new MainPage(driver);
        OrderPageOne orderPageOne = new OrderPageOne(driver);
        //Ищем кнопку заказа внизу страницы, скроллим до нее и кликаем
        mainPage.scrollAndClickOrderButtonOnBottom();

        //Ищем форму заказа на странице и задаем ожидание, пока она не станет видимой
        WebElement orderFormOne = orderPageOne.getOrderFormOne();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(orderFormOne));

        //Проверяем, что форма есть
        Assert.assertTrue("Форма заказа не загрузилась", orderFormOne.isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
