package stepsdefinitions.signup;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.base.signup.OrgSignUpSteps;

public class SignupStepDefinitions {

    @Steps
    private OrgSignUpSteps signupSteps;

    @Given("^I open the the signup salesforce page$")
    public void openSignupUrl(){
    }

    @When("^I fill in the information$")
    public void fillOrgData()throws Exception{
        signupSteps.setDataOrg();
    }


    @Then("^I get the signup confirmation$")
    public void getConfirmation(){

    }
}
