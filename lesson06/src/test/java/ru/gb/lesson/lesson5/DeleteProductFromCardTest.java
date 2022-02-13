package ru.gb.lesson.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
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

public class DeleteProductFromCardTest extends BaseTest {

    @Test
    void deleteProductInCartTest() {

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

       // AssertionsForClassTypes.<List<WebElement>>assertThat(webDriver.findElements(By.xpath("//*[@id=\"inp1\"]"))).has(1);

        System.out.println("Actual cart size = " + webDriver.findElements(By.xpath("//*[@id=\"inp1\"]")).size());
        System.out.println("Expected cart size = 1");

        webDriver.findElement(By.xpath("//*[@id=\"bask_del1\"]/td[5]/p")).click();
        new WebDriverWait(webDriver,10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"bask_empty\"]")));
        System.out.println("Ваша корзина пуста.");


    }
}


