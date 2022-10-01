package ru.yandex.practikum.model;

import org.openqa.selenium.By;

public class OrderPageTwo {
    //локаторы
    //форма для заполнения данных заказа - 2 страница
    private static final By DATE_INPUT = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private static final By RENT_DAYS = By.xpath(".//div[@class='Dropdown-placeholder']");
    private static final By SCOOTER_COLOR = By.xpath("//div/label[1]/text()");
    private static final By COMMENT = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private static final By ORDER_BUTTON = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

}
