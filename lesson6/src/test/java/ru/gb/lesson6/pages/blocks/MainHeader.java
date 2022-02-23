package ru.gb.lesson6.pages.blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.gb.lesson6.pages.BaseView;
import ru.gb.lesson6.pages.LoginPage;
import ru.gb.lesson6.pages.MainPage;

public class MainHeader extends BaseView {
    public MainHeader(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage clickLoginButton() {
        webDriver.findElement(By.linkText("Вход")).click();
        return new LoginPage(webDriver);
    }

    public MainPage logout() {
        webDriver.findElement(By.xpath(("//*[text()='Выйти']"))).click();
        return new MainPage(webDriver);
    }

    public MainPage checkLoginButtonIsVisible() {
        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.linkText("Вход")));
        return new MainPage(webDriver);
    }

    public MainPage fillInSearchBar(String productName){
        webDriver.findElement(By.xpath("//*[@id=\"search_field\"]")).sendKeys(productName);
        webDriver.findElement(By.xpath("//*[@id=\"search\"]/input[@type=\"image\"]")).click();
        return new MainPage(webDriver);
    }


}
