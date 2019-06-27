package co.com.project.scp.stepdefinitions;


import co.com.project.scp.exceptions.ExceptionMessages;
import co.com.project.scp.exceptions.MyBusinessException;
import co.com.project.scp.questions.TheText;
import co.com.project.scp.task.Authenticate;
import co.com.project.scp.task.BuyDress;
import co.com.project.scp.userinterface.HomePage;
import co.com.project.scp.util.LoadData;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static co.com.project.scp.userinterface.PaymentWizardPage.ORDER_CONFIRMATION;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.containsString;

public class VirtualPurchaseDefinition extends PageObject {
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
        OnStage.theActorCalled("Megan").can(
                BrowseTheWeb.with(driverBrowser));

        theActorInTheSpotlight().can(BrowseTheWeb.with(driverBrowser));
        theActorInTheSpotlight().attemptsTo(Open.browserOn().the(homePage));
    }


    @Given("^enters the commerce page and authenticate using data index <(.*)> from <(.*)> file$")
    public void entersTheCommercePageAndAuthenticateUsingDataIndexFromFile(int index, String jsonFile) {
        LoadData.in(index, jsonFile);
        theActorInTheSpotlight().attemptsTo(Authenticate.withTheFollowingData(
                LoadData.currentCase.getUser()));
    }


    @When("^buys the dress$")
    public void meganBuysTheDress() {
        theActorInTheSpotlight().attemptsTo(BuyDress.moreExpensive());
    }

    @Then("^should see the voucher generated$")
    public void meganShouldSeeTheVoucherGenerated() {
        theActorInTheSpotlight().should(seeThat(TheText.ofFollowingTarget(ORDER_CONFIRMATION), containsString(LoadData.currentCase.getExpectResult())));

    }

    @Then("^should see the error message$")
    public void shouldSeeTheErrorMessage() {
        theActorInTheSpotlight().should(seeThat(TheText.ofBody(), containsString(LoadData.currentCase.getExpectResult())));

    }
}
