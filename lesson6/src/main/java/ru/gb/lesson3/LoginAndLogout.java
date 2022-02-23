package ru.gb.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class LoginAndLogout {

    public static void main( String[] args ) throws  InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        webDriver.get("https://www.terrakot-yarn.ru/");
        webDriver.manage().window().setSize(new Dimension(1920, 1080));

        webDriver.findElement(By.linkText("Вход")).click();

        By authFormLocator = By.xpath("//*[@id=\"auth\"]");
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(authFormLocator));
        WebElement authForm = webDriver.findElement(authFormLocator);
        authForm.findElement(By.name("login")).sendKeys("WhiteBars");
        authForm.findElement(By.name("password")).sendKeys("Aa123456");
        authForm.findElement(By.xpath(("//input[@value='Войти']"))).click();

        webDriver.findElement(By.xpath(("//*[@id=\"enter\"]"))).click(); //личный кабинет
        //System.out.println("User's name is " + webDriver.findElement(By.xpath("//*[@id=\"auth\"]/h2")).getText());

        webDriver.findElement(By.xpath(("//*[text()='Выйти']"))).click(); //выйти

        webDriver.quit();

        //whitebars70@rambler.ru
        //Aa123456
    }
}