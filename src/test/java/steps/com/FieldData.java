package steps.com;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import net.serenitybdd.core.pages.PageObject;
import pages.CustomFieldPage;
import pages.HomePage;

import java.util.List;

import static steps.com.GetDataFromSpreadSheet.getSheetsService;

public class FieldData extends PageObject {
    private HomePage homePage;
    private CustomFieldPage fieldPage;

    public void setDataField() throws Exception{
        Sheets service = getSheetsService();
        String spreadsheetId = "1lCOOmjCjy2IvDf7DhQJvMnTvhlpHPwAx1YmBRraM0PU";
        String range= "Field Test Data!A3:P";
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

                switch (String.valueOf(row.get(0))){
                    case "Text":
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
                        break;
                    case "Date":
                        break;
                    case "Number":
                        break;
                    case "Currency":
                        break;
                }


            }
        }
    }
}
