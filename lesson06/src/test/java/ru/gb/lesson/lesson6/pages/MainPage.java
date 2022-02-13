package ru.gb.lesson.lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public LoginPage clickLoginButton(){

        webDriver.findElement(By.linkText("Вход")).click();
        return new LoginPage(webDriver);
    }

    public MainPage logOut(){

        webDriver.findElement(By.xpath(("//*[@id=\"enter\"]"))).click(); //войти в личный кабинет
        webDriver.findElement(By.xpath(("//*[text()='Выйти']"))).click(); //выйти
        return new MainPage(webDriver);

    }

    public MainPage checkLoginButtonIsVisible(){

        new WebDriverWait(webDriver,10).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Вход")));
        return this;
    }

    public ProductsPage goToProductPage(String tab1, String tab2) {

        new Actions(webDriver)
                .moveToElement(webDriver.findElement(By.xpath("//*[@id=\"left\"]/ul/li/a[text()=\"Пряжа\"]")))
                .click()
                .perform();

        webDriver.findElement(By.xpath("//a[text()='Камтекс']")).click();
        return new ProductsPage(webDriver);
    }
}
