package cloud.autotests.tests;

import cloud.autotests.helpers.WithLogin;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@Story("Profile tests")
public class ProfileTests extends TestBase {

    @WithLogin
    @Test
    void profilePageShouldContainValidDataTest() {
        open("");
        $(".Avatar").click();
        $$(".UserMenu__menu .Menu__item")
                .find(text("Your profile"))
                .click();
        $$(".PaneSection ").find(text("Username")).should(text("testuser"));
        $$(".PaneSection ").find(text("Full name")).should(text("Test User"));

    }

//    @WithLogin
//    @Test
//    void profileTest(){
//        open("");
//        $(".css-19attta-control").click();
//        $(byId("react-select-2-option-0")).click();
//        $(".css-1hwfws3").should(text("Show 5"));
//    }
}
