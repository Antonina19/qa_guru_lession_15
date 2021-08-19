package cloud.autotests.pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;

public class ProjectTable {

    private ElementsCollection tableRows = $$("li.list-row ");

    @Step("Navigate to project '{projectName}'")
    public ProjectPage navigateTo(String projectName) {
        tableRows.find(text(projectName)).$(".ProjectCard__name > a").click();
        return new ProjectPage();
    }
}
