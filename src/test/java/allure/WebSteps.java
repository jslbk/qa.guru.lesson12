package allure;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Open main page")
    public void openMainPage() {
        open("https://gitgub.com");
    }

    @Step("Search for the repository {repo}")
    public void searchForTheRepository(String repo) {
        $("[data-target='qbsearch-input.inputButton']").click();
        $("[name='query-builder-test']").sendKeys(repo);
        $("[name='query-builder-test']").submit();
    }

    @Step("Open repository by link {link}")
    public void openRepositoryByLink(String link) {
        $(linkText(link)).click();
    }

    @Step("Open 'Issues' tab")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Search issue by number {number}")
    public void searchIssueByNumber(int number) {
        $(withText("#" + number)).should(exist);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
