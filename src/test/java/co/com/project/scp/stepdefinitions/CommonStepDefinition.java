package co.com.project.scp.stepdefinitions;


import co.com.project.scp.exceptions.ExceptionMessages;
import co.com.project.scp.exceptions.MyBusinessException;
import co.com.project.scp.userinterface.HomePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CommonStepDefinition extends PageObject {
    @Managed(driver = "chrome")
    private WebDriver driverBrowser = null;

    private HomePage homePage = new HomePage();

    @After
    public void after() {
        waitFor(1).seconds();
    }

    @Before
    public void canBrowseTheWeb() {


        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        } else if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        } else if (os.contains("nix") || os.contains("aix") || os.contains("nux")) {
            throw new MyBusinessException(ExceptionMessages.EXCP_OS_UNSOPORTED);
        }
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("Ana").can(
                BrowseTheWeb.with(driverBrowser));

        theActorInTheSpotlight().can(BrowseTheWeb.with(driverBrowser));
        theActorInTheSpotlight().attemptsTo(Open.browserOn().the(homePage));
    }

}
