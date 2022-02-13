package ru.gb.lesson.lesson6.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.gb.lesson.lesson5.BaseTest;
import ru.gb.lesson.lesson6.pages.MainPage;

import java.net.URL;

public class PutProductInCartTest extends BaseTest {


    @ParameterizedTest
    @ValueSource(strings = {"Ангара белый 205"})
    void putProductInCartTest(String ProductName) {


        webDriver.get(URL);

        new MainPage(webDriver).goToProductPage("Пряжа", "Камтекс")
                .putProductInCart(ProductName)
                .goToCart()
                .checkProductsInCart(ProductName);

    }
}






