package co.com.project.scp.stepdefinitions;


import co.com.project.scp.questions.TheText;
import co.com.project.scp.task.Authenticate;
import co.com.project.scp.task.LogOut;
import co.com.project.scp.util.LoadData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import static co.com.project.scp.userinterface.CommonPage.MODAL_MESSAGE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.containsString;

public class VirtualPurchaseDefinition extends PageObject {


    @Given("^Megan enters the commerce page and register with user (.*) and password (.*)$")
    public void meganEntersTheCommercePageAndRegisterWithUserAndPassword(String arg1, String arg2) {
        theActorInTheSpotlight().attemptsTo(Authenticate.withTheFollowingData(
                LoadData.currentCase.getUser().getDocumentType(),
                LoadData.currentCase.getUser().getDocument(),
                LoadData.currentCase.getUser().getPassword()));
    }

    @When("^Megan buys the dress$")
    public void meganBuysTheDress() {

    }

    @Then("^Megan should see the voucher generated$")
    public void meganShouldSeeTheVoucherGenerated() {
        theActorInTheSpotlight().should(seeThat(TheText.ofFollowingTarget(MODAL_MESSAGE), containsString(LoadData.currentCase.getExpectResult())));

    }


    @When("^I try to authenticate myself using my credentials$")
    public void iTryToAuthenticateMyselfUsingMyCredentials() {
        waitFor(600).milliseconds();
        theActorInTheSpotlight().attemptsTo(Authenticate.withTheFollowingData(
                LoadData.currentCase.getUser().getDocumentType(),
                LoadData.currentCase.getUser().getDocument(),
                LoadData.currentCase.getUser().getPassword()));
    }

    @And("^Validate close full session$")
    public void validateCloseFullSession() {
        waitFor(500).milliseconds();
        theActorInTheSpotlight().attemptsTo(
                LogOut.now()
        );
    }

    @Given("^prueba$")
    public void prueba() {
        System.out.println("\u001B[32m" + "-------------------/////////   Prueba start ////////////-------------------" + "\u001B[0m");
        waitFor(1).seconds();
        System.out.println("\u001B[35m" + "-------------------/////////   Prueba end ////////////-------------------" + "\u001B[0m");

        Assert.assertTrue("-------------------/////////   Assert message ////////////-------------------", false);
    }

}
