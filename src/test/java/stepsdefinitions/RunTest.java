package stepsdefinitions;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
//@CucumberOptions(features = {"src/test/resources/com/features/base/login.feature"})
@CucumberOptions(features = {"src/test/resources/com/features/signup/signup.feature"})
//@CucumberOptions(features = {"src/test/resources/com/features/objectmanager/objectmanager.feature"})

public class RunTest {
}
