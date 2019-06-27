package co.com.project.scp.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegisterPage extends PageObject {

    public static final Target GEN_MR = Target.the("GEN Mr radioBtn").located(By.id("id_gender1"));
    public static final Target FIRSTNAME = Target.the("register form").located(By.id("customer_firstname"));

    public static final Target LASTNAME = Target.the("register form").located(By.id("customer_lastname"));
    public static final Target PASSWD = Target.the("register form").located(By.id("passwd"));
    public static final Target DAYS = Target.the("register form").located(By.id("days"));

    /*
    days select
    months select
    years select
    company
    address1
    city
    id_state select
    postcode
    id_country select
    phone_mobile
    alias

    */


}
