package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class JunitTest {

    @Disabled("эта анотация позволяет исключить какой-либо тест без двойных слешов")
    @DisplayName("Демонстрационнный тест")
    @Test
    void simpleTest () {

        open("https://www.microsoft.com/ru-ru");

    }

    @BeforeEach        // это предусловие
    void setUP() {

        open("https://www.google.ru");
        Configuration.holdBrowserOpen = true;

    }


    @DisplayName("Демонстрационнный тест")  // т.е вместо двойного слеша можно таким образом закоментировать
    @Test
    @Tags({@Tag("BLOCKER"),@Tag("UI")}) // тут указываем доп. параметры
    void simpleTest1 () {


        $("input.gLFyf").click();
        $("input.gLFyf").setValue("github").pressEnter();
        $(".BYM4Nd").$(".LC20lb").click();


    }


}
