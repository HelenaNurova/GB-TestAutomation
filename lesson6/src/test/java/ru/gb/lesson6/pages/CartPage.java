package ru.gb.lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CartPage extends BasePage{

    protected CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public CartPage checkProductsInCart(String... productNames) {
        List<String> actualProducts = webDriver.findElements(By.xpath("//*[contains(@id,'bask_del')]"))
                .stream()
                .map(el -> el.findElement(By.xpath("//*[@id=\"bask_del1\"]//a")).getText())
                .collect(Collectors.toList());

        assertThat(actualProducts)
                .as("Название продукта в корзине должно соответствовать ожидаемому " + productNames)
                .containsExactlyInAnyOrder(productNames);
        return this;
    }

    public CartPage clearCart() {
        webDriver.findElement(By.linkText("Очистить корзину")).click();
        return new CartPage(webDriver);
    }

    public void checkCartIsEmpty() {
        assertThat(webDriver.findElement(By.xpath("//div[@id=\"center\"]/*")).getAttribute("bask_empty"));
    }
}
