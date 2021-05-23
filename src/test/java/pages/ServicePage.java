package pages;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import com.codeborne.selenide.SelenideElement;

public class ServicePage {
    private SelenideElement serviceName = $(byXpath("//span[@class=\"modal-title-inner-text\"]/span"));

    private SelenideElement organizationName = $(byXpath("//a[@class=\"service-organ-link\"]"));

    private SelenideElement reglamentLink = $(byXpath("//a[@class=\"reglament-link\"]"));

    private List<SelenideElement> electronicServices = $$(byXpath("//h3[@class='b-basic-list-title ' and contains(text(), 'Электронные услуги')]/following-sibling::div/div/a"));

    private List<SelenideElement> noElectronicServices = $$(byXpath("//h3[@class='b-basic-list-title ' and contains(text(), 'Не электронные услуги')]/following-sibling::div/div/a"));

    public String getServiceName(){
        return this.serviceName.getAttribute("innerText");
    }

    public String getOrganizationName(){
        return this.organizationName.getAttribute("innerText");
    }

    public String getReglamentLink(){
        return this.reglamentLink.getAttribute("href");
    }

    public int countElectronicSubServices(){
        return electronicServices.size();
    }

    public int countNoElectronicSubServices(){
        return noElectronicServices.size();
    }

    public List<String> getElectronicServices(){
        List<String> links = new ArrayList<>();
        for (SelenideElement subService : this.electronicServices){
            String dataTargetId = subService.getAttribute("data-targetid");
            String dataServiceId = subService.getAttribute("data-serviceid");
            String subServiceLink = "https://gosuslugi29.ru/pgu/services/info/targets.htm?id=" +
                    dataTargetId + "&serviceId=" + dataServiceId;
            links.add(subServiceLink);
        }
        return links;
    }

    public List<String> getNoElectronicServices(){
        List<String> links = new ArrayList<>();
        for (SelenideElement subService : this.noElectronicServices){
            String dataTargetId = subService.getAttribute("data-targetid");
            String dataServiceId = subService.getAttribute("data-serviceid");
            String subServiceLink = "https://gosuslugi29.ru/pgu/services/info/targets.htm?id=" +
                    dataTargetId + "&serviceId=" + dataServiceId;
            links.add(subServiceLink);
        }
        return links;
    }
}
