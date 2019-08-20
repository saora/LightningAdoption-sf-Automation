package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class BtnLinksActionsPage extends PageObject {

    //New Actions --------------------------------------
    @FindBy(xpath = "//*[@id=\"ActionButtonLinkList$ActionsList\"]/div[1]/div/div[1]/table/tbody/tr/td[2]/input[1]")
    private WebElementFacade clickNewAction;

    @FindBy(id = "Type")
    private WebElementFacade selActionType;

    @FindBy(id = "TargetSobjectType")
    private WebElementFacade selTargetObject;

    @FindBy(id = "StandardLabel")
    private WebElementFacade selStdLabel;

    @FindBy(id = "DeveloperName")
    private WebElementFacade filldevName;

    @FindBy(id = "CreateFeedItem")
    private WebElementFacade feedItem;

    @FindBy(id = "SuccessMessage")
    private WebElementFacade fillMessage;

    @FindBy(name = "Save")
    private WebElementFacade saveAction;

    @FindBy(name = "Cancel")
    private WebElementFacade clickOnCancel;

    //New Button or Link ------------------------------CampaignLinks_font
    @FindBy(xpath = "//*[@id=\"ActionButtonLinkList$ActionsList\"]/div[1]/div/div[1]/table/tbody/tr/td[2]/input[2]")
    //*[@id="CampaignLinks_font"]
    private WebElementFacade clickNewButtonorLink;

    @FindBy(linkText = "Default Custom Links")
    private WebElementFacade clickDefaultCustLinks;

    @FindBy(id = "MasterLabel")
    private  WebElementFacade fillLabel;

    @FindBy(id = "WebLinkFields_Name")
    private WebElementFacade fillName;

    @FindBy(id = "Description")
    private WebElementFacade fillDescription;

    @FindBy(id = "WebLinkFields_DisplayTypeL")
    private WebElementFacade clickPageLink;

    @FindBy(id = "WebLinkFields_DisplayTypeB")
    private WebElementFacade clickPageButton;

    @FindBy(id = "WebLinkFields_DisplayTypeM")
    private WebElementFacade clickListButton;

    @FindBy(id = "OpenType")
    private WebElementFacade selBehavior;

    @FindBy(id = "LinkType")
    private WebElementFacade selContentSource;

    @FindBy(id = "WebLinkFields_ContentEditor")
    private WebElementFacade fillContentEditor;

    @FindBy(xpath = "//*[@id=\"bottomButtonRow\"]/input[1]")
    private WebElementFacade save;

    public void setFillLabel(String fillLabel){
        this.fillLabel.clear();
        this.fillLabel.sendKeys(fillLabel);
    }

    public void setFillName(String fillName){
        this.fillName.clear();
        this.fillName.sendKeys(fillName);
    }

    public void setFillDescription(String fillDescription){
        this.fillDescription.clear();
        this.fillDescription.sendKeys(fillDescription);
    }

    public void setDetailPageLink(){
        this.clickPageLink.click();
    }

    public void setDetailPageButton(){
        this.clickPageButton.click();
    }

    public void setListButton(){
        this.clickListButton.click();
    }

    public void setSelBehavior(String selBehavior){
        this.selBehavior.selectByVisibleText(selBehavior);
    }

    public void setSelContentSource(String selContentSource){
        this.selContentSource.selectByVisibleText(selContentSource);
    }

    public void setFillContentEditor(String fillContentEditor){
        this.fillContentEditor.clear();
        this.fillContentEditor.sendKeys(fillContentEditor);
    }

    public void saveJsButton(){
        save.click();
        getDriver().switchTo().alert().accept();
    }
    //---------------------------------------------------------------
    public void setSelActionType(String selActionType){
        this.selActionType.selectByVisibleText(selActionType);
    }
    public void setSelTargetObject(String selTargetObject){
        try {
            this.selTargetObject.selectByVisibleText(selTargetObject);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void setSelStdLabel(String selStdLabel){
        this.selStdLabel.selectByVisibleText(selStdLabel);
    }

    public void setfillDevName(String filldevName){
        this.filldevName.clear();
        this.filldevName.sendKeys(filldevName);
    }

    public void setCreateFeedItem(){
        try {
            feedItem.click();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setFillMessage(String fillMessage){
        try {
            this.fillMessage.clear();
            this.fillMessage.sendKeys(fillMessage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void saveAction(){
        saveAction.click();

    }



    public void newAction(String actionType, String tragetObj, String stdlblType, String label, String name, String description, String message){
        clickNewAction.click();
        selActionType.selectByVisibleText(actionType);
        selTargetObject.selectByVisibleText(tragetObj);
        selStdLabel.selectByVisibleText(stdlblType);
        fillLabel.sendKeys(label);
        filldevName.sendKeys(name);
        fillDescription.sendKeys(description);
        fillMessage.sendKeys(message);
        saveAction.click();
    }

    public void clickOption(String btnOption){
        switch(btnOption){
            case "New Action":
                clickNewAction.click();
                break;
            case "New Button or Link":
                clickNewButtonorLink.click();
                break;
            case "Default Custom Links":
                clickDefaultCustLinks.click();
                break;
                default:
                    System.out.println("Not found!!");
        }

    }

    public void newBtnOrLink(String lbl, String name, String description, String displayType, String behavior, String contentSorce, String contentEditor){
        fillLabel.sendKeys(lbl);
        fillName.clear();
        fillName.sendKeys(name);
        fillDescription.sendKeys(description);
        switch (displayType){
            case "Detail Page Link":
                setDetailPageLink();
                break;
            case "Detail Page Button":
                setDetailPageButton();
                break;
            case "List Button":
                setListButton();
                break;
            default:
                System.out.println("no match");
        }
        selBehavior.selectByVisibleText(behavior);
        selContentSource.selectByVisibleText(contentSorce);
        fillContentEditor.sendKeys(contentEditor);
        saveJsButton();
    }

    public void defaultCustomLinks() {
        clickDefaultCustLinks.click();

    }

    public void objBtnLinkVerification(){
        //System.out.println("esto es:  ----> "+find(By.className("mainTitle")).getText());
      // Assert.assertEquals("Custom Button or Link Detail", find(By.className("mainTitle")).getText());
    }


}
