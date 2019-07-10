package steps;

import net.thucydides.core.annotations.Step;
import screens.base.ApplicationHomePage;
import screens.base.SalesforceLoginScreen;
import screens.base.TestValidationPage;
import screens.gmail.InboxReader;

import javax.mail.MessagingException;

public class SalesforceLoginSteps {
    private String actor;
    private ApplicationHomePage applicationHomePage;
    private SalesforceLoginScreen loginScreen;
    private TestValidationPage testValidationPage;

    @Step("#actor is a registered member")
    public void IsARegisteredMember(){
        applicationHomePage.openPageUrl(0);
        // we can check credentials using api or db
    }

    @Step("#actor should be able to sign in with their account")
    public void signInWithTheirAccount(String userName, String password){
        loginScreen.login(userName, password);
    }

    @Step("#actor should be able to verify their Salesforce identity")
    public void verifySalesforceAccount(String eUser, String ePassword) throws MessagingException {
        String a = InboxReader.getEmail(eUser, ePassword);
        loginScreen.verify(a);
    }
    @Step("#actor should be able to view their Salesforce Org")
    public void checkProfile(){
        testValidationPage.checkTitle();
    }
}
