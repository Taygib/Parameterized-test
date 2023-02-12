package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Mvideo {

    @BeforeEach
    void setUp() {

        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;

    }


    @CsvFileSource(resources = "/TestDataMvideo.csv" )

    @ParameterizedTest(name = "Продукт {1} должен появится при наборе {0}")
    void simpleTestProductsInDNS(

            String Category,
            String WhatIsThere

    ) {

        open("https://www.mvideo.ru/");

        $("div.input__container").click();
        $("div.input__container").$("input.input__field").setValue(Category).pressEnter();
        $("product-cards-layout").find(byText(WhatIsThere));

    }
}
