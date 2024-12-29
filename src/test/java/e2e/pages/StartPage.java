package e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class StartPage extends BasePage {

    public StartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='TopBar-module_headerAccountFlyoutWrapper__h0Wja']//i[@class='Account-module_inlinedPrimaryIcon__RbTiG']//*[name()='svg']")
    WebElement dropDownMeinZoo;

    @FindBy(xpath = "//*[@class='Flyout-module_linkText__OZGD8']")
    WebElement overviewMenu;

    @FindBy(xpath = "//*[@class='App-module_middleBarWrapper__LZYq0']")
    WebElement header;

    @FindBy(xpath = "//*[@id='onetrust-accept-btn-handler']")
    WebElement cookies;

    public void waitForLoadingStartPage() {
        getWait().forVisibility(header);
        Assert.assertTrue(header.isDisplayed());
        getWait().forVisibility(dropDownMeinZoo);
        Assert.assertTrue(dropDownMeinZoo.isDisplayed());
    }

    public void clickOnCookies() {
        getWait().forVisibility(cookies);
        cookies.click();

    }

    public void moveMouseToDropDownMyZoo() {
        moveMouseToElement(dropDownMeinZoo);
    }

    public void clickOnOneOfDropDownElement(String element) {
        List<WebElement> elements = driver.findElements(By.xpath("//*[@class='Flyout-module_flyoutVisible__u9qJE Flyout-module_flyout__qLvdx']//*[@class='Flyout-module_linkText__OZGD8']"));
        for (WebElement element1 : elements) {
            if (element1.getText().equalsIgnoreCase(element)) {
                element1.click();
                break;
            }
        }
    }
}
