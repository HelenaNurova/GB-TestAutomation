package ru.gb.lesson.lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    WebDriver webDriver;

    public CartPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void checkProductsInCart(String productName) {
        new WebDriverWait(webDriver,10).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Ангара белый 205")));
    }
}
