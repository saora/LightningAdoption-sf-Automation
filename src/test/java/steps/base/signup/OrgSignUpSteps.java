package steps.base.signup;

import net.thucydides.core.annotations.Step;
import steps.com.SignUpData;

public class OrgSignUpSteps {
    private String actor;
    private SignUpData signUpData;

    @Step("#actor should be able to send the Org Information")
    public void setDataOrg()throws Exception {
        signUpData.setOrgDataFromSpreadSheet();

    }

}
