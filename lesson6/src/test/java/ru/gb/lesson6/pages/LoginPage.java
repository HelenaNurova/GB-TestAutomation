package ru.gb.lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPage extends BasePage{

    @FindBy(name = "login")
    private WebElement userNameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"auth\"]/b")
    private WebElement errorMessage;

    @FindBy(xpath = "//input[@value='Войти']")
    private WebElement loginButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage login(String login, String password) {
        By authFormLocator = By.xpath("//*[@id=\"auth\"]");
        new WebDriverWait(webDriver, 5)
                .until(ExpectedConditions
                .presenceOfElementLocated(authFormLocator));

        WebElement authForm = webDriver.findElement(authFormLocator);
        (userNameInput).sendKeys(login);
        (passwordInput).sendKeys(password);
        (loginButton).click();
        return this;
    }

    public MainPage checkPersonalAccount(String login) {
        webDriver.findElement(By.xpath(("//*[@id=\"enter\"]"))).click();
        assertThat(webDriver.findElement(By.xpath("//*[@id=\"auth\"]/h2")).getText())
                .isEqualTo(login);
        return new MainPage(webDriver);
    }

    public void checkError(String errorText) {
        webDriver.switchTo().alert().dismiss();
        webDriver.findElement(By.linkText("Вход")).click();
        assertThat(errorMessage.getText())
                .isEqualTo(errorText);

    }

}

