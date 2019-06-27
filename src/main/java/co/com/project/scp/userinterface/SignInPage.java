package co.com.project.scp.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SignInPage extends PageObject {

    public static final Target EMAIL_LOGIN = Target.the("email input").located(By.id("email"));
    public static final Target PASS_LOGIN = Target.the("password input").located(By.id("passwd"));
    public static final Target SUBMIT_LOGIN = Target.the("submit Login").located(By.id("SubmitLogin"));

    public static final Target EMAIL_REG = Target.the("email register input").located(By.id("email_create"));
    public static final Target AUTH_REG = Target.the("authentication button").located(By.id("SubmitCreate"));


}
