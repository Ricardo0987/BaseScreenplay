package co.com.project.scp.task;


import co.com.project.scp.model.User;
import co.com.project.scp.userinterface.RegisterPage;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.regex.Pattern;

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

    }

    private <T extends Actor> void login(T actor) {

        actor.attemptsTo(Enter.theValue(user.getEmail()).into(EMAIL_LOGIN));
        actor.attemptsTo(Enter.theValue(user.getPassword()).into(PASS_LOGIN));
        actor.attemptsTo(Click.on(SUBMIT_LOGIN));


    }

    private <T extends Actor> void register(T actor) {

        actor.attemptsTo(Enter.theValue(user.getEmail()).into(EMAIL_REG));
        actor.attemptsTo(Click.on(AUTH_REG));

//        Select days = new Select((WebElement) RegisterPage.DAYS);
        Select days = new Select(getDriver().findElement(By.id("days")));
        days.selectByValue("3");
        Select months = new Select(getDriver().findElement(By.id("months")));
        months.selectByValue("4");

    }

}
