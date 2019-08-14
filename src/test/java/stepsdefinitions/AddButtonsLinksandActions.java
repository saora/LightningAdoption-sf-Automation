package stepsdefinitions;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/com/features/build/customize/objectmanager/jsbuttons/jsbuttons.feature"})
//@CucumberOptions( tags = {"@RegressionTest" }, plugin = { "pretty", "html:target" },features = {"src/test/resources/com/features/build/customize/objectmanager/"})
//@CucumberOptions( features = {"src/test/resources/com/features/login/","src/test/resources/com/features/signup/"})
public class AddButtonsLinksandActions {
}
