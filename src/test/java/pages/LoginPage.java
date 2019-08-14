package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://login.salesforce.com/?locale=us")
public class LoginPage extends PageObject {

    @FindBy(id = "username")
    private WebElementFacade user;

     @FindBy(id = "password")
    private WebElementFacade pass;

     @FindBy(id = "Login")
     private WebElementFacade submitBtn;

    @FindBy(id = "emc")
    private static WebElementFacade fillVerificationCode;

    @FindBy(id = "save")
    private static WebElementFacade click_Verify;

     public void setLoginData(String user, String pass){
      this.user.sendKeys(user);
      this.pass.sendKeys(pass);
     }

     public void setOrgUser(String orgUser){
        this.user.sendKeys(orgUser);
     }

     public void setOrgPass(String orgPass){
        this.pass.sendKeys(orgPass);
     }

     public void submitBtn(){
         this.submitBtn.click();
     }

    public void setVerificationCode(String verifyCode){
        try {
            fillVerificationCode.sendKeys(verifyCode);
            click_Verify.click();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
    public void loginVerification(){
       // Assert.assertEquals("Home",find(By.linkText("Home")).getText());
    }


}
