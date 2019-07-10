package tests.base;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.runner.RunWith;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import steps.SalesforceLoginSteps;

import javax.mail.MessagingException;

@RunWith(SerenityRunner.class)
public class LoginSalesforce {
    //@Managed
    //WebDriverFacade driver; // defaults to firefox geckodriver*/
    @Managed(driver="chrome")
    WebDriverFacade chromeDriver;

    @Steps
    private SalesforceLoginSteps SalesforceUser;

    @Test
    public void checkUserSuccessfullyLogin()throws MessagingException {
        // Given
        SalesforceUser.IsARegisteredMember();
        // When
        SalesforceUser.signInWithTheirAccount("ccbdd01@de.org","test1234");
        // Then
            SalesforceUser.verifySalesforceAccount("glbltest.salesforce@gmail.com", "61084n7mex01");
        // Then
        SalesforceUser.checkProfile();
    }
}
