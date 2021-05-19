package pages;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

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
}
