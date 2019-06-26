package co.com.project.scp.runners;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = "co.com.project.scp.stepdefinitions",
        features = "@target/rerun.txt",
        plugin = {"rerun:target/rerun.txt"}
        )
public class FailedRunner {
}
       // gradle test --tests "AuthenticateRunner" "FailedRunner" aggregate --info -Dfile.encoding=UTF-8

// gradle test --tests "AuthenticateRunner" aggregate test --tests "FailedRunner" aggregate --info -Dfile.encoding=UTF-8
