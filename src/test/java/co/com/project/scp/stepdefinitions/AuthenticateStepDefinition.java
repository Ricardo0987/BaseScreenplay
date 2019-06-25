package co.com.project.scp.stepdefinitions;


import co.com.project.scp.questions.TheText;
import co.com.project.scp.task.LogOut;
import co.com.project.scp.task.Authenticate;
import co.com.project.scp.util.LoadData;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.pages.PageObject;

import static co.com.project.scp.userinterface.CommonPage.MODAL_MESSAGE;
import static co.com.project.scp.userinterface.CommonPage.VALIDATE_AUTH_FORM;
import static co.com.project.scp.userinterface.DashBoardPage.WELCOME_MESSAGE;
import static co.com.project.scp.userinterface.ValidatePasswordPage.PASSWORD_ERROR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.containsString;


public class AuthenticateStepDefinition extends PageObject {


    @When("^I try to authenticate myself using my credentials$")
    public void iTryToAuthenticateMyselfUsingMyCredentials() {
    	waitFor(600).milliseconds();
        theActorInTheSpotlight().attemptsTo(Authenticate.withTheFollowingData(
                LoadData.currentCase.getUser().getDocumentType(),
                LoadData.currentCase.getUser().getDocument(),
                LoadData.currentCase.getUser().getPassword()));
    }
    
    @Then("^can see the dashboard$")
    public void canSeeTheDashboard() {
        theActorInTheSpotlight().should(seeThat(TheText.ofFollowingTarget(WELCOME_MESSAGE), containsString(LoadData.currentCase.getExpectResult())));
    }


    @Then("^I should see form error message$")
    public void iShouldSeeFormErrorMessage() {
        theActorInTheSpotlight().should(seeThat(TheText.ofFollowingTarget(VALIDATE_AUTH_FORM), containsString(LoadData.currentCase.getExpectResult())));
    }

    @Then("^I should see password error message$")
    public void iShouldSeePasswordErrorMessage() {
        theActorInTheSpotlight().should(seeThat(TheText.ofFollowingTarget(PASSWORD_ERROR), containsString(LoadData.currentCase.getExpectResult())));
    }

    @Then("^I should see modal error message$")
    public void iShouldSeeModalErrorMessage() {
        theActorInTheSpotlight().should(seeThat(TheText.ofFollowingTarget(MODAL_MESSAGE), containsString(LoadData.currentCase.getExpectResult())));

    }

    @And("^Validate close full session$")
    public void validateCloseFullSession() {
        waitFor(500).milliseconds();
        theActorInTheSpotlight().attemptsTo(
                LogOut.now()
        );
    }

}
