package steps.base.signup;

import steps.com.SignUpData;

public class OrgSignUpSteps {
    private SignUpData signUpData;

    public void setDataOrg()throws Exception {
        signUpData.setOrgDataFromSpreadSheet();
    }
}
