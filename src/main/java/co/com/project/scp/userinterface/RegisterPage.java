package co.com.project.scp.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegisterPage extends PageObject {

    public static final Target GEN_MR = Target.the("GEN Mr radioBtn").located(By.id("id_gender1"));
    public static final Target FIRSTNAME = Target.the("register form firstName").located(By.id("customer_firstname"));
    public static final Target LASTNAME = Target.the("register form lastName").located(By.id("customer_lastname"));
    public static final Target PASSWD = Target.the("register form pass").located(By.id("passwd"));
    public static final Target ADDRESS = Target.the("register form address").located(By.id("address1"));
    public static final Target CITY = Target.the("register form city").located(By.id("city"));
    public static final Target POSTCODE = Target.the("register form postcode").located(By.id("postcode"));
    public static final Target PHONE = Target.the("register form phone").located(By.id("phone_mobile"));
    public static final Target ALIAS = Target.the("register form alias").located(By.id("alias"));
    public static final Target SUBMIT_REGISTER = Target.the("submit form").located(By.id("submitAccount"));



    public static final String DAY = "days";
    public static final String MONTH = "months";
    public static final String YEAR = "years";
    public static final String STATE = "id_state";

}
