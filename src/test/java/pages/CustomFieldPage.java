package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CustomFieldPage extends PageObject {

    @FindBy(name = "new_field")
    private WebElementFacade click_NewField;

    @FindBy(id = "dtypeV")
    private WebElementFacade selAutoNumber;

    @FindBy(id = "dtypeZ")
    private WebElementFacade selFormula;

    @FindBy(id = "dtype1")
    private WebElementFacade selRollUpSummary;

    @FindBy(id = "dtypeY")
    private WebElementFacade selLookupRelationship;

    @FindBy(id = "dtypex")
    private WebElementFacade selExtLookpRelationship;

    @FindBy(id = "dtypeB")
    private WebElementFacade selCheckBox;

    @FindBy(id = "dtypeC")
    private WebElementFacade selCurrency;

    @FindBy(id = "dtypeD")
    private WebElementFacade selDate;

    @FindBy(id = "dtypeF")
    private WebElementFacade selDateTime;

    @FindBy(id = "dtypeE")
    private WebElementFacade selEmail;

    @FindBy(id = "dtypeg")
    private WebElementFacade selGeolocation;

    @FindBy(id = "dtypeN")
    private WebElementFacade selNumber;

    @FindBy(id = "dtypeP")
    private WebElementFacade selPercent;

    @FindBy(id = "dtypeH")
    private WebElementFacade selPhone;

    @FindBy(id = "dtypeL")
    private WebElementFacade selPickList;

    @FindBy(id = "dtypeQ")
    private WebElementFacade selPickListMultiselect;

    @FindBy(id = "dtypeS")
    private WebElementFacade selText;

    @FindBy(id = "dtypeX")
    private WebElementFacade selTextArea;

    @FindBy(id = "dtypeJ")
    private WebElementFacade selTextAreaLong;

    @FindBy(id = "dtypez")
    private WebElementFacade selTextAreaRich;

    @FindBy(id = "dtype6")
    private WebElementFacade selTextEncripted;

    @FindBy(id = "dtypef")
    private WebElementFacade selTime;

    @FindBy(id = "dtypeU")
    private WebElementFacade selUrl;

    // BUTTONS ------------------------------------
    @FindBy(name = "goPrevious")
    private WebElementFacade click_Previous;

    @FindBy(name = "goNext")
    private WebElementFacade click_Next;

    @FindBy(name = "cancel")
    private WebElementFacade click_Cancel;

    @FindBy(name = "save_new")
    private WebElementFacade click_SaveNew;

    @FindBy(name = "save")
    private WebElementFacade click_Save;

    // TEXT FIELD --------------------------
    @FindBy(id = "DomainEnumOrId")
    private WebElementFacade selRelatedTo;

    @FindBy(id = "AutoNumberMask")
    private WebElementFacade fill_DisplayFormat;

    @FindBy(id = "startNum")
    private WebElementFacade fill_StartingNumber;

    @FindBy(id = "MasterLabel")
    private WebElementFacade fill_Label;

    @FindBy(id = "Length")
    private WebElementFacade fill_Length;

    @FindBy(id = "DeveloperName")
    private WebElementFacade fill_devName;

    @FindBy(id = "Description")
    private WebElementFacade fill_Description;

    @FindBy(id = "InlineHelpText")
    private WebElementFacade fill_HelpText;

    @FindBy(id = "options_0")
    private WebElementFacade check_Required;

    @FindBy(id = "IsUnique")
    private WebElementFacade check_Unique;

    @FindBy(id = "caseInsensButton")
    private WebElementFacade opt_InsensButton;

    @FindBy(id = "caseSensButton")
    private WebElementFacade opt_SensButton;

    @FindBy(id = "IsExternalIdentifier")
    private WebElementFacade check_ExternalID;

    @FindBy(id = "DefaultValue")
    private WebElementFacade fill_DefaultValue;

    @FindBy(id = "populate")
    private WebElementFacade check_AutoNumber;

   @FindBy(className = "last labelCol")
   private WebElementFacade selectRadiobtn;

   @FindBy(id = "Scale")
   private WebElementFacade fill_DecimalPlaces;

   @FindBy(id = "CalculatedFormula")
   private WebElementFacade fill_FormulaEditor;

    public void selDataType(String dataType){
        switch(dataType){
            case "Auto Number":
                selAutoNumber.click();
                break;
            case "Formula":
                selFormula.click();
                break;
            case "Roll-Up Summary":
                selRollUpSummary.click();
                break;
            case "Lookup Relationship":
                selLookupRelationship.click();
                break;
            case "External Lookup Relationship":
                selExtLookpRelationship.click();
                break;
            case "Checkbox":
                selCheckBox.click();
                break;
            case "Currency":
                selCurrency.click();
                break;
            case "Date":
                selDate.click();
                break;
            case "Date/Time":
                selDateTime.click();
                break;
            case "Email":
                selEmail.click();
                break;
            case "Geolocation":
                selGeolocation.click();
                break;
            case "Number":
                selNumber.click();
                break;
            case "Percent":
                selPercent.click();
                break;
            case "Phone":
                selPhone.click();
                break;
            case "Picklist":
                selPickList.click();
                break;
            case "Picklist (Multi-Select)":
                selPickListMultiselect.click();
                break;
            case "Text":
                selText.click();
                break;
            case "Text Area":
                selTextArea.click();
                break;
            case "Text Area (Long)":
                selTextAreaLong.click();
                break;
            case "Text Area (Rich)":
                selTextAreaRich.click();
                break;
            case "Text (Encrypted)":
                selTextEncripted.click();
                break;
            case "Time":
                selTime.click();
                break;
            case "URL":
                selUrl.click();
                break;
                default:
                    System.out.println("Not found element !!!");

        }

    }

    public void setSelRelatedTo(String selRelatedTo){
        this.selRelatedTo.selectByVisibleText(selRelatedTo);
    }

    public void setFill_DisplayFormat(String fillDisplayFormat){
        fill_DisplayFormat.clear();
        fill_DisplayFormat.sendKeys(fillDisplayFormat);
    }

    public void setFill_StartingNumber(String startingNumber){
        fill_StartingNumber.clear();
        fill_StartingNumber.sendKeys(startingNumber);
    }

    public void setCheck_AutoNumber(){
        check_AutoNumber.click();
    }

    public void setFill_DecimalPlaces(String decimalPlaces){
        fill_DecimalPlaces.selectByVisibleText(decimalPlaces);
    }

    public void setFill_FormulaEditor(String formulaEditor){
        fill_FormulaEditor.clear();
        fill_FormulaEditor.sendKeys(formulaEditor);
    }

    public void selFormulaType(String selVisibleText){
        selectRadiobtn.selectByVisibleText(selVisibleText);
    }

    public void clik_NewField(){
        click_NewField.click();
    }

    public void click_OnNext(){
        click_Next.click();
    }

    public void setClick_SaveNew(){
        click_SaveNew.click();
    }

    public void setClick_Save(){
        click_Save.click();
    }

    public void setFill_Label(String fieldLabel){
        fill_Label.clear();
        fill_Label.sendKeys(fieldLabel);
    }

    public void setFill_Length(String fieldLength){
        fill_Length.clear();
        fill_Length.sendKeys(fieldLength);
    }

    public void setFill_devName(String fieldDevName){
        fill_devName.clear();
        fill_devName.sendKeys(fieldDevName);
    }

    public void setFill_Description(String fieldDescription){
        fill_Description.clear();
        fill_Description.sendKeys(fieldDescription);
    }

    public void setFill_HelpText(String fieldHelptext){
        fill_HelpText.clear();
        fill_HelpText.sendKeys(fieldHelptext);
    }

    public void setCheck_Required(String chkRequired){
      if(chkRequired.equals("Checked")){
          check_Required.click();
      }else{
          check_Required.deselect();
      }
    }

    public void setCheck_Unique(String chkUnique){
        if(chkUnique.equals("Checked")){
            check_Unique.click();
        }else{
            check_Unique.deselect();
        }

    }

    public void setOpt_Unique(String optsel){
        if(optsel.equals("Selected")){
            opt_InsensButton.select();
        }else{
            opt_SensButton.select();
        }
    }

    public void setCheck_ExternalID(String chkExternalId){
        if(chkExternalId.equals("Checked")){check_ExternalID.click();}
    }

    public void setFill_DefaultValue(String defaultValue){
        fill_DefaultValue.clear();
        fill_DefaultValue.sendKeys(defaultValue);
    }





}
