package steps.base.login;

import net.thucydides.core.annotations.Step;
import pages.LoginPage;
import steps.com.EmailData;
import steps.com.LoginData;

import javax.mail.MessagingException;

public class LoginSteps {

     private LoginPage loginPage;
     private LoginData loginData;
     private EmailData emailData;


    @Step
    public void openLoginPage() {
        loginPage.open();
        loginPage.getDriver().manage().window().maximize();
    }

    @Step
    public void sendLoginData()throws Exception {
     loginData.loginSalesforce();
    }

    @Step
    public void verifyOrgAccount()throws Exception{
        emailData.verifyAccount();
    }

    @Step
    public void verifyLoginSuccess() throws MessagingException {
        loginPage.loginVerification();
    }

}

