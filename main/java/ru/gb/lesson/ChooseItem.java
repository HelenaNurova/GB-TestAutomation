package ru.gb.lesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ChooseItem {
    public static void main( String[] args ) throws  InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings-imagesEnabled-false");



        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.get("https://www.terrakot-yarn.ru/");

        webDriver.manage().window().setSize(new Dimension(1300, 720));
        Thread.sleep(3000);


        webDriver.findElement(By.xpath(("//*[@id=\"novItem\"]/div[1]/a"))).click(); //1 товар с главной страницы
        webDriver.findElement(By.xpath(("//*[@id=\"center\"]/table/tbody/tr[1]/td[1]/div/p/a"))).click(); //клик "В корзину"
        Thread.sleep(3000);
        webDriver.findElement(By.xpath(("//*[@id=\"basket_div\"]/a"))).click(); //Моя корзина
        Thread.sleep(3000);

        webDriver.findElement(By.xpath(("//*[@id=\"bask_del1\"]/td[5]/p"))).click(); //клик по удалить
        Thread.sleep(30000);
    }
}
