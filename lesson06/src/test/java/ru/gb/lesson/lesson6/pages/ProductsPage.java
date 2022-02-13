package ru.gb.lesson.lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {

    WebDriver webDriver;

    public ProductsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ProductsPage putProductInCart(String productName) {
        webDriver.findElement(By.xpath("//*[@id=\"center\"]/div[3]/a")).click();  //Ангара белый 205
        webDriver.findElement(By.xpath("//*[@id=\"center\"]/table/tbody/tr[1]/td[2]/div/p/a")).click();  // клик "В корзину"
        new WebDriverWait(webDriver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Добавлено в корзину!')]")));
        return new ProductsPage(webDriver);
    }

    public CartPage goToCart() {
        webDriver.findElement(By.xpath("//*[@id=\"basket_div\"]/a")).click();  //переходим в корзину
        return new CartPage(webDriver);
    }
}
