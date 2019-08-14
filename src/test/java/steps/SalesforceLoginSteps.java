package steps;

import net.thucydides.core.annotations.Step;
import screens.base.GetApplicationUrl;
import screens.base.SalesforceLoginScreen;
import screens.base.TestValidationPage;
import screens.gmail.InboxReader;

import javax.mail.MessagingException;

public class SalesforceLoginSteps {
    private String actor;
    private GetApplicationUrl applicationHomePage;
    private SalesforceLoginScreen loginScreen;
    private TestValidationPage testValidationPage;

   // @Given("^User open the browser with the Salesforce login url$")
    @Step
    public void IsARegisteredMember(){
        applicationHomePage.openPageUrl("login");
        // we can check credentials using api or db
    }

    //@When("^The user logs in the salesforce org$")
    @Step
    public void signInWithTheirAccount(String userName, String password){
        loginScreen.login(userName, password);
    }

    //@Then("^The user should see the landing page$")
    @Step
    public void verifySalesforceAccount(String eUser, String ePassword) throws MessagingException {
        String a = InboxReader.getEmail(eUser, ePassword);
        try {
            loginScreen.verify(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //@Then("^The user should be able to view their Salesforce Org$")
    @Step
    public void verifyLoginSuccess(){

    }
}
