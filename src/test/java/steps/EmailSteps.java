package steps;
import net.thucydides.core.annotations.Step;
import screens.base.GetApplicationUrl;
import screens.base.ChangePasswordScreen;
import screens.gmail.GmailScreen;

public class EmailSteps {
    private String actor;
    private GmailScreen gmailScreen;
    private GetApplicationUrl applicationHomePage;
    private ChangePasswordScreen changePasswordScreen;

    @Step("#actor opens the Gmail Url")
    public void openGemailUrl(){
        applicationHomePage.openPageUrl("gmail");
        // we can check credentials using api or db
    }

    @Step("#actor should be able to sign in with their account")
    public void signInWithTheirGmailAccount(String guserName, String gpassword, String gsubjectEmail){
        gmailScreen.verfyAcctByemail(guserName, gpassword);
        gmailScreen.findEmailToVerifyAccount(gsubjectEmail);
        gmailScreen.openEmailToVerifyAccount();
    }

    @Step("#actor should be able to chenge their password of ORG account")
    public void changeTheirPasswordSalesforceOrg(String newPass, String confirmPass, String answerChgPass){
        changePasswordScreen.ChangePasswordScreen(newPass,confirmPass,answerChgPass);
    }

    @Step("#actor should be able to view their Salesforce Org")
    public void checkProfile(){

    }
}
