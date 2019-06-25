package co.com.project.scp.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class CurrentPage extends PageObject {

    public static final Target BODY = Target.the("repository name")
            .locatedBy("/html/body");
}
