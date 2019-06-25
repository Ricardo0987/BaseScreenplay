package co.com.project.scp.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CommonPage extends PageObject {

    public static final Target MODAL_MESSAGE = Target.the("Sign in").located(By.className("alert-modal-container"));
    public static final Target VALIDATE_AUTH_FORM = Target.the("validate body auth").located(By.className("validate__body-form"));

}
