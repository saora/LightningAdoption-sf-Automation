package steps.com;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import net.serenitybdd.core.pages.PageObject;
import pages.LoginPage;

import java.io.IOException;
import java.util.List;

import static steps.com.GetDataFromSpreadSheet.getSheetsService;

public class LoginData extends PageObject {
    private LoginPage loginPage;

    public void loginSalesforce() throws IOException {
        Sheets service = getSheetsService();
        String spreadsheetId = "1lCOOmjCjy2IvDf7DhQJvMnTvhlpHPwAx1YmBRraM0PU";
        String range = "Login Test Data!A2:B";
        ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();
        List<List<Object>> values = response.getValues();
        if (values == null || values.size() == 0) {
            System.out.println("No data found.");
        } else {
            for (List row : values) {
                loginPage.setOrgUser(String.valueOf(row.get(0)));
                loginPage.setOrgPass(String.valueOf(row.get(1)));
                loginPage.submitBtn();
            }
        }
    }

}
