package co.com.project.scp.task;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import static co.com.project.scp.userinterface.DashBoardPage.LOGOUT_BUTTON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LogOut extends PageObject implements Task {

    public static LogOut now() {
        return instrumented(LogOut.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        Target ERROR_CONTINUE = Target.the("error btn-dialogContinuar").located(By.id("btn-dialogContinuar"));
        WebElementFacade btnContinue = ERROR_CONTINUE.resolveFor(actor);

        while (btnContinue.isVisible()) {
            btnContinue.click();
        }
        waitFor(2).seconds();
        actor.attemptsTo(
                Click.on(LOGOUT_BUTTON)
        );

    }

}
