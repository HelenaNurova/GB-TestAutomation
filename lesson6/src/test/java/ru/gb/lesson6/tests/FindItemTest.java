package ru.gb.lesson6.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.gb.lesson5.BaseTest;
import ru.gb.lesson6.pages.MainPage;
import ru.gb.lesson6.pages.ProductsPage;
import ru.gb.lesson6.pages.blocks.MainHeader;

@DisplayName("Поисковая строка")
public class FindItemTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"Ангара белый 205", "Ангара жемчужная роза 231"})
    @DisplayName("Поисковая строка: поиск по наименованию - успешно")
    void findByNameTest(String productName) {
        webDriver.get(URL);

        new MainPage(webDriver).getMainHeader()
                .fillInSearchBar(productName);
        new ProductsPage(webDriver).searchProductInList("АНГАРА")
                .checkProductIsInList(productName);
    }

}






