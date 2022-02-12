package ru.gb.lesson.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


@DisplayName("Авторизация на  TerrakotYarn")
public class AuthTerrakotYarnTest extends BaseTest {

    @DisplayName("Авторизация: существующий юзер - позитивный")
    @Test
    void successfulAuthTest() {

        webDriver.get("https://www.terrakot-yarn.ru/");

        webDriver.manage().window().setSize(new Dimension(1300, 720));

        webDriver.findElement(By.linkText("Вход")).click();

        WebElement authForm = webDriver.findElement(By.xpath("//*[@id=\"auth\"]"));  // элемент формы авторизации

        authForm.findElement(By.name("login")).sendKeys("WhiteBars");
        authForm.findElement(By.name("password")).sendKeys("Aa123456");

        //webDriver.findElement(By.linkText("Войти")).click();
        authForm.findElement(By.xpath(("//input[@value='Войти']"))).click(); //войти

        webDriver.findElement(By.xpath(("//*[@id=\"enter\"]"))).click(); //личный кабинет

        webDriver.findElement(By.xpath(("//*[text()='Выйти']"))).click(); //выйти
        //webDriver.findElement(By.linkText("Выйти")).click(); //выйти

        new WebDriverWait(webDriver,10).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Вход")));

    }


    @DisplayName("Авторизация: некорректный пароль - негативный")
    @Test
    void incorrectAuthTest() {

        webDriver.get("https://www.terrakot-yarn.ru/");

        webDriver.manage().window().setSize(new Dimension(1300, 720));

        webDriver.findElement(By.linkText("Вход")).click();

        WebElement authForm = webDriver.findElement(By.xpath("//*[@id=\"auth\"]"));  // элемент формы авторизации

        authForm.findElement(By.name("login")).sendKeys("WhiteBars");
        authForm.findElement(By.name("password")).sendKeys("wrongPassword");

//        //webDriver.findElement(By.linkText("Войти")).click();
//       authForm.findElement(By.xpath(("//input[@value='Войти']"))).click(); //войти
//
//
//        //https://www.terrakot-yarn.ru/index.php - Открывается объявление
//        // <script language=JavaScript>alert('Неверный логин или пароль, попробуйте еще раз');</script><!DOCTYPE html>

//        authForm.findElement(By.xpath(("//input[@value='Войти']"))).click(); //войти
//
//        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Ошибка авторизации!")));

    }

}

