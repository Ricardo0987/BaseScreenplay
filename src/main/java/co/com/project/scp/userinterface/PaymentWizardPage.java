package co.com.project.scp.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaymentWizardPage extends PageObject {

    public static final Target CONTINUE_CHK = Target.the("continue checkout").located(By.xpath("//*[@title=\"Proceed to checkout\"]"));
    public static final Target CONTINUE_CHK_WZ = Target.the("continue checkout").located(By.xpath("//*[@id=\"center_column\"]//*[contains(text(),'Proceed to checkout')]"));
    public static final Target PROCESS_ADDRESS = Target.the("continue checkout").located(By.name("processAddress"));
    public static final Target FINAL_CHK = Target.the("final checkout").located(By.xpath("//*[@title=\"Pay by bank wire\"]"));
    public static final Target CONFIRM_BTN = Target.the("confirm checkout").located(By.xpath("//*[@id=\"cart_navigation\"]/button"));
    public static final Target PROCESS_CARRIER = Target.the("continue checkout").located(By.name("processCarrier"));
    public static final Target I_AGREE = Target.the("continue checkout").located(By.id("cgv"));

    public static final Target ORDER_CONFIRMATION = Target.the("order complete validation").located(By.id("center_column"));


}
