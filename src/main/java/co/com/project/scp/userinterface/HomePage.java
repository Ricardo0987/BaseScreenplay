package co.com.project.scp.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("http://automationpractice.com/index.php")
public class HomePage extends PageObject {

    public static final Target SIGN_IN = Target.the("SIGN IN button").located(By.xpath("//*[@class=\"login\"]"));
}
