package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class WishListPage extends StartPage {
    public WishListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[normalize-space()='Meine Wunschliste']")
    WebElement MyWishListTitle;

    public void waitForLoadingWishListPage(){
        getWait().forVisibility(MyWishListTitle);
        Assert.assertTrue(MyWishListTitle.isDisplayed());
    }




}
