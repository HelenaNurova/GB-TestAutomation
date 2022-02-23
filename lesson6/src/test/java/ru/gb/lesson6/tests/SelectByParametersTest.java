package ru.gb.lesson6.tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import ru.gb.lesson5.BaseTest;
import ru.gb.lesson6.pages.MainPage;
import ru.gb.lesson6.pages.ProductsPage;

public class SelectByParametersTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"100% шерсть", "100% хлопок"})
    void selectByParametersTest(String yarnComposition) {
        webDriver.get(URL);

        new MainPage(webDriver).goToProductPage("Пряжа");
        new ProductsPage(webDriver).selectProduct(yarnComposition)
                .checkProduct(yarnComposition);
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

