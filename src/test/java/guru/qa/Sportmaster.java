package guru.qa;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import guru.qa.data.Razdel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Sportmaster {

    @BeforeEach
    void setUp() {

        Configuration.browser = "opera";
        Configuration.holdBrowserOpen = true;

    }
    static Stream<Arguments> sportmasterRazdel () {
        return Stream.of(
                Arguments.of(Razdel.ЖЕНЩИНАМ,List.of("Легинсы", "Кошельки и косметички", "Ледовые коньки", "Йога")),
                Arguments.of(Razdel.МУЖЧИНАМ,List.of("Рубашки", "Бутсы", "Ремни", "Единоборства")),
                Arguments.of(Razdel.БРЕНДЫ, List.of("Nike", "FILA", "Demix", "adidas", "PUMA"))
        );
    }

    @MethodSource
    @ParameterizedTest( name = "Для раздела {0} отображается подраздел {1}")
    @Tag("BLOCKER")
    void sportmasterRazdel (

            Razdel razdel,
            List<String> buttons
    ){

        open("https://www.sportmaster.ru");
        $$("ul.sm-header__catalog").find(text(razdel.name())).hover();

        $$("div.section__content").shouldHave(CollectionCondition.texts(buttons));

    }




}
