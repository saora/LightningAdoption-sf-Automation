package tests.base;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.base.login.LoginSteps;

@RunWith(SerenityRunner.class)
public class NuevaOrg {
    @Managed(driver = "chrome")
    WebDriverFacade chromeDriver;

    @Steps
    private LoginSteps loginSteps;

    @Test
    public void test()throws Exception {
        loginSteps.openLoginPage();
    }
}
