package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class OrdersPage extends StartPage {
    public OrdersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='Alle Bestellungen']")
    WebElement allOrders;

    public void waitForLoadingOrdersPage(){
        getWait().forVisibility(allOrders);
        Assert.assertTrue(allOrders.isDisplayed());
    }

}
