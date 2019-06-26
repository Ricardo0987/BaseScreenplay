package co.com.project.scp.runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/Authenticate.feature",
        glue = "co.com.project.scp.stepdefinitions",
        tags = "@TestCase1",
        snippets = SnippetType.CAMELCASE,
        plugin = {"rerun:target/rerun.txt" }
     	//plugin = "json:target/cucumber_json/cucumber.json"
)
public class AuthenticateRunner {

}

