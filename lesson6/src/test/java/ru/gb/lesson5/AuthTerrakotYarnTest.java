package ru.gb.lesson5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Авторизация")
public class AuthTerrakotYarnTest extends BaseTest {

    @Test
    @DisplayName("Авторизация на TerrakotYarn: существующий юзер - успешно")
    void successfulAuthTest() {

        //whitebars70@rambler.ru
        //Aa123456

        webDriver.get("https://www.terrakot-yarn.ru/");
        webDriver.manage().window().setSize(new Dimension(1920, 1080));

        webDriver.findElement(By.linkText("Вход")).click();

        By authFormLocator = By.xpath("//*[@id=\"auth\"]");
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(authFormLocator));
        WebElement authForm = webDriver.findElement(authFormLocator);
        authForm.findElement(By.name("login")).sendKeys("WhiteBars");
        authForm.findElement(By.name("password")).sendKeys("Aa123456");
        authForm.findElement(By.xpath(("//input[@value='Войти']"))).click();

        webDriver.findElement(By.xpath(("//*[@id=\"enter\"]"))).click(); //личный кабинет

        assertThat(webDriver.findElement(By.xpath("//*[@id=\"auth\"]/h2")).getText())
                .isEqualTo("WhiteBars");

        webDriver.findElement(By.xpath(("//*[text()='Выйти']"))).click(); //выйти


    }


    @Test
    @DisplayName("Авторизация на TerrakotYarn: некорректный пароль - неуспешно")
    void failedIncorrectPasswordAuthTest() {

        webDriver.get("https://www.terrakot-yarn.ru/");
        webDriver.manage().window().setSize(new Dimension(1920, 1080));

        webDriver.findElement(By.linkText("Вход")).click();

        By authFormLocator = By.xpath("//*[@id=\"auth\"]");
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(authFormLocator));
        WebElement authForm = webDriver.findElement(authFormLocator);
        authForm.findElement(By.name("login")).sendKeys("WhiteBars");
        authForm.findElement(By.name("password")).sendKeys("wrongPassword");
        authForm.findElement(By.xpath(("//input[@value='Войти']"))).click();

        webDriver.switchTo().alert().dismiss();  //отключение алерта

        webDriver.findElement(By.linkText("Вход")).click();

        assertThat(webDriver.findElement(By.xpath("//*[@id=\"auth\"]/b")).getText())
                .isEqualTo("Ошибка авторизации!");

    }

}
