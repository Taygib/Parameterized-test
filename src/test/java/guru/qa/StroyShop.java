package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StroyShop {
    @BeforeEach
    void setUp() {

        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;

    }

    @CsvSource({
            "кирпич, кирпич",
            "кабель ввг нг 3х2 5, кабель ввг",
            "стусло, стусло"

    })

    @ParameterizedTest(name = "Продукт {1} должен появится при наборе {0}")
    void simpleTestProductsInDNS(

            String StroyMat,
            String WhatIsThere

    ) {

        open("https://moscow.petrovich.ru");

        $("input.header-search-input").click();
        $("input.header-search-input").setValue(StroyMat).pressEnter();
        $(".product-list").find(byText(WhatIsThere));

    }
}
