package steps.com;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import net.serenitybdd.core.pages.PageObject;
import pages.*;
import screens.base.GetApplicationUrl;
import screens.gmail.InboxReader;
import steps.base.login.LoginSteps;

import javax.mail.MessagingException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class FillDataFromSpreadSheet extends PageObject {

    private GetApplicationUrl urlApplication;
    private OrgSignUpScreen signUpScreen;
    private BtnLinksActionsPage btnLinksActionsPage;
    private HomePage homePage;
    private LoginPage loginPage;
    private LoginSteps loginSteps;
    private CustomFieldPage fieldPage;

    private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
    private static final java.io.File DATA_STORE_DIR = new java.io.File(System.getProperty("user.home"), ".credentials/sheets.googleapis.com-java-quickstart");
    private static FileDataStoreFactory DATA_STORE_FACTORY;
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static HttpTransport HTTP_TRANSPORT;
    private static final List<String> SCOPES = Arrays.asList(SheetsScopes.SPREADSHEETS_READONLY);

    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    private static Credential authorize() throws IOException {
// Load client secrets.
        InputStream in = FillDataFromSpreadSheet.class.getResourceAsStream("/client_secret.json");
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
// Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES).setDataStoreFactory(DATA_STORE_FACTORY).setAccessType("offline").build();
        Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
        System.out.println("Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }
    private static Sheets getSheetsService() throws IOException {
        Credential credential = authorize();
        return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential).setApplicationName(APPLICATION_NAME).build();
    }

    public void setOrgDataFromSpreadSheet() throws IOException{
        // Build a new authorized API client service.
        Sheets service = getSheetsService();
        String spreadsheetId = "1lCOOmjCjy2IvDf7DhQJvMnTvhlpHPwAx1YmBRraM0PU";
                String range = "New Org Test Data!A2:H";
                ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();
                List<List<Object>> values = response.getValues();
                if (values == null || values.size() == 0) {
                    System.out.println("No data found.");
                } else {
                    //getDriver().manage().window().maximize();
                    for (List row : values) {
                        signUpScreen.open(); //Signup URL
                        signUpScreen.setFill_FirtName(String.valueOf(row.get(0)));
                        signUpScreen.setFill_LastName(String.valueOf(row.get(1)));
                        signUpScreen.setFill_userEmail(String.valueOf(row.get(2)));
                        signUpScreen.setSel_JobRole(String.valueOf(row.get(3)));
                        signUpScreen.setFill_Company(String.valueOf(row.get(4)));
                        signUpScreen.setSel_Country(String.valueOf(row.get(5)));
                        signUpScreen.setFill_PostalCode(String.valueOf(row.get(6)));
                        signUpScreen.setFill_UserName(String.valueOf(row.get(7)));
                        signUpScreen.setConfirm_Agree();
                        signUpScreen.setSubmit();
                        //Assert.assertEquals("Salesforce Developers",getTitle());
                    }
                }
    }

    public void getDataJsButton() throws IOException {
        Sheets service = getSheetsService();
        String spreadsheetId2 = "1lCOOmjCjy2IvDf7DhQJvMnTvhlpHPwAx1YmBRraM0PU";
        String rangeJsButton = "Js Button Test Data!A2:H";
        ValueRange respJsButton = service.spreadsheets().values().get(spreadsheetId2, rangeJsButton).execute();
        List<List<Object>> valuesJsButton = respJsButton.getValues();
        if (valuesJsButton == null || valuesJsButton.size() == 0) {
            System.out.println("No data found.");
        } else {
            for (List row : valuesJsButton) {
                homePage.selObjectOption("Buttons, Links, and Actions");
                btnLinksActionsPage.clickOption("New Button or Link");
                btnLinksActionsPage.setFillLabel(String.valueOf(row.get(0)));
                btnLinksActionsPage.setFillName(String.valueOf(row.get(1)));
                btnLinksActionsPage.setFillDescription(String.valueOf(row.get(2)));
                switch (String.valueOf(row.get(3))){
                    case "Detail Page Link":
                        btnLinksActionsPage.setDetailPageLink();
                        break;
                    case "Detail Page Button":
                        btnLinksActionsPage.setDetailPageButton();
                        break;
                    case "List Button":
                        btnLinksActionsPage.setListButton();
                        break;
                    default:
                        System.out.println("no match");
                }
                btnLinksActionsPage.setSelBehavior(String.valueOf(row.get(4)));
                btnLinksActionsPage.setSelContentSource(String.valueOf(row.get(5)));
                try {
                    btnLinksActionsPage.setFillContentEditor(String.valueOf(row.get(6)));
                }catch (Exception e){
                    System.out.println("Content Editor is not present");
                }
                btnLinksActionsPage.saveJsButton();
            }
        }
    }


    public void getDataNewAction()throws Exception{
        Sheets service = getSheetsService();
        String spreadsheetId = "1lCOOmjCjy2IvDf7DhQJvMnTvhlpHPwAx1YmBRraM0PU";
        String rangeAction = "Action Test Data!A2:H";
        ValueRange responseAction = service.spreadsheets().values().get(spreadsheetId, rangeAction).execute();
        List<List<Object>> valuesAction = responseAction.getValues();
        if (valuesAction == null || valuesAction.size() == 0) {
            System.out.println("No data found.");
        } else {
            for (List row : valuesAction) {
                // get columns A to G, which correspond to indices 0 and 7.
                homePage.selObjectOption("Buttons, Links, and Actions");
                btnLinksActionsPage.clickOption("New Action");
                btnLinksActionsPage.setSelActionType(String.valueOf(row.get(0)));
                btnLinksActionsPage.setSelTargetObject(String.valueOf(row.get(1)));
                btnLinksActionsPage.setSelStdLabel(String.valueOf(row.get(2)));
                btnLinksActionsPage.setFillLabel(String.valueOf(row.get(3)));
                btnLinksActionsPage.setfillDevName(String.valueOf(row.get(4)));
                btnLinksActionsPage.setFillDescription(String.valueOf(row.get(5)));
                if (String.valueOf(row.get(6)).equals("Unchecked")){
                    btnLinksActionsPage.setCreateFeedItem();
                }
                btnLinksActionsPage.setFillMessage(String.valueOf(row.get(7)));
                btnLinksActionsPage.saveAction();
            }
        }
    }

    public void loginSalesforce() throws IOException {
        Sheets service = getSheetsService();
        String spreadsheetId = "1lCOOmjCjy2IvDf7DhQJvMnTvhlpHPwAx1YmBRraM0PU";
        String rangeLogin = "Login Test Data!A2:H";
        ValueRange responseLogin = service.spreadsheets().values().get(spreadsheetId, rangeLogin).execute();
        List<List<Object>> valuesLogin = responseLogin.getValues();
        if (valuesLogin == null || valuesLogin.size() == 0) {
            System.out.println("No data found.");
        } else {
            String orgPass = "";
            String orgUser = "";
            for (List row : valuesLogin) {
                orgUser = String.valueOf(row.get(0));
                orgPass = String.valueOf(row.get(1));
            }
            loginPage.setLoginData(orgUser, orgPass);
            loginPage.submitBtn();
        }
    }

    public void verifyAccount()throws MessagingException, IOException{
        Sheets service = getSheetsService();
        String spreadsheetId = "1lCOOmjCjy2IvDf7DhQJvMnTvhlpHPwAx1YmBRraM0PU";
        String rangeLogin = "Login Test Data!A2:H";
        ValueRange responseLogin = service.spreadsheets().values().get(spreadsheetId, rangeLogin).execute();
        List<List<Object>> valuesLogin = responseLogin.getValues();
        if (valuesLogin == null || valuesLogin.size() == 0) {
            System.out.println("No data found.");
        } else {
            String emailUser = "";
            String emailPass = "";
            for (List row : valuesLogin) {
                emailUser = String.valueOf(row.get(2));
                emailPass = String.valueOf(row.get(3));
            }
                String a = InboxReader.getEmail(emailUser, emailPass);
                loginPage.setVerificationCode(a);

        }
    }


    public void setDatafield()throws Exception{
        Sheets service = getSheetsService();
        String spreadsheetId = "1lCOOmjCjy2IvDf7DhQJvMnTvhlpHPwAx1YmBRraM0PU";
        String range= "Field Test Data!A3:H";
        ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();
        List<List<Object>> values = response.getValues();
        if (values == null || values.size() == 0) {
            System.out.println("No data found.");
        } else {
            for (List row : values) {

                homePage.selObjectOption("Fields");
                fieldPage.clik_NewField();
                fieldPage.selDataType(String.valueOf(row.get(0)));
                fieldPage.click_OnNext();

                fieldPage.setFill_Label(String.valueOf(row.get(2)));
                fieldPage.setFill_Length(String.valueOf(row.get(5)));
                fieldPage.setFill_devName(String.valueOf(row.get(6)));
                fieldPage.setFill_Description(String.valueOf(row.get(7)));
                fieldPage.setFill_HelpText(String.valueOf(row.get(8)));
                fieldPage.setCheck_Required(String.valueOf(row.get(9)));
                fieldPage.setCheck_Unique(String.valueOf(row.get(10)));
                fieldPage.setOpt_Unique(String.valueOf(row.get(11)));
                fieldPage.setCheck_ExternalID(String.valueOf(row.get(13)));
                fieldPage.setFill_DefaultValue(String.valueOf(row.get(14)));
                fieldPage.click_OnNext();
                fieldPage.click_OnNext();
                fieldPage.setClick_Save();
            }
        }
    }
}
