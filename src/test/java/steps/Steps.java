package steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.ServicePage;
import pages.SubServicePage;

import java.util.List;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.open;

public class Steps {

    @Step(value = "Вход на портал")
    public static void checkAuthorization(String username) {
        Assert.assertEquals(username, "Ростов А.И.");
    }

    @Step(value = "Количество категорий услуг - {count}")
    public static void checkCategoriesCount(int count) {
        Assert.assertTrue(count > 0);
    }

    @Step(value = "{name}")
    public static void checkServiceName(String name) {
        Assert.assertTrue(name.length() > 0, name);
    }

    @Step(value = "Неэлектронных подуслуг - {count}")
    public static void haveNoElecronicServices(int count) {
        Assert.assertTrue(count == 0, "Неэлектронные услуги отсутствуют");
    }

    @Step(value = "Электронных подуслуг - {count}")
    public static void haveElecronicServices(int count) {
        Assert.assertFalse(count == 0, "Электронные услуги отсутствуют");
    }

    @Step(value = "Проверка подуслуг")
    public static void checkSubServices(ServicePage servicePage) {
        SoftAssert softAssert = new SoftAssert();
        SubServicePage subServicePage = new SubServicePage();
        List<String> electronicServices = servicePage.getElectronicServices();
        List<String> noElectronicServices = servicePage.getNoElectronicServices();
        for (String link : electronicServices) {
            open(link);
            subServicePage.clickButtonAllInfo();
            softAssert.assertTrue(subServicePage.existsButtonGet(), "Нет кнопки 'Получить услугу'");
            softAssert.assertTrue(subServicePage.existsButtonAppointment(), "Нет кнопки 'Записаться'");
            softAssert.assertTrue(subServicePage.getRegulationsLink().length() > 0, "Не удалось найти ссылку на регламент'");
            softAssert.assertTrue(Pattern.matches(".*\\d+.*", subServicePage.getDeadLineComplete()), "Не найден срок оказания услуги");
        }
        softAssert.assertAll();
    }
}
