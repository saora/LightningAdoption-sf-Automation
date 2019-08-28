package steps.com;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import net.serenitybdd.core.pages.PageObject;
import pages.LoginPage;
import screens.gmail.InboxReader;

import java.util.List;

import static steps.com.GetDataFromSpreadSheet.getSheetsService;

public class EmailData extends PageObject {
    private LoginPage loginPage;

    public void verifyAccount()throws Exception{
        Sheets service = getSheetsService();
        String spreadsheetId = "1lCOOmjCjy2IvDf7DhQJvMnTvhlpHPwAx1YmBRraM0PU";
        String range = "Login Test Data!C2:D";
        ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();
        List<List<Object>> values = response.getValues();
        if (values == null || values.size() == 0) {
            System.out.println("No data found.");
        } else {
            String emailUser = "";
            String emailPass = "";
            for (List row : values) {
                emailUser = String.valueOf(row.get(0));
                emailPass = String.valueOf(row.get(1));
            }
            try {
                String a = InboxReader.getEmail(emailUser, emailPass);
                loginPage.setVerificationCode(a);
            }catch (Exception e){
                System.out.println("Verification not nedded");
            }
        }
    }
}
