package ru.gb.lesson6.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.gb.lesson5.BaseTest;
import ru.gb.lesson6.pages.LoginPage;
import ru.gb.lesson6.pages.MainPage;

@DisplayName("Авторизация")
public class AuthTerrakotYarnTest extends BaseTest {
    String login = "WhiteBars";
    String password = "Aa123456";

    @Test
    @DisplayName("Авторизация на TerrakotYarn: существующий юзер - успешно")
    void successfulAuthTest() {
        webDriver.get(URL);

        new MainPage(webDriver).getMainHeader()
                .clickLoginButton()
                .login(login, password)
                .checkPersonalAccount(login)
                .getMainHeader()
                .logout()
                .getMainHeader()
                .checkLoginButtonIsVisible();
    }

    @Test
    @DisplayName("Авторизация на TerrakotYarn: некорректный пароль - неуспешно")
    void failedIncorrectPasswordAuthTest() {
        webDriver.get(URL);

        new MainPage(webDriver).getMainHeader()
                .clickLoginButton()
                .login(login, "wrongPassword");
        new LoginPage(webDriver).checkError("Ошибка авторизации!");
    }

}


