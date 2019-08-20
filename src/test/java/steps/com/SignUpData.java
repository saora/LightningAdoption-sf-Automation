package steps.com;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import net.serenitybdd.core.pages.PageObject;
import pages.OrgSignUpScreen;

import java.io.IOException;
import java.util.List;

import static steps.com.GetDataFromSpreadSheet.getSheetsService;

public class SignUpData extends PageObject {
    private OrgSignUpScreen signUpScreen;

    public void setOrgDataFromSpreadSheet() throws IOException {

        Sheets service = getSheetsService();
        String spreadsheetId = "1lCOOmjCjy2IvDf7DhQJvMnTvhlpHPwAx1YmBRraM0PU";
        String range = "New Org Test Data!A2:H";
        ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();
        List<List<Object>> values = response.getValues();
        if (values == null || values.size() == 0) {
            System.out.println("No data found.");
        } else {
            for (List row : values) {
                signUpScreen.open(); //Signup URL
                getDriver().manage().window().maximize();
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
}
