package runners;


import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideConfig;
import config.SelenoidConfig;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class SelenideRunner {

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        SelenoidConfig config = new SelenoidConfig();
        config.createWebDriverInstance();
    }

    @AfterClass
    public void closeConnection() {
        Selenide.closeWebDriver();
    }

}
