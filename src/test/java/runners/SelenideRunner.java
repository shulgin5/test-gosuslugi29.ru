package runners;

import com.codeborne.selenide.Selenide;
import config.SelenoidConfig;
import config.UrlConfig;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import static com.codeborne.selenide.Selenide.open;

public class SelenideRunner {

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        SelenoidConfig config = new SelenoidConfig();
        config.createWebDriverInstance();
        open(UrlConfig.urlPortal);
    }

    @AfterSuite
    public void closeConnection() {
        Selenide.closeWebDriver();
    }
}
