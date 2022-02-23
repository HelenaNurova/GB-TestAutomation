package ru.gb.lesson5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

public class PutProductInCartTest extends BaseTest{

    @ParameterizedTest
    @ValueSource(strings = {"Ангара белый 205", "Ангара жемчужная роза 231"})

    void putProductInCartTest(String productName) {

        webDriver.get("https://www.terrakot-yarn.ru/");
        webDriver.manage().window().setSize(new Dimension(1920, 1080));

        webDriver.findElement(By.xpath("//*[@id=\"left\"]//a[text()='Пряжа']")).click();
        webDriver.findElement(By.xpath("//a[text()='Камтекс']")).click();

        WebElement productContainer = webDriver.findElement(By.xpath("//*[@id=\"center\"]"));
        productContainer.findElement(By.xpath(".//div[@class=\"scatsub\"]/a[contains(@title, 'АНГАРА')]")).click();

        List<WebElement> products = webDriver.findElements(By.xpath("//*[@class=\"items_div\"]"));  // выбираем элемент
        products.stream()
                .filter(pr -> pr.getText().contains(productName))
                .findFirst().orElseThrow(() -> new NoSuchElementException("Товар " + productName  + " отсутствует на странице"))
                .findElement(By.xpath(".//*[@class=\"toBasket\"]")).click();


        webDriver.findElement(By.xpath(("//*[@id=\"basket_div\"]/a"))).click(); //Моя корзина


        List<WebElement> productsInCart = webDriver.findElements(By.xpath("//*[contains(@id,'bask_del')]"));
        assertThat(productsInCart).hasSize(1);


        assertThat(productsInCart.get(0).findElement(By.xpath("//*[@id=\"bask_del1\"]//a")).getText())
                .as("Название продукта в корзине должно быть " + productName)
                .isEqualTo(productName);

        new WebDriverWait(webDriver, 5).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(("//*[@id=\"bask_form\"]/a[text()='Очистить корзину']"))))
                .click();

    }
}
