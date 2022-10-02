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
    private WebDriver driver;
    //определяем поля для конструктора тестовых данных
    private final String name;
    private final String lastname;
    private final String address;
    private final int subwayStation;
    private final String phone;
    private final int date;
    private final int rent;

    private final String comment;

    //создаем конструктор тестовых данных
    public FillOrderFormTest(String name, String lastname, String address,
                             int subwayStation, String phone, int date, int rent, String comment) {
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
                {"Алена", "Метенева", "Ленина, 25-18", 0, "89120005544", 0, 1, "Привезите скорее!"},
                {"Ян", "Оооооооооооооо", "г.Москва, пр-т Ленина, 64-2, кв.3", 1, "+79120005544", 1,
                        1, "Без комментариев"}
        };
    }

    @Before
    public void openSamokatApp() {
      //ChromeOptions options = new ChromeOptions();
      //options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver();
        //открываем первую страницу формы заказа приложения Самокат
        OrderPageOne orderPageOne = new OrderPageOne(driver);
        orderPageOne.getOrderPageURL();

    }

    @Test
    public void fillOrderFormShowsOrderProof() {

        //Последовательно заполняем все поля формы на странице 1
        OrderPageOne orderPageOne = new OrderPageOne(driver);
        orderPageOne.fillNameInput(name); //вводим имя
        orderPageOne.fillLastNameInput(lastname); //вводим фамилию
        orderPageOne.fillAddressInput(address); //вводим адрес
        orderPageOne.fillSubwayList(subwayStation); //выбираем станцию
        orderPageOne.fillPhoneInput(phone); // вводим телефон
        orderPageOne.clickNextButton(); //кликаем кнопку Далее

        //Ждем, когда загрузится вторая страница (когда поле для выбора даты станет активным)
        OrderPageTwo orderPageTwo = new OrderPageTwo(driver);
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
