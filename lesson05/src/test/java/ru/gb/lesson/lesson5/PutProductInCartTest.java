package ru.gb.lesson.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PutProductInCartTest extends BaseTest{

   // @ValueSource(strings = "Ангара белый 205")
    @Test
    void putProductInCartTest() {

        webDriver.get("https://www.terrakot-yarn.ru/");

        webDriver.manage().window().setSize(new Dimension(1500, 1300));
        new Actions(webDriver)
                .moveToElement(webDriver.findElement(By.xpath("//*[@id=\"left\"]/ul/li/a[text()=\"Пряжа\"]")))
                .click()
                .perform();

        webDriver.findElement(By.xpath("//a[text()='Камтекс']")).click();

        webDriver.findElement(By.xpath("//*[@id=\"center\"]/div[3]/a")).click();  //Ангара белый 205
        webDriver.findElement(By.xpath("//*[@id=\"center\"]/table/tbody/tr[1]/td[2]/div/p/a")).click();  // клик "В корзину"
        new WebDriverWait(webDriver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Добавлено в корзину!')]")));

        webDriver.findElement(By.xpath("//*[@id=\"basket_div\"]/a")).click();  //переходим в корзину

        new WebDriverWait(webDriver,10).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Ангара белый 205"))); //проверяем наличие выбранного товара
//        assertThat(webDriver.findElement(By.xpath("")));
//        assertThat(webDriver.findElements(By.xpath("//*[@id=\"bask_del1\"]/td[1]"))).hasSize(1);

    }
}






