package guru.qa;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import guru.qa.data.Razdel;
import guru.qa.data.RazdelBmw;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class Bmw {

    @BeforeEach
    void setUp() {

        Configuration.browser = "opera";
        Configuration.holdBrowserOpen = true;

    }
    static Stream<Arguments> BmwRazdel () {
        return Stream.of(
                Arguments.of(RazdelBmw.Серии, List.of("I", "X", "M", "8", "7", "6", "5", "4", "3", "2", "Z4")),
                Arguments.of(RazdelBmw.Тип,List.of("Хатчбэк", "Седан", "Купе", "GT", "Кабрио", "Гран Купе",
                        "Sports Activity Coupe", "Sports Activity Vehicle", "Родстер"))

        );
    }

    @MethodSource
    @ParameterizedTest( name = "Для раздела {0} отображается подраздел {1}")
    @Tag("BLOCKER")
    void BmwRazdel (

            RazdelBmw razdel,
            List<String> buttons
    ){

        open("https://www.bmw.ru/ru/index.html");

        $$("div.ds2-model-menu").find(text(razdel.name())).click();

        // клик не происходит

        $$("div.columns").shouldHave(CollectionCondition.texts(buttons));

    }



}
