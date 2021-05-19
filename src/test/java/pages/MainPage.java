package pages;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import config.*;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    private SelenideElement username = $(byXpath("//div[@class='b-header-profile__shortName']/div"));

    private SelenideElement catalogLink = $(byXpath("//*[contains(text(), 'Каталог услуг')]"));

    public String getUsername() {
        return this.username.getText();
    }

    public void goToCatalog() {
        catalogLink.click();
    }
}
