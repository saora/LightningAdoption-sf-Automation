package screens.base;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

public class SalesforceLoginScreen extends PageObject {
    @FindBy(id="username")
    private static WebElementFacade FILL_USERNAME;

    @FindBy(id="password")
    private static WebElementFacade FILL_PASSWORD;

    @FindBy(id="Login")
    private static WebElementFacade SIGN_IN;

    @FindBy(id = "emc")
    private static WebElementFacade verCode;

    @FindBy(id = "save")
    private static WebElementFacade click_Verify;

  /*  public SalesforceLoginScreen(WebDriver driver) {
        super(driver);
    }*/

    private void fillUserName(String userName){
        FILL_USERNAME.clear();
        FILL_USERNAME.sendKeys(userName);
    }

    private void fillPassword(String password){
        FILL_PASSWORD.clear();
        FILL_PASSWORD.sendKeys(password);
    }


    private void clickSignIn() {
        SIGN_IN.click();
    }

    public void login(String userName, String password){
        fillUserName(userName);
        fillPassword(password);
        clickSignIn();
    }

    public void verify(String verifyCode){
        try {
            verCode.sendKeys(verifyCode);
            click_Verify.click();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
