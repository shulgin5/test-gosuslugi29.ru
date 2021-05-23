package runners;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideConfig;
import config.SelenoidConfig;
import config.TestConfig;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Selenide.open;

public class SelenideRunner {

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        SelenoidConfig config = new SelenoidConfig();
        config.createWebDriverInstance();
        open(TestConfig.urlPortal);
    }

    @AfterClass
    public void closeConnection() {
        Selenide.closeWebDriver();
    }

}
