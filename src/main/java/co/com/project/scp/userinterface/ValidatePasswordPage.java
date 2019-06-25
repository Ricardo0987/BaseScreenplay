package co.com.project.scp.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ValidatePasswordPage extends PageObject {

    public static final Target PASSWORD = Target.the("Password").located(By.id("inputPasswordId"));
    public static final Target SUBMIT = Target.the("Sign in").located(By.id("btnValidarPasswordId"));
    public static final Target PASSWORD_ERROR = Target.the("Sign in").located(By.id("mat-error-4"));

}
