package co.com.project.scp.task;


import co.com.project.scp.model.User;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static co.com.project.scp.userinterface.HomePage.SIGN_IN;
import static co.com.project.scp.userinterface.RegisterPage.*;
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

    }

    private <T extends Actor> void login(T actor) {

        actor.attemptsTo(Enter.theValue(user.getEmail()).into(EMAIL_LOGIN));
        actor.attemptsTo(Enter.theValue(user.getPassword()).into(PASS_LOGIN));
        actor.attemptsTo(Click.on(SUBMIT_LOGIN));


    }

    private <T extends Actor> void register(T actor) {

        actor.attemptsTo(Enter.theValue(user.getEmail() + Math.floor(Math.random() * 100 + 1)).into(EMAIL_REG));
        actor.attemptsTo(Click.on(AUTH_REG));

        waitFor(3).seconds();

        actor.attemptsTo(
                Click.on(GEN_MR),
                Enter.theValue(user.getFirstName()).into(FIRSTNAME),
                Enter.theValue(user.getLastName()).into(LASTNAME),
                Enter.theValue(user.getPassword()).into(PASSWD)
        );

        Select days = new Select(getDriver().findElement(By.id(DAY)));
        days.selectByValue(user.getDay());
        Select months = new Select(getDriver().findElement(By.id(MONTH)));
        months.selectByValue(user.getMonth());
        Select years = new Select(getDriver().findElement(By.id(YEAR)));
        years.selectByValue(user.getYear());

        actor.attemptsTo(
                Enter.theValue(user.getAddress()).into(ADDRESS),
                Enter.theValue(user.getCity()).into(CITY),
                Enter.theValue(user.getPostCode()).into(POSTCODE),
                Enter.theValue(user.getPhoneMobile()).into(PHONE),
                Enter.theValue(user.getAlias()).into(ALIAS)
        );
        Select state = new Select(getDriver().findElement(By.id(STATE)));
        state.selectByValue(user.getState());
        actor.attemptsTo(Click.on(SUBMIT_REGISTER));


    }

}
