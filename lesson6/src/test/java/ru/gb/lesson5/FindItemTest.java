package ru.gb.lesson5;

import org.assertj.core.api.ListAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

@DisplayName("Поисковая строка")
public class FindItemTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"Ангара белый 205", "Ангара жемчужная роза 231"})
    @DisplayName("Поисковая строка: поиск по наименованию - успешно")
    void findByNameTest(String productName) {

        webDriver.get("https://www.terrakot-yarn.ru/");
        webDriver.manage().window().setSize(new Dimension(1920, 1080));

        webDriver.findElement(By.xpath("//*[@id=\"search_field\"]")).sendKeys(productName);
        webDriver.findElement(By.xpath("//*[@id=\"search\"]/input[@type=\"image\"]")).click();
        webDriver.findElement(By.linkText("АНГАРА")).click();

        List<WebElement> products = webDriver.findElements(By.xpath("//*[@class=\"items_div\"]"));

        assertThat( products.stream()
                .filter(pr -> pr.getText().contains(productName)));


    }
}




