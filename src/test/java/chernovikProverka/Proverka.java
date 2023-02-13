package chernovikProverka;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Proverka {

    @Test
    void proverka() {

        Configuration.browser = "edge";


        Configuration.holdBrowserOpen = true;

        open("https://moscow.petrovich.ru");


        $("input.header-search-input").click();
        $("input.header-search-input").setValue("кирпич").pressEnter();
        $(".product-list").find(byText("кирпич"));





    }


}
