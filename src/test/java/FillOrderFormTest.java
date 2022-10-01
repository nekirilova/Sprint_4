import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.practikum.model.OrderPageOne;
import ru.yandex.practikum.model.OrderPageTwo;

import java.time.Duration;

@RunWith(Parameterized.class)
public class FillOrderFormTest {
    //определяем поля для конструктора тестовых данных
    private final String name;
    private final String lastname;
    private final String address;
    private final By subwayStation;
    private final String phone;
    private final By date;
    private final By rent;
   // private final By color;
    private final String comment;

    //создаем конструктор тестовых данных
    public FillOrderFormTest(String name, String lastname, String address,
                             By subwayStation, String phone, By date, By rent, String comment) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.subwayStation = subwayStation;
        this.phone = phone;
        this.date = date;
        this.rent = rent;
        this.comment = comment;
    }
    //создаем многомерный объект с данными для тестов
    @Parameterized.Parameters
    public static Object[][] fillOrderForm() {
        return new Object[][] {
                {"Алена", "Метенева", "Ленина, 25-18", By.xpath(".//div/ul/li/button/div[text()='Черкизовская']"),
                "89120005544", By.xpath("//div[@class='react-datepicker__day react-datepicker__day--004']"),
                        By.xpath(".//div[@class='Dropdown-menu']/div[text()='трое суток']"), "Привезите скорее!"},
                {"Ян", "Оооооооооооооо", "г.Москва, пр-т Ленина, 64-2, кв.3", By.xpath(".//div/ul/li/button/div[text()='Сокольники']"),
                        "+79120005544", By.xpath(".//div[@aria-label='Choose пятница, 30-е сентября 2022 г.']"),
                        By.xpath(".//div[@class='Dropdown-menu']/div[text()='семеро суток']"), "Без комментариев"}
        };
    }


    private WebDriver driver;


    @Before
    public void openSamokatApp() {
      //ChromeOptions options = new ChromeOptions();
      //options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver();
        //открываем первую страницу формы заказа приложения Самокат
        driver.get("https://qa-scooter.praktikum-services.ru/order");

    }

    @Test
    public void fillOrderFormShowsOrderProof() {
        //Создаем объекты класса
        OrderPageOne orderPageOne = new OrderPageOne(driver);
        OrderPageTwo orderPageTwo = new OrderPageTwo(driver);
        //Последовательно заполняем все поля формы на странице 1

        orderPageOne.fillNameInput(name); //вводим имя
        orderPageOne.fillLastNameInput(lastname); //вводим фамилию
        orderPageOne.fillAddressInput(address); //вводим адрес
        orderPageOne.fillSubwayList(subwayStation); //выбираем станцию
        orderPageOne.fillPhoneInput(phone); // вводим телефон
        orderPageOne.clickNextButton(); //кликаем кнопку Далее

        //Ждем, когда загрузится вторая страница (когда поле для выбора даты станет активным)
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(orderPageTwo.getDateInput()));
        orderPageTwo.fillDateInput(date); //выбираем дату
        orderPageTwo.fillRentDays(rent); //выбираем срок аренды
        orderPageTwo.fillScooterColor(); //выбираем цвет
        orderPageTwo.fillComment(comment); //пишем комментарий
        orderPageTwo.clickOrderButton();//кликаем на кнопку Заказать
        orderPageTwo.clickConfirmOrder(); // кликаем на кнопку Подтвердить
        //Проверяем, что на странице появилось модальное окно с текстом Заказ оформлен
       Assert.assertTrue("Должно появиться окно с номером созданного заказа", orderPageTwo.findOrderModal().isDisplayed());

    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
