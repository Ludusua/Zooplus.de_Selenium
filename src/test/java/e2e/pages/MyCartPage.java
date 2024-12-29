package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyCartPage extends StartPage {

    public MyCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//h1[normalize-space()='Ihr Warenkorb'])[1]")
    WebElement myCart;  // - если продукты есть в корзине

    @FindBy(xpath = "(//h1[normalize-space()='Keine Artikel im Warenkorb'])[1]")
    WebElement noProductInCart;

    @FindBy(xpath = "//button[normalize-space()='Weiter Shoppen']")
    WebElement buyMoreButton;

}
