package ru.gb.lesson6.tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.gb.lesson5.BaseTest;
import ru.gb.lesson6.pages.MainPage;

import static org.assertj.core.api.Assertions.assertThat;

public class FillAndClearCartTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"Ангара белый 205", "Ангара жемчужная роза 231"})

    void fillAndClearCartTest(String productName) {
        webDriver.get(URL);

        new MainPage(webDriver).goToProductPage("Пряжа", "Камтекс", "АНГАРА")
                .putProductInCart(productName)
                .goToCart()
                .checkProductsInCart(productName)
                .clearCart()
                .checkCartIsEmpty();
    }

}
