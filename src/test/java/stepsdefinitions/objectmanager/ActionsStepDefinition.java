package stepsdefinitions.objectmanager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.webdriver.WebDriverFacade;
import pages.BtnLinksActionsPage;
import pages.HomePage;
import screens.base.GetApplicationUrl;
import steps.base.login.LoginSteps;

import javax.mail.MessagingException;

public class ActionsStepDefinition {

    @Managed(driver="chrome")
    WebDriverFacade chromeDriver;

    @Steps
    private LoginSteps loginSteps;
    private GetApplicationUrl applicationHomePage;
    private BtnLinksActionsPage actionsPage;
    private HomePage homePage;

    @Given("I am in salesforce page")
    public void step1()throws MessagingException {
        applicationHomePage.openPageUrl("login");
       // loginSteps.loginSalesforcePage("ccbdd01@de.org", "test1234");
        //loginSteps.i_click_on_submit_button();
       // loginSteps.verifySalesforceAccount("glbltest.salesforce@gmail.com","61084n7mex01");
    }
    @When("I click on new action button and fill out the informaction")
    public void step2(){
        homePage.selSalesforceObject("Campaigns");
        homePage.selObjectOption("Buttons, Links, and Actions");
        actionsPage.clickOption("New Action");
    }
    @Then("I save the action")
    public void step3(){
        actionsPage.newAction("Send Email","Campaign","Email","","test1","new action test 1","success!!");
    }
}
