package cloud.autotests.tests;

import cloud.autotests.config.App;
import cloud.autotests.data.MenuItem;
import cloud.autotests.helpers.WithLogin;
import cloud.autotests.pages.ProjectPage;
import cloud.autotests.pages.ProjectTable;
import cloud.autotests.pages.TestCasesTable;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

@Story("Project tests")
public class ProjectTests extends TestBase {

    private static final String PROJECT_NAME = "teacher qa_guru_diplom_project";

    @WithLogin
    @Test
    void projectPageShouldContains5Widgets() {
        ProjectTable projectTable = open(App.config.webUrl(), ProjectTable.class);
        ProjectPage projectPage = projectTable.navigateTo(PROJECT_NAME);
        projectPage.checkThatWidgetsDisplayed();
    }

    @WithLogin
    @Test
    void testcaseListDisplayedAfterNavigateBySidebar() {
        ProjectTable projectTable = open(App.config.webUrl(), ProjectTable.class);
        ProjectPage projectPage = projectTable.navigateTo(PROJECT_NAME);
        projectPage.getSidebar().navigateTo(MenuItem.TEST_CASES);
        TestCasesTable casesTable = new TestCasesTable();
        casesTable.shouldHaveSize(12);
    }

}
