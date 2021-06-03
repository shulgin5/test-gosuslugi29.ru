package tests;

import org.testng.annotations.*;
import pages.BasePage;
import steps.Steps;
import java.util.List;
import static com.codeborne.selenide.Selenide.open;
import io.qameta.allure.Description;
import utils.Utils;

public class MainTest extends BasePage{

    private Object[][] allServicesObject = {};

    @DataProvider(name = "services")
    public Object[][] allServices() {
        return allServicesObject;
    }

    @BeforeClass
    public void findAllServices() {
        Steps.checkAuthorization(mainPage.getUsername());
        mainPage.goToCatalog();
        catalogPage.loadMore();
        List<String> categories = catalogPage.getLinksCategories();
        Steps.checkCategoriesCount(categories.size());
        /*open(categories.get(0));
        catalogPage.loadMore();
        allServicesObject = Utils.concatenateOfArrays(allServicesObject, catalogPage.getLinksServices());*/
        for(String category : categories) {
            open(category);
            catalogPage.loadMore();
            allServicesObject = Utils.concatenateOfArrays(allServicesObject, catalogPage.getLinksServices());
        }
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
