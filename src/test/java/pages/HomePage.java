package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.aspectj.bridge.Message;

public class HomePage extends PageObject {

    @FindBy(className = "uiImage")
    private WebElementFacade userProfile;

    @FindBy(linkText = "Switch to Salesforce Classic")
    private WebElementFacade classicMode;

    @FindBy(id = "setupLink")
    private WebElementFacade setupLink;

    @FindBy(id = "Customize_icon")
    private WebElementFacade customizeIcon;
//Tab Names and Labels---------------------------------
    @FindBy(id = "Tab_icon")
    private WebElementFacade tabIcon;
//Options
    @FindBy(id = "RenameTab_font")
    private WebElementFacade renametab;

    @FindBy(id = "RenameHelp_font")
    private WebElementFacade renamehelp;
//Home-------------------------------------------------
    @FindBy(id = "Home_icon")
    private WebElementFacade homeIcon;
//Options
    @FindBy(id = "HomePageComponents_font")
    private WebElementFacade homepagecomponents;

    @FindBy(id = "HomePageLayouts_font")
    private WebElementFacade homepagelayouts;

    @FindBy(id = "HomeLinks_font")
    private WebElementFacade homelinks;
//Activities--------------------------------------------
    @FindBy(id = "Activity_icon")
    private WebElementFacade activityIcon;
    //Options
    @FindBy(id = "TaskFields_font")
    private WebElementFacade taskfields;
//Agregar todas las opciones que faltan

    @FindBy(id = "Campaign_icon")
    private WebElementFacade campaingIcon;

    @FindBy(id = "Lead_icon")
    private WebElementFacade leadIcon;

    @FindBy(id = "Account_icon")
    private WebElementFacade accountIcon;

    @FindBy(id = "DandBCompany_icon")
    private WebElementFacade dbCompaniesIcon;

    @FindBy(id = "Contact_icon")
    private WebElementFacade contactIcon;

    @FindBy(id = "Notes_icon")
    private WebElementFacade notesIcon;

    @FindBy(id = "Opportunity_icon")
    private WebElementFacade opportunityIcon;

    @FindBy(id = "PathAssistant_icon")
    private WebElementFacade pathIcon;

    @FindBy(id = "Quote_icon")
    private WebElementFacade quoteIcon;

    @FindBy(id = "Forecasting3_icon")
    private WebElementFacade forecastIcon;

    @FindBy(id = "SocialAppsIntegration_icon")
    private WebElementFacade socialmediaIcon;

    @FindBy(id = "Case_icon")
    private WebElementFacade caseIcon;

    @FindBy(id = "EntitlementManagement_icon")
    private WebElementFacade entitlementIcon;

    @FindBy(id = "SelfService_icon")
    private WebElementFacade selfserviceIcon;

    @FindBy(id = "CallCenterEdition_icon")
    private WebElementFacade callcenterIcon;

    @FindBy(id = "ServiceDesk_icon")
    private WebElementFacade consoleIcon;

    @FindBy(id = "OmniChannel_icon")
    private WebElementFacade omnichannelIcon;

    @FindBy(id = "LiveAgent_icon")
    private WebElementFacade chatIcon;

    @FindBy(id = "Macro_icon")
    private WebElementFacade macroIcon;

    @FindBy(id = "Contract_icon")
    private WebElementFacade contractIcon;

    @FindBy(id = "Order_icon")
    private WebElementFacade orderIcon;

    @FindBy(id = "Solutions_icon")
    private WebElementFacade solutionsIcon;

    @FindBy(id = "Products_icon")
    private WebElementFacade productsIcon;

    @FindBy(id = "Pricebook_icon")
    private WebElementFacade pricebookIcon;

    @FindBy(id = "ConsumptionSchedule_icon")
    private WebElementFacade consumptionIcon;

    @FindBy(id = "PartnerPortal_icon")
    private WebElementFacade partnerIcon;

    @FindBy(id = "PartnerNetwork_icon")
    private WebElementFacade salesforcetoslfcIcon;

    @FindBy(id = "WorkDotComObjectsNode_icon")
    private WebElementFacade workIcon;

    @FindBy(id = "Ideas_icon")
    private WebElementFacade ideasIcon;

    @FindBy(id = "Answers_icon")
    private WebElementFacade answerIcon;

    @FindBy(id = "Asset_icon")
    private WebElementFacade assetIcon;

    @FindBy(id = "UserCustomize_icon")
    private WebElementFacade userIcon;

    @FindBy(id = "UserProvisioningRequest_icon")
    private WebElementFacade userprovisioningIcon;

    @FindBy(id = "Einstein_icon")
    private WebElementFacade einsteinIcon;

    @FindBy(id = "SalesforceFiles_icon")
    private WebElementFacade salesforcefilesIcon;

    @FindBy(id = "Tagging_icon")
    private WebElementFacade tagsIcon;

    @FindBy(id = "ReportsAndDashboards_icon")
    private WebElementFacade reportsIcon;

    @FindBy(id = "Search_icon")
    private WebElementFacade searchIcon;

    @FindBy(id = "Collaboration_icon")
    private WebElementFacade chatterIcon;

    @FindBy(id = "Scorecard_icon")
    private WebElementFacade scorecardIcon;

    @FindBy(id = "Networks_icon")
    private WebElementFacade communitiesIcon;

    @FindBy(id = "Topic_icon")
    private WebElementFacade topicIcon;

    @FindBy(id = "FieldService_icon")
    private WebElementFacade fieldserviceIcon;

    @FindBy(id = "EmailExperience_icon")
    private WebElementFacade emailIcon;

    @FindBy(id = "Surveys_icon")
    private WebElementFacade surveysIcon;

    @FindBy(id = "Individual_icon")
    private WebElementFacade individualIcon;


    @FindBy(id = "AccountLinks_font")
    private WebElementFacade btnLinksActions;

//Opciones de objetos (genericos)
    @FindBy(linkText = "Fields")
    private WebElementFacade fieldsOption;

    @FindBy(linkText = "Related Lookup Filters")
    private WebElementFacade relatedFilterOption;

    @FindBy(linkText = "Validation Rules")
    private WebElementFacade validationrulesOption;

    @FindBy(linkText = "Triggers")
    private WebElementFacade triggerOption;

    @FindBy(linkText = "Page Layouts")
    private WebElementFacade pagelayoutOption;

    @FindBy(linkText = "Field Sets")
    private WebElementFacade fieldsetOption;

    @FindBy(linkText = "Compact Layouts")
    private WebElementFacade compactlayoutOption;

    @FindBy(linkText = "Search Layouts")
    private WebElementFacade searchlayoutOption;

    @FindBy(linkText = "Lead Assignment Rules")
    private WebElementFacade leadassignmentOption;

    @FindBy(linkText = "Lead Settings")
    private WebElementFacade leadsettingsOption;

    @FindBy(linkText = "Buttons, Links, and Actions")
    private WebElementFacade btnlinksactionsOption;

    @FindBy(id = "CampaignLinks_font")
    private WebElementFacade btnlinksactionsOption2;

    @FindBy(linkText = "Record Types")
    private WebElementFacade recordtypeOption;

    @FindBy(linkText = "Limits")
    private WebElementFacade limitsOption;

    public void buildOption(){
        customizeIcon.click();
    }

    public void selCustOpt(){
        btnlinksactionsOption.click();
    }

    public void setBtnlinksactionsOption2(){
        btnlinksactionsOption2.click();
    }

    public void switchToClassic(){
        try {
            userProfile.click();
            classicMode.click();
            setupLink.click();
        }catch (Exception e) {
            System.out.println(Message.ERROR);
        }
    }

    public void selSalesforceObject(String customizeOpt){
        switch (customizeOpt){
            case "Tab Names and Labels":
                tabIcon.click();
                break;
            case "Home":
                homeIcon.click();
                break;
            case "Activities":
                activityIcon.click();
                break;
            case "Campaigns":
                campaingIcon.click();
                break;
            case "Leads":
                leadIcon.click();
                break;
            case "Accounts":
                accountIcon.click();
                break;
            case "D&B Companies":
                dbCompaniesIcon.click();
                break;
            case "Contacts":
                contactIcon.click();
                break;
            case "Notes":
                notesIcon.click();
                break;
            case "Opportunities":
                opportunityIcon.click();
                break;
            case "Path":
                pathIcon.click();
                break;
            case "Quotes":
                quoteIcon.click();
                break;
            case "Forecasts":
                forecastIcon.click();
                break;
            case "Social Media":
                socialmediaIcon.click();
                break;
            case "Cases":
                caseIcon.click();
                break;
            case "Entitlement Management":
                entitlementIcon.click();
                break;
            case "Self-Service":
                selfserviceIcon.click();
                break;
            case "Call Center":
                callcenterIcon.click();
                break;
            case "Console":
                consoleIcon.click();
                break;
            case "Omni-Channel":
                omnichannelIcon.click();
                break;
            case "Chat (formerly Live Agent)":
                chatIcon.click();
                break;
            case "Macros":
                macroIcon.click();
                break;
            case "Contracts":
                contractIcon.click();
                break;
            case "Orders":
                orderIcon.click();
                break;
            case "Solutions":
                solutionsIcon.click();
                break;
            case "Products":
                productsIcon.click();
                break;
            case "Price Books":
                pricebookIcon.click();
                break;
            case "Consumption Schedules":
                consumptionIcon.click();
                break;
            case "Partners":
                partnerIcon.click();
                break;
            case "Salesforce to Salesforce":
                salesforcetoslfcIcon.click();
                break;
            case "Work.com":
                workIcon.click();
                break;
            case "Ideas":
                ideasIcon.click();
                break;
            case "Answers":
                answerIcon.click();
                break;
            case "Assets":
                assetIcon.click();
                break;
            case "Users":
                userIcon.click();
                break;
            case "User Provisioning Requests":
                userprovisioningIcon.click();
                break;
            case "Einstein":
                einsteinIcon.click();
                break;
            case "Salesforce Files":
                salesforcefilesIcon.click();
                break;
            case "Tags":
                tagsIcon.click();
                break;
            case "Reports & Dashboards":
                reportsIcon.click();
                break;
            case "Search":
                searchIcon.click();
                break;
            case "Chatter":
                chatterIcon.click();
                break;
            case "Scorecard":
                scorecardIcon.click();
                break;
            case "Communities":
                communitiesIcon.click();
                break;
            case "Topics":
                topicIcon.click();
                break;
            case "Field Service":
                fieldserviceIcon.click();
                break;
            case "Email":
                emailIcon.click();
                break;
            case "Survey":
                surveysIcon.click();
                break;
            case "Individuals":
                individualIcon.click();
                break;
                default:
                    System.out.println("b no match!!");
        }
    }

    public void selObjectOption(String option){
        switch (option){
            //Tab Names and Labels---------------------------------
            case "Rename Tabs and Labels":
                renametab.click();
                break;
            case "Help Settings":
                renamehelp.click();
                break;
            //Home -----------------------------------------------
            case "Home Page Components":
                homepagecomponents.click();
                break;
            case "Home Page Layouts":
                homepagelayouts.click();
                break;
            case "Custom Links":
                homelinks.click();
                break;
            //Activities -----------------------------------------
            case "Task Fields":
                break;
            case "Task Validation Rules":
                break;
            case "Task Triggers":
                break;
            case "Task Buttons, Links, and Actions":
                break;
            case "Task Page Layouts":
                break;
            case "Task Field Sets":
                break;
            case "Task Compact Layouts":
                break;
            case "Task Record Types":
                break;
            case "Task Limits":
                break;
            case "Event Fields":
                break;
            case "Event Validation Rules":
                break;
            case "Event Triggers":
                break;
            case "Event Buttons and Links":
                break;
            case "Event Page Layouts":
                break;
            case "Event Field Sets":
                break;
            case "Event Compact Layouts":
                break;
            case "Event Record Types":
                break;
            case "Event Limits":
                break;
            case "Activity Custom Fields":
                break;
            case "Activity Search Layouts":
                break;
            case "Activity Buttons":
                break;
            case "Activity Limits":
                break;
            case "Public Calendars and Resources":
                break;
            case "Activity Settings":
                break;
            //Activities -----------------------------------
            case "Fields":
                fieldsOption.click();
                break;
            case "Related Lookup Filters":
                relatedFilterOption.click();
                break;
            case "Validation Rules":
                validationrulesOption.click();
                break;
            case "Triggers":
                triggerOption.click();
                break;
            case "Page Layouts":
                pagelayoutOption.click();
                break;
            case "Field Sets":
                fieldsetOption.click();
                break;
            case "Compact Layouts":
                compactlayoutOption.click();
                break;
            case "Search Layouts":
                searchlayoutOption.click();
                break;
            case "Buttons, Links, and Actions":
                btnlinksactionsOption.click();
                break;
            case "Record Types":
                recordtypeOption.click();
                break;
            case "Limits":
                limitsOption.click();
                break;
            case "Campaign Influence":
                break;
            case "Campaign Members":
                break;
                default:
                    System.out.println("a no match!!");

        }

    }

}
