package co.com.project.scp.task;


import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.ArrayList;
import java.util.List;

import static co.com.project.scp.userinterface.CategoryPage.*;
import static java.lang.Integer.parseInt;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BuyDress extends PageObject implements Task {

    public static BuyDress moreExpensive() {
        return instrumented(BuyDress.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Click.on(DRESSES_BTN));

        List<WebElementFacade> dressesPrices = DRESSES_PRICES.resolveAllFor(actor);
        List<Integer> prices = new ArrayList<Integer>();
        int price = 0, maxPrice = 0, indexMaxPrice = 0;

        for (int i = 1; i < dressesPrices.size(); i++) {
            price = parseInt(dressesPrices.get(i).getAttribute("innerHTML")
                    .replaceAll("\\s", "")
                    .replace("$", "")
                    .replace(".", ""));
            prices.add(price);
            if (price > maxPrice) {
                maxPrice = price;
                indexMaxPrice = i;
            }
        }
        dressesPrices.get(indexMaxPrice).click();
        actor.attemptsTo(
                WaitUntil.the(CONTINUE_CHK, isVisible()),
                Click.on(CONTINUE_CHK),
                Click.on(CONTINUE_CHK_WZ),
                Click.on(PROCESS_ADDRESS),
                Click.on(I_AGREE),
                Click.on(PROCESS_CARRIER),
                Click.on(FINAL_CHK),
                Click.on(CONFIRM_BTN)

        );
    }
}
