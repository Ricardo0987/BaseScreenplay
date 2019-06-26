package co.com.project.scp.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/VirtualPurchase.feature",
        glue = "co.com.project.scp.stepdefinitions",
        tags = "@TestCase3",
        snippets = SnippetType.CAMELCASE
)
public class VirtualPurchaseRunner {

}

