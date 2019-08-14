package steps.base.objectmanager;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import pages.BtnLinksActionsPage;
import pages.HomePage;
import steps.com.FillDataFromSpreadSheet;

public class JsButton extends PageObject {

    private HomePage homePage;
    private FillDataFromSpreadSheet fillData;
    private BtnLinksActionsPage btnLinksActionsPage;

    @Step
    public void jsButtonActions(String obj){
        homePage.buildOption();
        homePage.selSalesforceObject(obj);
    }

    @Step
    public void newJsButton()throws Exception {
        fillData.getDataJsButton();
    }

    @Step
    public void newAction()throws Exception{
        fillData.getDataNewAction();
    }

    @Step
    public void jsButtonverify(){
       btnLinksActionsPage.objBtnLinkVerification();
    }

}
