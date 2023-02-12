package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StroyShop {
    @BeforeEach
    void setUp() {

        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;

    }


    @ValueSource(
            strings = {"Стройматериалы", "Инструмент", "Электрика", "Инженерные системы", "Интерьер и отделка"}
    )

    @ParameterizedTest()
    void simpleTestProductsInDNS(

            String WhatIsThere

    ) {

        open("https://moscow.petrovich.ru");
        $("div.subheader-content").find(byText(WhatIsThere));

    }
}
