package stepsdefinitions.login;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.base.login.LoginSteps;

public class LoginStepsDefinitions {

    @Steps
    private LoginSteps loginSteps;

    @Given("^I navigate to the sf Login page$")
    public void getLoginPage(){
       loginSteps.openLoginPage();
    }

    @When("^I submit the login data$")
    public void fillData()throws Exception {
       loginSteps.sendLoginData();

    }

    @Then("^I should Logged In Salesforce$")
    public void verifyAcct()throws Exception {
        loginSteps.verifyOrgAccount();
       loginSteps.verifyLoginSuccess();
    }

}
