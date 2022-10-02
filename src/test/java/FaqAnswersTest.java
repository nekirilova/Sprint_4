import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.practikum.model.MainPage;

public class FaqAnswersTest {
    private WebDriver driver;



    @Before
    public void openSamokatApp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        MainPage mainPage = new MainPage(driver);
        //открываем страницу приложения Самокат
        driver.get(mainPage.getMainPageURL());

    }
    @Test
    public void clickAccordionButtonOneShowsTextCorrect() {
        //закрываем сообщение о куках
        MainPage mainPage = new MainPage(driver);
        mainPage.closeCookiePanel();

       //Ищем кнопку, скроллим до нее, ждем и кликаем
        mainPage.clickFaqButton(0);
        //Получаем текст, который отображается при клике на первую кнопку
        String actualText = mainPage.getActualText(0);
        //Проверяем, что текст соответствует ожидаемому тексту
        Assert.assertEquals("Текст не соответствует шаблону", mainPage.getExpectedText(0), actualText);

    }
    @Test
    public void clickAccordionButtonTwoShowsTextCorrect() {
        //закрываем сообщение о куках
        MainPage mainPage = new MainPage(driver);
        mainPage.closeCookiePanel();

        //Ищем кнопку, скроллим до нее, ждем и кликаем
        mainPage.clickFaqButton(1);
        //Получаем текст, который отображается при клике на первую кнопку
        String actualText = mainPage.getActualText(1);
        //Проверяем, что текст соответствует ожидаемому тексту
        Assert.assertEquals("Текст не соответствует шаблону", mainPage.getExpectedText(1), actualText);

    }
    @Test
    public void clickAccordionButtonThreeShowsTextCorrect() {
        //закрываем сообщение о куках
        MainPage mainPage = new MainPage(driver);
        mainPage.closeCookiePanel();

        //Ищем кнопку, скроллим до нее, ждем и кликаем
        mainPage.clickFaqButton(2);
        //Получаем текст, который отображается при клике на первую кнопку
        String actualText = mainPage.getActualText(2);
        //Проверяем, что текст соответствует ожидаемому тексту
        Assert.assertEquals("Текст не соответствует шаблону", mainPage.getExpectedText(2), actualText);

    }
    @Test
    public void clickAccordionButtonFourShowsTextCorrect() {
        //закрываем сообщение о куках
        MainPage mainPage = new MainPage(driver);
        mainPage.closeCookiePanel();

        //Ищем кнопку, скроллим до нее, ждем и кликаем
        mainPage.clickFaqButton(3);
        //Получаем текст, который отображается при клике на первую кнопку
        String actualText = mainPage.getActualText(3);
        //Проверяем, что текст соответствует ожидаемому тексту
        Assert.assertEquals("Текст не соответствует шаблону", mainPage.getExpectedText(3), actualText);

    }

    @Test
    public void clickAccordionButtonFiveShowsTextCorrect() {
        //закрываем сообщение о куках
        MainPage mainPage = new MainPage(driver);
        mainPage.closeCookiePanel();

        //Ищем кнопку, скроллим до нее, ждем и кликаем
        mainPage.clickFaqButton(4);
        //Получаем текст, который отображается при клике на первую кнопку
        String actualText = mainPage.getActualText(4);
        //Проверяем, что текст соответствует ожидаемому тексту
        Assert.assertEquals("Текст не соответствует шаблону", mainPage.getExpectedText(4), actualText);

    }

    @Test
    public void clickAccordionButtonSixShowsTextCorrect() {
        //закрываем сообщение о куках
        MainPage mainPage = new MainPage(driver);
        mainPage.closeCookiePanel();

        //Ищем кнопку, скроллим до нее, ждем и кликаем
        mainPage.clickFaqButton(5);
        //Получаем текст, который отображается при клике на первую кнопку
        String actualText = mainPage.getActualText(5);
        //Проверяем, что текст соответствует ожидаемому тексту
        Assert.assertEquals("Текст не соответствует шаблону", mainPage.getExpectedText(5), actualText);

    }

    @Test
    public void clickAccordionButtonSevenShowsTextCorrect() {
        //закрываем сообщение о куках
        MainPage mainPage = new MainPage(driver);
        mainPage.closeCookiePanel();

        //Ищем кнопку, скроллим до нее, ждем и кликаем
        mainPage.clickFaqButton(6);
        //Получаем текст, который отображается при клике на первую кнопку
        String actualText = mainPage.getActualText(6);
        //Проверяем, что текст соответствует ожидаемому тексту
        Assert.assertEquals("Текст не соответствует шаблону", mainPage.getExpectedText(6), actualText);

    }

    @Test
    public void clickAccordionButtonEightShowsTextCorrect() {
        //закрываем сообщение о куках
        MainPage mainPage = new MainPage(driver);
        mainPage.closeCookiePanel();

        //Ищем кнопку, скроллим до нее, ждем и кликаем
        mainPage.clickFaqButton(7);
        //Получаем текст, который отображается при клике на первую кнопку
        String actualText = mainPage.getActualText(7);
        //Проверяем, что текст соответствует ожидаемому тексту
        Assert.assertEquals("Текст не соответствует шаблону", mainPage.getExpectedText(7), actualText);

    }
    @After
    public void tearDown(){

        driver.quit();
    }
}
