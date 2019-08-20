package steps.com;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import net.serenitybdd.core.pages.PageObject;
import pages.BtnLinksActionsPage;
import pages.HomePage;

import java.io.IOException;
import java.util.List;

import static steps.com.GetDataFromSpreadSheet.getSheetsService;

public class JsButtonData extends PageObject {
   private HomePage homePage;
   private BtnLinksActionsPage btnLinksActionsPage;

    public void getDataJsButton() throws IOException {
        Sheets service = getSheetsService();
        String spreadsheetId = "1lCOOmjCjy2IvDf7DhQJvMnTvhlpHPwAx1YmBRraM0PU";
        String range = "Js Button Test Data!A2:H";
        ValueRange response = service.spreadsheets().values().get(spreadsheetId, range).execute();
        List<List<Object>> values = response.getValues();
        if (values == null || values.size() == 0) {
            System.out.println("No data found.");
        } else {
            for (List row : values) {
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

}
