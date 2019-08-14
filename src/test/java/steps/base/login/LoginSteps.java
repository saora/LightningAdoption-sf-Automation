package steps.base.login;

import net.thucydides.core.annotations.Step;
import pages.BtnLinksActionsPage;
import pages.CustomFieldPage;
import pages.HomePage;
import pages.LoginPage;
import steps.com.FillDataFromSpreadSheet;

import javax.mail.MessagingException;

public class LoginSteps {

     private LoginPage loginPage;
     private FillDataFromSpreadSheet fillDataFromSpreadSheet;
     private HomePage homePage;
     private CustomFieldPage customFieldPage;
     private BtnLinksActionsPage btnLinksAction;

    @Step
    public void openLoginPage() {
        loginPage.open();
        loginPage.getDriver().manage().window().maximize();
    }

    @Step
    public void sendLoginData()throws Exception {
     fillDataFromSpreadSheet.loginSalesforce();
    }

    @Step
    public void verifyOrgAccount()throws Exception{
        fillDataFromSpreadSheet.verifyAccount();
    }

    @Step
    public void verifyLoginSuccess() throws MessagingException {
        loginPage.loginVerification();
    }

}

