package co.com.project.scp.questions;

import co.com.project.scp.userinterface.CurrentPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class TheText implements Question<String> {

    private Target target;

    public TheText(Target target) {
        this.target = target;
    }

    public static TheText ofFollowingTarget(Target target) {
        return new TheText(target);
    }

    public static TheText ofBody() {

        return new TheText(CurrentPage.BODY);
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(target).viewedBy(actor).asString();
    }
}

