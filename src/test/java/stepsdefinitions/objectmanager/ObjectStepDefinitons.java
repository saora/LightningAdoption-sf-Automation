package stepsdefinitions.objectmanager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.HomePage;
import screens.base.GetApplicationUrl;
import steps.base.login.LoginSteps;
import steps.base.objectmanager.CustomField;
import steps.base.objectmanager.JsButton;

public class ObjectStepDefinitons {
    @Steps
    private LoginSteps loginSteps;
    private GetApplicationUrl getApplicationUrl;
    private HomePage homePage;
    private JsButton jsButton;
    private CustomField custField;

    @Given("^I navigate to the Login page$")
    public void getLoginPage(){
        loginSteps.openLoginPage();
    }

    @When("^I submit the username and password$")
    public void fillData()throws Exception {
        loginSteps.sendLoginData();
    }

    @Then("^I should Logged In$")
    public void verifyAcct()throws Exception {
        loginSteps.verifyOrgAccount();
    }

    @Given("^I click on new field$")
    public void selectNewField(){
        custField.newCustomField("Campaigns");
    }
    @When("^I submit the field information$")
    public void submitFieldInfo()throws Exception{
        custField.fillFieldData();
    }
    @Then("^I should create a new field$")
    public void newFieldVerification(){
        System.out.println("I should create a new field");
    }


    @Given("^I click on new Js Button$")
    public void selectNewJsButton()throws Exception{
        jsButton.jsButtonActions("Campaigns");
    }
    @When("^I submit Js Button Informtion$")
    public void submitJsButtonInfo()throws Exception{
        jsButton.newJsButton();
    }
    @Then("^I should create a new Js Button$")
    public void newJsButtonVerification(){
        jsButton.jsButtonverify();
    }

    /*@Given ("^I click on new Action$")
    public void selectNewAction(){
        System.out.println("I click on new Action");
    }
    @When ("^I submit Action information$")
    public void submitActionInfo(){
        System.out.println("I submit Action information");
    }
    @Then ("^I should create a new Action$")
    public void newActionVerification(){
        System.out.println("I should create a new Action");
    }

    @Given ("^I click on new Layout$")
    public void selectNewLayout(){
        System.out.println("I click on new Layout");
    }
    @When ("^I submit Layout information$")
    public void submitLaoutInfo(){
        System.out.println("I submit Layout information");
    }
    @Then ("^I should create a new layout$")
    public void newLayoutVerification(){
        System.out.println("I should create a new layout");
    }

    @Given ("^I click on new Visualforce page$")
    public void selectNewVisualforcePage(){
        System.out.println("I click on new Visualforce page");
    }
    @When ("^I submit the Visualforce information$")
    public void submitVisualforcenInfo(){
        System.out.println("I submit the Visualforce information");
    }
    @Then ("^I should create a Visualforce page$")
    public void newVisualforceVerification(){
        System.out.println("I should create a Visualforce page");
    }

    @Given ("^I click on My Domain$")
    public void selectMyDomain(){
        System.out.println("I click on My Domain");
    }
    @When ("^I configure My Domain$")
    public void configMayDomain(){
        System.out.println("I configure My Domain");
    }
    @Then ("^I deploy my domain for users$")
    public void deployMyDomain(){
        System.out.println("I deploy my domain for users");
    }

    @Given ("I click on the Layout")
    public void selectLayout(){
        System.out.println("I click on the Layout");
    }
    @When ("I add the buttons and fields")
    public void addButtonsAndActions(){
        System.out.println("I add the buttons and fields");
    }
    @Then ("I save the layout")
    public void saveLayout(){
        System.out.println("I save the layout");
    }
*/

}
