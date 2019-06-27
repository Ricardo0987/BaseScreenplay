package co.com.project.scp.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CategoryPage extends PageObject {

    public static final Target DRESSES_BTN = Target.the("dresses button").located(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a"));
    public static final Target DRESSES_PRICES = Target.the("dresses prices").located(By.xpath("//*[@class=\"right-block\"]//*[@class=\"price product-price\"]"));

}
