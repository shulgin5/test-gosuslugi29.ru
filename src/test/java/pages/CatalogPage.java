package pages;

import java.util.ArrayList;
import java.util.List;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import com.codeborne.selenide.SelenideElement;

public class CatalogPage {
    private SelenideElement buttonLoadMore;

    public void loadMore() {
        int sum = 0;
        try {
            while (true) {
                buttonLoadMore = $(byXpath("//*[@class=\"btn btn-lg btn-primary btn--tiles-more btn--pagination\"]"));
                System.out.println(sum);
                buttonLoadMore.click();
            }
        }catch (Throwable e) { }
    }

    public List<String> getLinksCategories(){
        String link = "https://gosuslugi29.ru/pgu/categories/info.htm?id=";
        List<String> links = new ArrayList<>();
        List<SelenideElement> allCategories = getAllCategories();
        for (SelenideElement category : allCategories){
            links.add(link + category.getAttribute("data-objid"));
        }
        return links;
    }

    private List<SelenideElement> getAllCategories(){
        return $$(byXpath("//*[@class=\"t-modal-layout-item g-tile g-tile--3\"]"));
    }

    public Object[][] getLinksServices(){
        List<SelenideElement> allServices = getAllServices();
        int countServices = allServices.size();
        Object[][] links = new Object[countServices][2];
        for (int i = 0; i < countServices; i++) {
            links[i][0] = allServices.get(i).find(byClassName("g-tile-title")).getAttribute("title");
            links[i][1] = allServices.get(i).getAttribute("href");
        }
        return links;
    }

    private List<SelenideElement> getAllServices(){
        return $$(byXpath("//*[@data-behavior=\"tileAction\"]/a"));
    }
}
