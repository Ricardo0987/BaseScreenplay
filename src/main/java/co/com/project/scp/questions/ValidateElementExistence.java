package co.com.project.scp.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class ValidateElementExistence implements Question<Boolean> {

	private Target target;

    public ValidateElementExistence(Target target){
        this.target = target;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return target.resolveFor(actor).isDisplayed();
    }

    public static ValidateElementExistence search(Target target){
        return new ValidateElementExistence(target);
    }
}
