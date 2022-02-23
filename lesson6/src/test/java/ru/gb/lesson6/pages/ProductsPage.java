package ru.gb.lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
public class ProductsPage extends BasePage{

    public ProductsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ProductsPage putProductInCart(String productName) {
        List<WebElement> products = webDriver.findElements(By.xpath("//*[@class=\"items_div\"]"));
        products.stream()
                .filter(pr -> pr.getText().contains(productName))
                .findFirst().orElseThrow(() -> new NoSuchElementException("Товар " + productName  + " отсутствует на странице"))
                .findElement(By.xpath(".//*[@class=\"toBasket\"]")).click();
        return this;
    }

    public CartPage goToCart() {
        webDriver.findElement(By.xpath(("//*[@id=\"basket_div\"]/a"))).click();
        return new CartPage(webDriver);
    }

    public ProductsPage searchProductInList(String sortProduct) {
        webDriver.findElement(By.linkText(sortProduct)).click();
        return new ProductsPage(webDriver);
    }

    public void checkProductIsInList(String productName) {
        List<WebElement> products = webDriver.findElements(By.xpath("//*[@class=\"items_div\"]"));

        assertThat( products.stream()
                .filter(pr -> pr.getText().contains(productName)));
    }

    public ProductsPage selectProduct(String yarnComposition) {
        webDriver.findElement(By.xpath("//*[@id=\"select\"]")).click();

        List<WebElement> products = webDriver.findElements(By.xpath("//*[@id=\"sostav\"]/label"));  // выбираем элемент
        products.stream()
                .filter(pr -> pr.getText().contains(yarnComposition))
                .findFirst().orElseThrow(() -> new NoSuchElementException("Пряжа с составом " + yarnComposition  + " отсутствует")).click();

        webDriver.findElement(By.xpath("//*[@id=\"select\"]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        return new ProductsPage(webDriver);
    }

    public void checkProduct(String yarnComposition) {
        List<WebElement> listOfElements = webDriver.findElements(By.xpath("//*[@id=\"center\"]/ul/li//span"));
        assertThat(listOfElements.stream()
                .filter(pr -> pr.getText().contains(yarnComposition))
                .findFirst().orElseThrow(() -> new NoSuchElementException("Пряжа с составом " + yarnComposition + " отсутствует")));
        }


    }
