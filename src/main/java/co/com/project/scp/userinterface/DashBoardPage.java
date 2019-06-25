package co.com.project.scp.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DashBoardPage extends PageObject {

    public static final Target WELCOME_MESSAGE = Target.the("Welcome Tittle").located(By.id("span-tituloBienvenida"));
    public static final Target LOGOUT_BUTTON = Target.the("Logout button").located(By.id("logOutId"));
    public static final Target LOGOUT_IMG = Target.the("Logout image").located(By.id("logOutImgId"));
    public static final Target CONTAINER_CARDS = Target.the("container cards").located(By.xpath("(//mat-card)[1]"));
    public static final Target CARDSNUMBERS = Target.the("cards numbers").located(By.id("spnProductNumber"));
    public static final Target CARDSDETAILS = Target.the("cards details").located(By.xpath("//*[contains(@id,'verDetalleTarjetaId')]"));
}
