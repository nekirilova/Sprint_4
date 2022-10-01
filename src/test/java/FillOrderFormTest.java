import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.practikum.model.OrderPageOne;

import java.time.Duration;

public class FillOrderFormTest {

    private WebDriver driver;

    @Before
    public void openSamokatApp() {
     //   ChromeOptions options = new ChromeOptions();
       // options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver();
        //открываем первую страницу формы заказа приложения Самокат
        driver.get("https://qa-scooter.praktikum-services.ru/order");

    }

    @Test
    public void fillOrderFormShowsOrderProof() {
        OrderPageOne orderPageOne = new OrderPageOne(driver);
        //Ищем поле ввода Имя и передаем в него имя
        driver.findElement(orderPageOne.getNameInput()).sendKeys("Алена");
        driver.findElement(orderPageOne.getLastNameInput()).sendKeys("Метенева");
        driver.findElement(orderPageOne.getAddressInput()).sendKeys("ул. Уральская, 74-53");
        driver.findElement(orderPageOne.getSubwayList()).click();
        driver.findElement(By.xpath(".//div/ul/li/button/div[text()='Черкизовская']")).click();
        driver.findElement(orderPageOne.getPhoneInput()).sendKeys("89997776644");
        driver.findElement(By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM")).click();
      //  Assert.assertFalse("Сообщения об ошибке быть не должно", driver.findElement(By.xpath(".//div[text()='Введите корректную фамилию']")).isDisplayed());
    }

//    @After
//    public void tearDown(){
//        driver.quit();
//    }

}
