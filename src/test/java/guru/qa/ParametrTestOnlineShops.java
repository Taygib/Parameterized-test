package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ParametrTestOnlineShops {


    @BeforeEach
    void setUp() {

        Configuration.browser = "edge";
        Configuration.holdBrowserOpen = true;

    }

    @CsvSource({
            "core i7, Процессор",
            "rtx 4090, Видеокарта"
    })

    @ParameterizedTest(name = "Продукт {1} должен появится при наборе {0}")
    void simpleTestProductsInDNS(

            String Name,
            String Product

    ) {

        open("https://www.dns-shop.ru");
        $("div.presearch__wrapper").click();
        $("input.presearch__input").setValue(Name).pressEnter();
        $("div.catalog-products").shouldHave(text(Product));

    }

    @Disabled
    @DisplayName("Работает через раз названия продукта исчезает в поисковике после pressEnter()")
    @Test
    @Tag("BLOCKER")
    void simpleTestProductsInWildberries() {

        open("https://www.wildberries.ru");
        $("input#searchInput").click();
        $("div#searchBlock input#searchInput").setValue("rtx 4090").pressEnter();
        $("div.catalog-page__content").shouldHave(text("Видеокарта"));

    }
}
