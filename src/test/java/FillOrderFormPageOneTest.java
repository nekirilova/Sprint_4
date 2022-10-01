import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.practikum.model.OrderPageOne;

public class FillOrderFormPageOneTest {

    private WebDriver driver;

    @Before
    public void openSamokatApp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        //открываем первую страницу формы заказа приложения Самокат
        driver.get("https://qa-scooter.praktikum-services.ru/order");

    }

    @Test
    public void FillInputNameNoError() {
        OrderPageOne orderPageOne = new OrderPageOne(driver);
        //Ищем поле ввода Имя и передаем в него имя
        driver.findElement(orderPageOne.getNameInput()).sendKeys("Алена");

        Assert.assertFalse("Сообщения об ошибке быть не должно", driver.findElement(By.xpath(".//div[text()='Введите корректное имя']")).isDisplayed());
    }

    @Test
    public void FillInputLastNameNoError() {
        OrderPageOne orderPageOne = new OrderPageOne(driver);
        //Ищем поле ввода Имя и передаем в него имя
        driver.findElement(orderPageOne.getNameInput()).sendKeys("Метенева");

        Assert.assertFalse("Сообщения об ошибке быть не должно", driver.findElement(By.xpath(".//div[text()='Введите корректную фамилию']")).isDisplayed());
    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
