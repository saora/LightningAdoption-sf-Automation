package stepsdefinitions.objectmanager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.webdriver.WebDriverFacade;
import steps.base.login.LoginSteps;

import javax.mail.MessagingException;
import java.io.IOException;

public class ButtonLinkStepDefinitions {
    @Managed(driver="chrome")
    WebDriverFacade chromeDriver;

    @Steps
    private LoginSteps loginSteps;


    @Given("^New .+$")
    public void i_open_the_browser_and_type_the_Url() throws MessagingException {

    }

    @When("^I click on new Js button and select Detail Page Link$")
    public void fillJsButtonInformation(){

    }

    @When("^Testa1$")
    public void testa1()throws IOException {

    }

    @Then("^I create a new button link or Action")
    public void getBtnLinkandActions(){
        System.out.println("prueba completa");

}
}
