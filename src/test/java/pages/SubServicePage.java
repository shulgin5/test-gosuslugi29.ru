package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SubServicePage {
    private SelenideElement buttonGet = $(byXpath("//*[contains(text(),'Получить услугу')]"));

    private SelenideElement buttonAppointment = $(byXpath("//*[contains(text(),'Записаться')]"));

    private SelenideElement buttonAllInfo = $(byXpath("//a[@class='service-details-link']"));

    private SelenideElement regulationsLink = $(byXpath("//a[@class='reglament-link']"));

    private SelenideElement deadlineComplete = $(byXpath("//p[@class='attr-title' and contains(text(),'Срок выполнения услуги:')]/following::div[1]"));

    public boolean existsButtonGet() {
        return buttonGet.exists();
    }

    public boolean existsButtonAppointment() {
        return buttonAppointment.exists();
    }

    public String getDeadLineComplete() {
        return deadlineComplete.getAttribute("innerText");
    }

    public String getRegulationsLink() {
        return regulationsLink.getAttribute("href");
    }

    public void clickButtonAllInfo() {
        buttonAllInfo.click();
    }


}
