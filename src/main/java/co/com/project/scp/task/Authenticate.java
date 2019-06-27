package co.com.project.scp.task;


import co.com.project.scp.model.User;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.project.scp.userinterface.HomePage.SIGN_IN;
import static co.com.project.scp.userinterface.SignInPage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Authenticate extends PageObject implements Task {
    private User user;

    public Authenticate(User user) {
        this.user = user;

    }

    public static Authenticate withTheFollowingData(User user) {
        return instrumented(Authenticate.class, user);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Click.on(SIGN_IN));

        if (user.getStatus().equals("registered")) {
            login(actor);
        } else {
            register(actor);
        }

//        WebElementFacade inputPassword = ValidatePasswordPage.PASSWORD.resolveFor(actor);
//        inputPassword.setImplicitTimeout(Duration.ofMillis(1300));
    }

    private <T extends Actor> void login(T actor) {

        actor.attemptsTo(Enter.theValue(user.getEmail()).into(EMAIL_LOGIN));
        actor.attemptsTo(Enter.theValue(user.getPassword()).into(PASS_LOGIN));
        actor.attemptsTo(Click.on(SUBMIT_LOGIN));

//        actor.attemptsTo(WaitUntil.the(SPINNER, isNotVisible()).forNoMoreThan(30).seconds());
//        int countAttemptsTypeDocument = 0;
//        while (DOCUMENT_TYPE.resolveFor(actor).getAttribute(OPTIONS_DOCUMENT_TYPE) == null && countAttemptsTypeDocument < 20) {
//            actor.attemptsTo(Click.on(DOCUMENT_TYPE));
//            countAttemptsTypeDocument++;
//        }

//        actor.attemptsTo(
//                Check.whether(status.trim().length() > 0)
//                        .andIfSo(
//                                Click.on(HomePage.optionDocumentType(status)))
//                        .otherwise(
//                                Hit.the(Keys.ESCAPE).into(BODY)),
//                Enter.theValue(email).into(HomePage.DOCUMENT_NUMBER),
//                Click.on(TITLE)
//
//        );
//        actor.attemptsTo(
//                Check.whether(SUBMIT.resolveFor(actor).isEnabled())
//                        .andIfSo(
//                                Click.on(HomePage.SUBMIT)
//                        )
//
//        );
//        waitFor(3).seconds();

    }

    private <T extends Actor> void register(T actor) {

        actor.attemptsTo(Enter.theValue(user.getPassword()).into(EMAIL_REG));
        actor.attemptsTo(Click.on(AUTH_REG));

//        actor.attemptsTo(
//                WaitUntil.the(ValidatePasswordPage.PASSWORD, isCurrentlyEnabled()),
//                Enter.theValue(password).into(ValidatePasswordPage.PASSWORD),
//                Click.on(TITLE)
//        );
//        WebElementFacade submitPassword = ValidatePasswordPage.SUBMIT.resolveFor(actor);
//        submitPassword.setImplicitTimeout(Duration.ofMillis(5000));
//        if (submitPassword.isEnabled()) {
//            actor.attemptsTo(
//                    WaitUntil.the(ValidatePasswordPage.SUBMIT, isVisible()),
//                    Click.on(ValidatePasswordPage.SUBMIT)
//            );
//        }

    }

}
