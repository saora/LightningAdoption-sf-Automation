package screens.base;

import net.serenitybdd.core.pages.PageObject;

public class GetApplicationUrl extends PageObject {

    public void openPageUrl(String urlApplication){
        switch (urlApplication){
            case "login":
                this.openAt("https://login.salesforce.com/?locale=us");
                break;
            case "signup":
                this.openAt("https://developer.salesforce.com/signup");
                break;
            case "gmail":
                this.openAt("https://mail.google.com/mail/?ui=html&zy=h");
                break;
                default:
                    System.out.println("URL not found!!");
        }
        getDriver().manage().window().maximize();
    }
}
