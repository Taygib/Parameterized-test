package guru.qa;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class Prostotak {

    @BeforeEach
    void setup (){

        Configuration.browser = "opera";
        Configuration.holdBrowserOpen = true;
    }

    @Test
            void test () {
        open("https://www.mvideo.ru");


        $("div.slide-panel__content").$(withText("Телевизоры")).click();
        $$("div.plp__collections-container").shouldHave(CollectionCondition.texts("LG NanoCell"));


    }


}
