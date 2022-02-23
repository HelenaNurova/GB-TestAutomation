package ru.gb.lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ProductsPage goToProductPage(String tab1, String tab2, String tab3) {
        webDriver.findElement(By.xpath("//*[@id=\"left\"]//a[text()='"+ tab1 +"']")).click();
        webDriver.findElement(By.xpath("//a[text()='"+ tab2 +"']")).click();

        WebElement productContainer = webDriver.findElement(By.xpath("//*[@id=\"center\"]"));
        productContainer.findElement(By.xpath(".//div[@class=\"scatsub\"]/a[contains(@title, '"+ tab3 +"')]")).click();
        return new ProductsPage(webDriver);
    }

    public ProductsPage goToProductPage(String tab1) {
        webDriver.findElement(By.xpath("//*[@id=\"left\"]//a[text()='" + tab1 + "']")).click();
        return new ProductsPage(webDriver);
    }

}
