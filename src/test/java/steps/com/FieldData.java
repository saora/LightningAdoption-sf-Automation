package steps.com;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.NoAlertPresentException;
import pages.CustomFieldPage;
import pages.HomePage;

import java.util.List;

import static steps.com.GetDataFromSpreadSheet.getSheetsService;

public class FieldData extends PageObject {
    private HomePage homePage;
    private CustomFieldPage fieldPage;

    public void setDataField() throws Exception {
        Sheets service = getSheetsService();
        String spreadsheetId = "1lCOOmjCjy2IvDf7DhQJvMnTvhlpHPwAx1YmBRraM0PU";
        String range = "Field Test Data!A3:Z";
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
                try {
                    if (String.valueOf(row.get(0)).equals("Lookup Relationship") || String.valueOf(row.get(0)).equals("External Lookup Relationship")) {
                        fieldPage.setSelRelatedTo(String.valueOf(row.get(1)));
                    } else {
                        fieldPage.setFill_Label(String.valueOf(row.get(2)));
                        fieldPage.setFill_devName(String.valueOf(row.get(6)));

                        if (String.valueOf(row.get(0)).equals("Date") || String.valueOf(row.get(0)).equals("Date/Time")) {
                            fieldPage.setFill_Description(String.valueOf(row.get(7)));
                            fieldPage.setFill_HelpText(String.valueOf(row.get(8)));
                            fieldPage.setCheck_Required(String.valueOf(row.get(9)));
                            fieldPage.setFill_DefaultValue(String.valueOf(row.get(14)));
                            fieldPage.click_OnNext();
                        } else {

                            switch (String.valueOf(row.get(0))) {
                                case "Auto Number":
                                    fieldPage.setFill_DisplayFormat(String.valueOf(row.get(3)));
                                    fieldPage.setFill_StartingNumber(String.valueOf(row.get(4)));
                                    fieldPage.setFill_Description(String.valueOf(row.get(7)));
                                    fieldPage.setFill_HelpText(String.valueOf(row.get(8)));
                                    fieldPage.setCheck_ExternalID(String.valueOf(row.get(13)));
                                    if (String.valueOf(row.get(16)).equals("Checked")) {
                                        fieldPage.setCheck_AutoNumber();
                                    }
                                    fieldPage.click_OnNext();
                                    break;
                                case "Formula":
                                    fieldPage.selFormulaType(String.valueOf(row.get(15)));
                                    if (String.valueOf(row.get(15)).equals("Currency") || String.valueOf(row.get(15)).equals("Number")) {
                                        fieldPage.setFill_DecimalPlaces(String.valueOf(row.get(18)));
                                    }
                                    fieldPage.click_OnNext();
                                    fieldPage.setFill_Description(String.valueOf(row.get(7)));
                                    fieldPage.setFill_HelpText(String.valueOf(row.get(8)));
                                    fieldPage.setFill_FormulaEditor(String.valueOf(row.get(25)));
                                    fieldPage.click_OnNext();
                                    break;
                                case "Roll-Up Summary":
                                    fieldPage.setFill_Description(String.valueOf(row.get(7)));
                                    fieldPage.setFill_HelpText(String.valueOf(row.get(8)));
                                    // agregar datos de la siguiente pantalla

                                    break;
                                case "Checkbox":
                                    fieldPage.setFill_Description(String.valueOf(row.get(7)));
                                    fieldPage.setFill_HelpText(String.valueOf(row.get(8)));
                                    fieldPage.click_OnNext();
                                    break;

                                case "Currency":
                                    fieldPage.setFill_Length(String.valueOf(row.get(5)));
                                    fieldPage.setFill_Description(String.valueOf(row.get(7)));
                                    fieldPage.setFill_HelpText(String.valueOf(row.get(8)));
                                    fieldPage.setCheck_Required(String.valueOf(row.get(9)));
                                    fieldPage.setFill_DefaultValue(String.valueOf(row.get(14)));
                                    fieldPage.setFill_DecimalPlaces(String.valueOf(row.get(18)));
                                    fieldPage.click_OnNext();
                                    break;

                                case "Email":
                                    fieldPage.setFill_Description(String.valueOf(row.get(7)));
                                    fieldPage.setFill_HelpText(String.valueOf(row.get(8)));
                                    fieldPage.setCheck_Required(String.valueOf(row.get(9)));
                                    fieldPage.setCheck_Unique(String.valueOf(row.get(10)));
                                    fieldPage.setCheck_ExternalID(String.valueOf(row.get(13)));
                                    fieldPage.setFill_DefaultValue(String.valueOf(row.get(14)));
                                    fieldPage.click_OnNext();
                                    break;
                                case "Geolocation":
                                    break;
                                case "Number":
                                    break;
                                case "Percent":
                                    break;
                                case "Phone":
                                    fieldPage.setCheck_Required(String.valueOf(row.get(9)));
                                    fieldPage.setFill_DefaultValue(String.valueOf(row.get(14)));
                                    break;
                                case "Picklist":
                                    break;
                                case "Picklist (Multi-Select)":
                                    break;
                                case "Text":
                                    fieldPage.setFill_Length(String.valueOf(row.get(5)));
                                    fieldPage.setCheck_Required(String.valueOf(row.get(9)));
                                    fieldPage.setCheck_Unique(String.valueOf(row.get(10)));
                                    fieldPage.setOpt_Unique(String.valueOf(row.get(11)));
                                    fieldPage.setCheck_ExternalID(String.valueOf(row.get(13)));
                                    fieldPage.setFill_DefaultValue(String.valueOf(row.get(14)));
                                    break;
                                case "Text Area":
                                    break;
                                case "Text Area (Long)":
                                    break;
                                case "Text Area (Rich)":
                                    break;
                                case "Text (Encrypted)":
                                    break;
                                case "Time":
                                    break;
                                case "URL":
                                    break;
                            }
                            fieldPage.click_OnNext();
                            fieldPage.setClick_Save();

                            try{
                                getAlert().accept();
                            }catch (NoAlertPresentException exception){
                                System.out.println("Alert not found !!!");
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
