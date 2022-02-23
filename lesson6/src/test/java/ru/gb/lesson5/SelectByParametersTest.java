package ru.gb.lesson5;
import io.github.bonigarcia.wdm.WebDriverManager;
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
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelectByParametersTest extends BaseTest{

    @ParameterizedTest
    @ValueSource(strings = {"100% шерсть", "100% хлопок"})
    void selectByParametersTest(String yarnComposition) {

        webDriver.get("https://www.terrakot-yarn.ru/");
        webDriver.manage().window().setSize(new Dimension(1920, 1080));

        webDriver.findElement(By.xpath("//*[@id=\"left\"]//a[text()='Пряжа']")).click();
        webDriver.findElement(By.xpath("//*[@id=\"select\"]")).click();

        List<WebElement> products = webDriver.findElements(By.xpath("//*[@id=\"sostav\"]/label"));  // выбираем элемент
        products.stream()
                .filter(pr -> pr.getText().contains(yarnComposition))
                .findFirst().orElseThrow(() -> new NoSuchElementException("Пряжа с составом " + yarnComposition  + " отсутствует")).click();

        webDriver.findElement(By.xpath("//*[@id=\"select\"]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"submit\"]")).click();


        List<WebElement> listOfElements = webDriver.findElements(By.xpath("//*[@id=\"center\"]/ul/li//span"));
        assertThat(listOfElements.stream()
                .filter(pr -> pr.getText().contains(yarnComposition))
                .findFirst().orElseThrow(() -> new NoSuchElementException("Пряжа с составом " + yarnComposition  + " отсутствует")));

    }
































//        webDriver.get("https://www.terrakot-yarn.ru/");
//        webDriver.manage().window().setSize(new Dimension(1920, 1080));;
//
//        new Actions(webDriver)
//                .moveToElement(webDriver.findElement(By.xpath("//*[@id=\"left\"]/ul/li/a[text()=\"Пряжа\"]")))
//                .click()
//                .perform();
//
//        webDriver.findElement(By.xpath("//*[@id=\"select\"]")).click();
//
//        webDriver.findElement(By.xpath("//input[@value='100% шерсть']")).click();
//
//        webDriver.findElement(By.xpath("//*[@id=\"select\"]")).click();
//
//        webDriver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
//
//        assertThat(webDriver.findElement(By.xpath("//*[@id=\"bask_del1\"]//a")).getText())
//                .as("Название продукта в корзине должно быть " + productName)
//                .isEqualTo(productName);

     //   new WebDriverWait(webDriver,10).until(ExpectedConditions.presenceOfElementLocated(By.linkText("100% шерсть"))); //проверяем наличие выбранного параметра
//
//        System.out.println("Actual parameter = " + webDriver.findElements(By.xpath("//*[@id=\"center\"]/ul/li[1]/div[2]/span")));
//
//        System.out.println("Expected value = "100% шерсть");


    }

