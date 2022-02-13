package ru.gb.lesson.lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public MainPage login(String login, String password){

        WebElement authForm = webDriver.findElement(By.xpath("//*[@id=\"auth\"]"));  // элемент формы авторизации
        authForm.findElement(By.name("login")).sendKeys(login);
        authForm.findElement(By.name("password")).sendKeys(password);
        authForm.findElement(By.xpath(("//input[@value='Войти']"))).click(); //войти
        return new MainPage(webDriver);

    }

    public void checkError(String errorText){
        WebElement authForm = webDriver.findElement(By.xpath("//*[@id=\"auth\"]"));
        authForm.findElement(By.xpath(("//input[@value='Войти']"))).click(); //войти
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Ошибка авторизации!")));

    }

}
