package ru.gb.lesson;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class LoginAndLogout
{
    public static void main( String[] args ) throws  InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings-imagesEnabled-false");



        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.get("https://www.terrakot-yarn.ru/");

        webDriver.manage().window().setSize(new Dimension(1300, 720));

        webDriver.findElement(By.linkText("Вход")).click();
        webDriver.findElement(By.name("login")).sendKeys("WhiteBars");
        webDriver.findElement(By.name("password")).sendKeys("Aa123456");

        //webDriver.findElement(By.linkText("Войти")).click();
        webDriver.findElement(By.xpath(("//input[@value='Войти']"))).click(); //войти

        webDriver.findElement(By.xpath(("//*[@id=\"enter\"]"))).click(); //личный кабинет
        Thread.sleep(3000);
        webDriver.findElement(By.xpath(("//*[text()='Выйти']"))).click(); //выйти
        //webDriver.findElement(By.linkText("Выйти")).click(); //выйти
        Thread.sleep(3000);

        webDriver.quit();

    }
}
