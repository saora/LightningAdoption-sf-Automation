package tests.base;

//@RunWith(SerenityRunner.class)


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import screens.base.GetApplicationUrl;
import steps.base.login.LoginSteps;

import java.io.IOException;

@RunWith(SerenityRunner.class)
public class LoginSalesforce {
    //@Managed
    //WebDriverFacade driver; // defaults to firefox geckodriver*/

    @Managed(driver = "chrome")
    WebDriverFacade chromeDriver;


    @Steps
    private GetApplicationUrl getApplicationUrl;
    private LoginSteps loginSteps;


    @Test
    public void checkUserSuccessfullyLogin() throws IOException {
        //loginSteps.openLoginPage("login");
       getApplicationUrl.openPageUrl("login");
       // loginPage.setloginPage("login");
        //fillDataFromSpreadSheet.loginSalesforce();
        //SalesforceUser.verifyLoginSuccess();
    }
}
