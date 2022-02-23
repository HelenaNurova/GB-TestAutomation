package ru.gb.lesson.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ChooseItemTest extends BaseTest {

    @Test
    void chooseItemTest() {

        webDriver.get("https://www.terrakot-yarn.ru/");

        webDriver.manage().window().setSize(new Dimension(1300, 720));

        webDriver.findElement(By.xpath(("//*[@id=\"nov\"]"))).click(); //Новинки

        webDriver.findElement(By.xpath(("//*[@id=\"novItem\"]/div[1]/a"))).click(); //1 товар из Новинок

        webDriver.findElement(By.xpath(("//*[@id=\"center\"]/table/tbody/tr[1]/td[1]/div/p/a"))).click(); //клик "В корзину"

        webDriver.findElement(By.xpath(("//*[@id=\"basket_div\"]/a"))).click(); //Моя корзина

        webDriver.findElement(By.xpath(("//*[@id=\"bask_del1\"]/td[5]/p"))).click(); //клик по удалить

    }
}
