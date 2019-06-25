package co.com.project.scp.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://testsucursalvirtualinversiones.mybluemix.net")
public class ValidateDocumentPage extends PageObject {

    public static final Target BODY = Target.the("Body").located(By.xpath("/html/body"));
    public static final Target TITLE = Target.the("Title").located(By.id("span-titulo"));
    public static final Target POPUP_MESSAGE = Target.the("Popup message").located(By.id("mat-dialog-1"));
    public static final Target DOCUMENT_TYPE = Target.the("Document Type").located(By.id("slct-tipoDocumento"));
    public static final Target DOCUMENT_NUMBER = Target.the("Document number").located(By.id("input-numeroDocumento"));
    public static final Target SPINNER = Target.the("spiner load validate document").located(By.xpath("//*[@class=\"overlay-loader\"]"));
    public static final Target DOCUMENT_ERROR_VALIDATION = Target.the("message validation document").located(By.id("mat-error-4"));
    public static final Target TYPE_DOCUMENT_ERROR_VALIDATION = Target.the("message validation type document").located(By.id("mat-error-3"));
    public static final Target SUBMIT = Target.the("Continue button").located(By.id("btn-continuar"));
    public static final String OPTIONS_DOCUMENT_TYPE = "aria-owns";

    public static Target optionDocumentType(String optionTypeDocument) {
        Target documentTypeOption;
        documentTypeOption = Target.the("Option Document Type").located(By.xpath("//*[@ng-reflect-value=\"" + optionTypeDocument + "\"]"));
        return documentTypeOption;
    }
}
