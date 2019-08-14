package steps.base.signup;

import net.thucydides.core.annotations.Step;
import steps.com.FillDataFromSpreadSheet;

public class OrgSignUpSteps {
    private String actor;
    private FillDataFromSpreadSheet fillDataFromSpreadSheet;

    @Step("#actor should be able to send the Org Information")
    public void setDataOrg()throws Exception{
        fillDataFromSpreadSheet.setOrgDataFromSpreadSheet();

    }

}
