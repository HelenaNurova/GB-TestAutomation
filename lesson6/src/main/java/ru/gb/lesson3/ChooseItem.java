package ru.gb.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ChooseItem {
    public static void main( String[] args ) throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.get("https://www.terrakot-yarn.ru/");
        webDriver.manage().window().setSize(new Dimension(1920, 1080));

        webDriver.findElement(By.xpath("//*[@id=\"left\"]/ul/li/a[text()=\"Пряжа\"]")).click();
        webDriver.findElement(By.xpath("//a[text()='Камтекс']")).click();

        WebElement productContainer = webDriver.findElement(By.xpath("//*[@id=\"center\"]"));
        productContainer.findElement(By.xpath("//div[@class=\"scatsub\"]/a[contains(@title, 'АНГАРА')]")).click();

        List<WebElement> products = webDriver.findElements(By.xpath("//*[@class=\"items_div\"]//*[@class=\"toBasket\"]"));  // выбираем элемент
        products.get(1).click();

        webDriver.findElement(By.xpath(("//*[@id=\"basket_div\"]/a"))).click(); //Моя корзина
        Thread.sleep(10000);

        System.out.println("Actual basket size = " + webDriver.findElements(By.xpath("//p[.='Удалить']")).size());  //Проверяем кол-во позиций в корзине
        System.out.println("Expected basket size = 1");

        new WebDriverWait(webDriver, 5).until(ExpectedConditions
                .presenceOfElementLocated(By.xpath(("//*[@id=\"bask_form\"]/a[text()='Очистить корзину']"))))
                .click();

        webDriver.findElement(By.xpath("//*[@id=\"bask_empty\"]")); //Проверяем, что корзина пуста
        System.out.println("Basket is empty");

        webDriver.quit();

    }
}