package co.com.project.scp.task;


import co.com.project.scp.userinterface.ValidateDocumentPage;
import co.com.project.scp.userinterface.ValidatePasswordPage;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static co.com.project.scp.userinterface.ValidateDocumentPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class Authenticate extends PageObject implements Task {
    private String documentType;
    private String document;
    private String password;

    public Authenticate(String documentType, String document, String password) {
        this.documentType = documentType;
        this.document = document;
        this.password = password;

    }

    public static Authenticate withTheFollowingData(String documentType, String document, String password) {
        return instrumented(Authenticate.class, documentType, document, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElementFacade inputPassword = ValidatePasswordPage.PASSWORD.resolveFor(actor);
        inputPassword.setImplicitTimeout(Duration.ofMillis(1300));

        validateDocument(actor);
        waitFor(6).seconds();
        if (inputPassword.isVisible()) {
            validatePassword(actor);
        }
    }

    private <T extends Actor> void validateDocument(T actor) {
        actor.attemptsTo(WaitUntil.the(SPINNER, isNotVisible()).forNoMoreThan(30).seconds());
        int countAttemptsTypeDocument = 0;
        while (DOCUMENT_TYPE.resolveFor(actor).getAttribute(OPTIONS_DOCUMENT_TYPE) == null && countAttemptsTypeDocument < 20) {
            actor.attemptsTo(Click.on(DOCUMENT_TYPE));
            countAttemptsTypeDocument++;
        }

        actor.attemptsTo(
                Check.whether(documentType.trim().length() > 0)
                        .andIfSo(
                                Click.on(ValidateDocumentPage.optionDocumentType(documentType)))
                        .otherwise(
                                Hit.the(Keys.ESCAPE).into(BODY)),
                Enter.theValue(document).into(ValidateDocumentPage.DOCUMENT_NUMBER),
                Click.on(TITLE)

        );
        actor.attemptsTo(
                Check.whether(SUBMIT.resolveFor(actor).isEnabled())
                        .andIfSo(
                                Click.on(ValidateDocumentPage.SUBMIT)
                        )

        );
        waitFor(3).seconds();

    }

    private <T extends Actor> void validatePassword(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ValidatePasswordPage.PASSWORD, isCurrentlyEnabled()),
                Enter.theValue(password).into(ValidatePasswordPage.PASSWORD),
                Click.on(TITLE)
        );
        WebElementFacade submitPassword = ValidatePasswordPage.SUBMIT.resolveFor(actor);
        submitPassword.setImplicitTimeout(Duration.ofMillis(5000));
        if (submitPassword.isEnabled()) {
            actor.attemptsTo(
                    WaitUntil.the(ValidatePasswordPage.SUBMIT, isVisible()),
                    Click.on(ValidatePasswordPage.SUBMIT)
            );
        }

    }

}
