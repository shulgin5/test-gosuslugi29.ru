package tests;

import pages.BasePage;
import steps.Steps;
import java.util.List;
import static com.codeborne.selenide.Selenide.open;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MainTest extends BasePage{

    private Object[][] allServicesObject;

    @DataProvider(name = "services")
    public Object[][] allServices() {
        return allServicesObject;
    }

    @Test
    @Description(value = "Поиск всех услуг на портале")
    public void findAllServices() {
        Steps.checkAuthorization(mainPage.getUsername());
        mainPage.goToCatalog();
        catalogPage.loadMore();
        List<String> categories = catalogPage.getLinksCategories();
        Steps.checkCategoriesCount(categories.size());
        open(categories.get(1));
        catalogPage.loadMore();
        allServicesObject = catalogPage.getLinksServices();
    }

    @Test(dataProvider = "services")
    @Description(value = "Проверка услуги")
    public void serviceTest(String name, String href) {
        open(href);
        int countEl = servicePage.countElectronicSubServices();
        int countNoEl = servicePage.countNoElectronicSubServices();
        Steps.checkSubServices(servicePage, countEl, countNoEl);
    }

}
