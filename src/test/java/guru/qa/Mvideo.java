package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Mvideo {


    @Test

    void test () {

        open("https://www.mvideo.ru");
        Configuration.holdBrowserOpen = true;

        $("div.input").click();
        $("div.input").$("input.input__field").setValue("ноутбук").pressEnter();
        $("div.product-cards-layout").shouldHave(text("ноутбук"));





    }
}
