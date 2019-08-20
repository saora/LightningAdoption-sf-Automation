package steps.base.objectmanager;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import pages.BtnLinksActionsPage;
import pages.HomePage;
import steps.com.ActionData;
import steps.com.JsButtonData;

public class JsButton extends PageObject {

    private HomePage homePage;
    private JsButtonData jsButtonData;
    private ActionData actionData;
    private BtnLinksActionsPage btnLinksActionsPage;

    @Step
    public void jsButtonActions(String obj){
        homePage.buildOption();
        homePage.selSalesforceObject(obj);
    }

    @Step
    public void newJsButton()throws Exception {
        jsButtonData.getDataJsButton();
    }

    @Step
    public void newAction()throws Exception{
        actionData.getDataNewAction();
    }

    @Step
    public void jsButtonverify(){
       btnLinksActionsPage.objBtnLinkVerification();
    }

}
