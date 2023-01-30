package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LeroyMerlin {

    @Test
    void testLeroy () {


        open("https://www.leroymerlin.ru");
        Configuration.holdBrowserOpen = true;


        $("div.i1qk01jd_main_page").click();
        $("div.i1e42ife_main_page").$("input.c1vr6imw_main_page").setValue("кирпич").pressEnter();

    }
}
