package ru.gb.lesson.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SelectByParametersTest extends BaseTest{

    @Test
    void selectByParametersTest() {

        webDriver.get("https://www.terrakot-yarn.ru/");

        webDriver.manage().window().setSize(new Dimension(1500, 1300));

        new Actions(webDriver)
                .moveToElement(webDriver.findElement(By.xpath("//*[@id=\"left\"]/ul/li/a[text()=\"Пряжа\"]")))
                .click()
                .perform();

        webDriver.findElement(By.xpath("//*[@id=\"select\"]")).click();

        webDriver.findElement(By.xpath("//*[@id=\"sostav\"]/label[1]/input")).click();

        webDriver.findElement(By.xpath("//*[@id=\"select\"]")).click();

        webDriver.findElement(By.xpath("//*[@id=\"submit\"]")).click();


//        new WebDriverWait(webDriver,10).until(ExpectedConditions.presenceOfElementLocated(By.linkText("100% шерсть"))); //проверяем наличие выбранного параметра
//
//        System.out.println("Actual parameter = " + webDriver.findElements(By.xpath("//*[@id=\"center\"]/ul/li[1]/div[2]/span")));
//
//        System.out.println("Expected value = "100% шерсть");


    }
}
