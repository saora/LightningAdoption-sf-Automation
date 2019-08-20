package steps.com;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import net.serenitybdd.core.pages.PageObject;
import pages.BtnLinksActionsPage;
import pages.HomePage;

import java.util.List;

import static steps.com.GetDataFromSpreadSheet.getSheetsService;

public class ActionData extends PageObject {

    private HomePage homePage;
    private BtnLinksActionsPage btnLinksActionsPage;

    public void getDataNewAction()throws Exception{
        Sheets service = getSheetsService();
        String spreadsheetId = "1lCOOmjCjy2IvDf7DhQJvMnTvhlpHPwAx1YmBRraM0PU";
        String range = "Action Test Data!A2:H";
        ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();
        List<List<Object>> values = response.getValues();
        if (values == null || values.size() == 0) {
            System.out.println("No data found.");
        } else {
            for (List row : values) {
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
}
