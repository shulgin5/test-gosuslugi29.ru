package tests;
import config.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import steps.Steps;

import static com.codeborne.selenide.Selenide.open;


public class MainTest extends BasePage{

    @BeforeMethod(alwaysRun = true)
    public void setConfiguration() {
        open(TestConfig.urlPortal);
    }

    @Test
    public void main() {
        Steps.checkAuthorization(mainPage.getUsername());
        mainPage.goToCatalog();
        catalogPage.loadMore();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {}
    }
}
