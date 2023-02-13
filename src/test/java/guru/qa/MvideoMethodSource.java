package guru.qa;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import guru.qa.data.RazdelBmw;
import guru.qa.data.RazdelMvideo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class MvideoMethodSource {


    @BeforeEach
    void setUp() {

        Configuration.browser = "opera";
        Configuration.holdBrowserOpen = true;

    }
    static Stream<Arguments> mvideoRazdel () {
        return Stream.of(
                Arguments.of(RazdelMvideo.Телевизоры, List.of("LG NanoCell58" +" "+ "белые19" +" "+ "70 дюймов10" +" "+ "22 дюйма" +" "+
                        "24 дюйма22" +" "+ "28 дюймов2" +" "+ "32 дюйма102" +" "+ "43 дюйма111" +" "+ "49 дюймов" +" "+ "Eщё")),
                Arguments.of(RazdelMvideo.Ноутбуки,List.of("мощные503" +" "+ "тонкие38" +" "+ "MacBook Air (2020)6" +" "+
                        "Apple MacBook (2022)151" +" "+ "apple macbook 202112" +" "+ "MacBook Pro 13 (2020)12" +" "+ "для бизнеса32" +" "+ "Eщё"))

        );
    }

    @MethodSource
    @ParameterizedTest( name = "Для раздела {0} отображается подраздел {1}")
    @Tag("BLOCKER")
    void mvideoRazdel (

            RazdelMvideo razdel,
            List<String> buttons
    ){

        open("https://www.mvideo.ru");

        $("div.slide-panel__content").$(withText(razdel.name())).click();
        $$("div.plp__collections-container").shouldHave(texts(buttons));



       // $$("div.ds2-model-menu").find(text(razdel.name())).click();

        //$$("div.columns").shouldHave(CollectionCondition.texts(buttons));

    }



}
