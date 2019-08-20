package tests.base;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.HomePage;
import pages.LoginPage;
import steps.EmailSteps;
import steps.base.login.LoginSteps;
import steps.com.LoginData;

import javax.mail.MessagingException;

/*import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.EmailSteps;

@RunWith(SerenityRunner.class)*/
@RunWith(SerenityRunner.class)
public class VerifyOrgAccount {
    @Managed(driver="chrome")
    WebDriverFacade chromeDriver;

    @Steps
    private LoginData loginData;
    private CreateNewOrg createNewOrg;
    private LoginPage loginPage;
    private EmailSteps gmail_User;
    private LoginSteps loginSteps;
    private HomePage homePage;

    @Test
    public void tst()throws MessagingException {
        try {
            loginData.loginSalesforce();
        }catch (Exception e){
            e.printStackTrace();
        }

/*        loginPage.loginPage("ccbdd01@de.org","test1234");
        LoginSteps lsteps = new LoginSteps();
        lsteps.verifySalesforceAccount("glbltest.salesforce@gmail.com","61084n7mex01");
       homePage.switchToClassic();
        try {
            fillDataFromSpreadSheet.getDataJsButton();
        } catch (IOException e) {
            e.printStackTrace();
        }
       */
    }


}
