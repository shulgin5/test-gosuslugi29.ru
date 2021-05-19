package pages;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CatalogPage {
    private SelenideElement buttonLoadMore;

    public void loadMore() {
        try {
            while (true) {
                buttonLoadMore = $(byXpath("//button[@class=\"btn btn-lg btn-primary btn--tiles-more btn--pagination\"]"));
                buttonLoadMore.click();
            }
        }catch (ElementNotFound e) { }
    }

    private List<SelenideElement> getAllCategories(){
        return $$(byXpath("//*[@class=\"t-modal-layout-item g-tile g-tile--3\"]"));
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
}
