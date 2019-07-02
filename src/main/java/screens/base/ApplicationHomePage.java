package screens.base;

import net.serenitybdd.core.pages.PageObject;

public class ApplicationHomePage extends PageObject {
    public void openPageUrl(int url){
        switch (url){
            case 0:
                this.openAt("https://login.salesforce.com");
                break;
            case 1:
                this.openAt("https://developer.salesforce.com/signup");
                break;
            case 2:
                this.openAt("https://mail.google.com/mail/?ui=html&zy=h");
                break;
        }
    }
}
