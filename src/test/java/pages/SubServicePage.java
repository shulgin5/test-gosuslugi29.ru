package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SubServicePage {
    private static final SelenideElement buttonGet = $(byXpath("//*[contains(text(),'Получить услугу')]"));
    private static final SelenideElement buttonAppointment = $(byXpath("//*[contains(text(),'Записаться')]"));
    private static final SelenideElement buttonAllInfo = $(byXpath("//a[@class='service-details-link']"));
    private static final SelenideElement regulationsLink = $(byXpath("//a[@class='reglament-link']"));
    private static final SelenideElement deadlineComplete = $(byXpath("//p[@class='attr-title' and contains(text(),'Срок выполнения услуги:')]/following::div[1]"));
    private static final SelenideElement cost = $(byXpath("//*[@id='dataGrpcost']/ancestor::h3/following-sibling::div"));
    private static final SelenideElement template = $(byXpath("//span[text()='Шаблон']/ancestor::a"));
    private static final SelenideElement example = $(byXpath("//span[text()='Пример']/ancestor::a"));
    private static final SelenideElement organization = $(byXpath("//a[@class='service-organ-link']"));

    public boolean existsButtonGet() {
        return buttonGet.exists();
    }

    public boolean existsButtonAppointment() {
        return buttonAppointment.exists();
    }

    public boolean existsCost() {
        return cost.exists();
    }

    public String getDeadLineComplete() {
        try{
            return Optional.ofNullable(deadlineComplete.getAttribute("innerText")).orElse("");
        }catch (ElementNotFound e) { return ""; }
    }

    public String getRegulationsLink() {
        try{
            return Optional.ofNullable(regulationsLink.getAttribute("href")).orElse("");
        }catch (ElementNotFound e) { return ""; }
    }

    public String getTemplateLink() {
        try{
            return Optional.ofNullable(template.getAttribute("href")).orElse("");
        }catch (ElementNotFound e) { return ""; }
    }

    public String getExampleLink() {
        try{
            return Optional.ofNullable(example.getAttribute("href")).orElse("");
        }catch (ElementNotFound e) { return ""; }
    }

    public void clickButtonAllInfo() {
        buttonAllInfo.click();
    }

    public String getOrganization() {
        try{
            return Optional.ofNullable(organization.getAttribute("innerText")).orElse("");
        }catch (ElementNotFound e) { return ""; }
    }

    public List<String> getCategoriesRecipient() {
        List<SelenideElement> categoriesElements = $$(byXpath("//*[@id='dataGrpcategory']/ancestor::h3/following-sibling::div[1]/div/div[@class='attr-title']"));
        List<String> categoriesStrings;
        categoriesStrings = categoriesElements.stream()
                .map((element) -> element.getAttribute("innerText"))
                .collect(Collectors.toList());
        return categoriesStrings;
    }
}
