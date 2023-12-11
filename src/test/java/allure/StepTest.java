package allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int ISSUE = 80;

    @Test
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open main page", () -> {
            open("https://gitgub.com");
        });
        step("Search for the repository " + REPOSITORY, () -> {
            $("[data-target='qbsearch-input.inputButton']").click();
            $("[name='query-builder-test']").sendKeys(REPOSITORY);
            $("[name='query-builder-test']").submit();
        });
        step("Open repository by link " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Open 'Issues' tab", () -> {
            $("#issues-tab").click();
        });
        step("Search issue by number " + "#" + ISSUE, () -> {
            $(withText("#" + ISSUE)).should(exist);
        });
    }

    @Test
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForTheRepository(REPOSITORY);
        steps.openRepositoryByLink(REPOSITORY);
        steps.openIssuesTab();
        steps.searchIssueByNumber(ISSUE);
    }

}