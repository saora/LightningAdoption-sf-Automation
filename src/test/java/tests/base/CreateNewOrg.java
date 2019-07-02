package tests.base;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.SheetsScopes;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.runner.RunWith;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.junit.Test;
import screens.base.ApplicationHomePage;
import screens.base.FillOrgDataFromSpreadSheet;
import screens.base.OrgSignUpScreen;
import steps.OrgSignUpSteps;

import java.io.InputStreamReader;


@RunWith(SerenityRunner.class)
public class CreateNewOrg {
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
    public static Credential authorize() throws IOException {
// Load client secrets.
        InputStream in = FillOrgDataFromSpreadSheet.class.getResourceAsStream("/client_secret.json");
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
// Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES).setDataStoreFactory(DATA_STORE_FACTORY).setAccessType("offline").build();
        Credential credential = new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
        System.out.println("Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
        return credential;
    }
    public static Sheets getSheetsService() throws IOException {
        Credential credential = authorize();
        return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential).setApplicationName(APPLICATION_NAME).build();
    }


    @Managed(driver="chrome")
    WebDriverFacade chromeDriver;

    @Steps
    private OrgSignUpSteps Salesforce_User;
    private FillOrgDataFromSpreadSheet readSpreadSheet;
    private ApplicationHomePage applicationHomePage;
    private OrgSignUpScreen signUpScreen;

    @Test
    public void checkOrgSuccessfullyCreated()throws Exception {
        Sheets service = getSheetsService();
        String spreadsheetId = "1lCOOmjCjy2IvDf7DhQJvMnTvhlpHPwAx1YmBRraM0PU";
        String range = "New Org Test Data!A2:H";
        ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();
        List<List<Object>> values = response.getValues();
        if (values == null || values.size() == 0) {
            System.out.println("No data found.");
        } else {
            for (List row : values) {
                Salesforce_User.IsAValidUrl();
// Print columns A and E, which correspond to indices 0 and 4.
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
            }
        }

        Salesforce_User.checkSuccess();
    }

}
