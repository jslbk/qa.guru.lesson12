package allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test
    @Feature("Issue in repository")
    @Story("Issue creating")
    @Owner("jslbk")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Testing", url = "https://testing-github.com")
    @DisplayName("Issue creating for the authorised user")

    public void publicStaticLabelsTest() {
    }

    @Test
    public void publicDynamicLabelsTest() {
        Allure.getLifecycle().updateTestCase(
                t -> t.setName("Issue creating for the authorised user")
        );
        Allure.feature("Issue in repository");
        Allure.story("Issue creating");
        Allure.label("owner", "jslbk");
        Allure.label("severity", SeverityLevel.CRITICAL.value());
        Allure.link("Testing", "https://testing-github.com");
    }
}
