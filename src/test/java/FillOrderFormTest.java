import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.practikum.model.OrderPageOne;
import ru.yandex.practikum.model.OrderPageTwo;

import java.time.Duration;

@RunWith(Parameterized.class)
public class FillOrderFormTest {
    private final String name;
    private final String lastname;
    private final String address;
    private final By subwayStation;
    private final String phone;
    private final By date;
    private final By rent;
   // private final By color;
    private final String comment;

    public FillOrderFormTest(String name, String lastname, String address, By subwayStation, String phone, By date, By rent, String comment) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.subwayStation = subwayStation;
        this.phone = phone;
        this.date = date;
        this.rent = rent;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] fillOrderForm() {
        return new Object[][] {
                {"Алена", "Метенева", "Ленина, 25-18", By.xpath(".//div/ul/li/button/div[text()='Черкизовская']"),
                "89120005544", By.xpath("//div[@class='react-datepicker__day react-datepicker__day--004']"),
                        By.xpath(".//div[@class='Dropdown-menu']/div[text()='трое суток']"), "Привезите скорее!"},
        };
    }


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
        OrderPageTwo orderPageTwo = new OrderPageTwo(driver);
        //Последовательно заполняем все поля формы на странице 1
        orderPageOne.fillNameInput(name);
        orderPageOne.fillLastNameInput(lastname);
        orderPageOne.fillAddressInput(address);
        orderPageOne.fillSubwayList(subwayStation);
        orderPageOne.fillPhoneInput(phone);
        driver.findElement(By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM")).click();
       // new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(orderPageTwo.getDateInput()));
        orderPageTwo.fillDateInput(date);
        orderPageTwo.fillRentDays(rent);
        orderPageTwo.fillScooterColor();
        orderPageTwo.fillComment(comment);
        driver.findElement(orderPageTwo.getOrderButton()).click();
      driver.findElement(orderPageTwo.getConfirmOrder()).click();
       Assert.assertTrue("Должно появиться окно с номером созданного заказа", driver.findElement(orderPageTwo.getOrderModal()).isDisplayed());
        //        driver.findElement(orderPageOne.getNameInput()).sendKeys("Алена");
//        driver.findElement(orderPageOne.getLastNameInput()).sendKeys("Метенева");
//        driver.findElement(orderPageOne.getAddressInput()).sendKeys("ул. Уральская, 74-53");
//        driver.findElement(orderPageOne.getSubwayList()).click();
//        driver.findElement(By.xpath(".//div/ul/li/button/div[text()='Черкизовская']")).click();
//        driver.findElement(orderPageOne.getPhoneInput()).sendKeys("89997776644");
//        driver.findElement(By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM")).click();
//        //Ждем загрузку второй страницы и начинаем заполнять поля на странице 2
//        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(orderPageTwo.getDateInput()));
//        driver.findElement(orderPageTwo.getDateInput()).click();
//        driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--004']")).click();
//        driver.findElement(orderPageTwo.getRentDays()).click();
//        driver.findElement(By.xpath(".//div[@class='Dropdown-menu']/div[text()='трое суток']")).click();
//        driver.findElement(orderPageTwo.getScooterColor()).click();
//        driver.findElement(orderPageTwo.getComment()).sendKeys("Привезите скорее!");
//        driver.findElement(orderPageTwo.getOrderButton()).click();
//        driver.findElement(orderPageTwo.getConfirmOrder()).click();
//        Assert.assertTrue("Должно появиться окно с номером созданного заказа", driver.findElement(orderPageTwo.getOrderModal()).isDisplayed());

    }

//    @After
//    public void tearDown(){
//        driver.quit();
//    }

}
