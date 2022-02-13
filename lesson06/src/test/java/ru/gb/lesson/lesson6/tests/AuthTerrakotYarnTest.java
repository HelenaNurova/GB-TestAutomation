package ru.gb.lesson.lesson6.tests;

import com.sun.tools.javac.Main;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.gb.lesson.lesson5.BaseTest;
import ru.gb.lesson.lesson6.pages.LoginPage;
import ru.gb.lesson.lesson6.pages.MainPage;


@DisplayName("Авторизация на  TerrakotYarn")
public class AuthTerrakotYarnTest extends BaseTest {
    String login = "WhiteBars";
    String password = "Aa123456";



    @DisplayName("Авторизация: существующий юзер - позитивный")
    @Test
    void successfulAuthTest() {

        webDriver.get(URL);

        new MainPage(webDriver).clickLoginButton()
                .login(login, password)
                .logOut()
                .checkLoginButtonIsVisible();

    }


    @DisplayName("Авторизация: некорректный пароль - негативный")
    @Test
    void incorrectAuthTest() {

        webDriver.get(URL);

        new MainPage(webDriver).clickLoginButton()
                .login(login, "wrongPassword");

//        new LoginPage(webDriver).checkError("Ошибка авторизации!");

//        webDriver.findElement(By.linkText("Вход")).click();
//
//        WebElement authForm = webDriver.findElement(By.xpath("//*[@id=\"auth\"]"));  // элемент формы авторизации
//
//        authForm.findElement(By.name("login")).sendKeys("WhiteBars");
//        authForm.findElement(By.name("password")).sendKeys("wrongPassword");



    }

}

