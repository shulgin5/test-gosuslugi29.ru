package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BasePage;
import steps.Steps;
import java.util.List;
import static com.codeborne.selenide.Selenide.open;

public class MainTest extends BasePage{

    private Object[][] allServicesObject;

   /* @DataProvider(name = "services")
    public Object[][] allServices() {
        return allServicesObject;
    }*/

    @DataProvider(name = "services")
    public Object[][] allServices() {
        return new Object[][]{
            {"https://gosuslugi29.ru/pgu/services/info.htm?id=10493@egService"},
                {"https://gosuslugi29.ru/pgu/services/info.htm?id=8456@egService"}
        };
    }

    @Test
    public void main() {
        Steps.checkAuthorization(mainPage.getUsername());
        mainPage.goToCatalog();
        catalogPage.loadMore();
        List<String> categories = catalogPage.getLinksCategories();
        Steps.checkCategoriesCount(categories.size());
        open(categories.get(13));
        catalogPage.loadMore();
        this.allServicesObject = catalogPage.getLinksServices();
    }

    @Test(dataProvider = "services")
    @Description(value = "Проверка услуги")
    public void serviceTest(String href) {
        open(href);
        Steps.checkServiceName(servicePage.getServiceName());
        Steps.haveNoElecronicServices(servicePage.countNoElectonicSubServices());
        Steps.haveElecronicServices(servicePage.countElectonicSubServices());
        Steps.checkSubServices(servicePage);
    }

}
