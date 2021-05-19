package steps;

import io.qameta.allure.Step;
import org.testng.Assert;

public class Steps {

    @Step(value = "Проверка корректного входа")
    public static void checkAuthorization(String username) {
        Assert.assertEquals(username, "Ростов А.И.");
    }
}
