package e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.NoSuchElementException;

public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='shop-main-navigation']")
    WebElement container;

    public void waitForLoadingProductsPage() {
        getWait().forVisibility(container);
        Assert.assertTrue(container.isDisplayed());
    }

    public void checkIfAllProductsHaveCorrectName(String productNameIWrite) throws InterruptedException {
        int pageCount = 0;
        int maxPages = 6;
        while (pageCount < maxPages) {
            Thread.sleep(1000);
            List<WebElement> products = driver.findElements(By.xpath("//*[@class='ProductListItem_productInfoTitle__PUtxb']"));
            getWait().forAllVisibility(products);
            for (WebElement product : products) {
                String productName = product.getText();
                if (!productName.contains(productNameIWrite)) {
                    throw new AssertionError("Not all products have correct name");
                } else {
                    System.out.println("All products have correct name");
                }
            }
            try {
                WebElement nextButton = driver.findElement(By.xpath("//span[contains(text(), 'Weiter')]"));
                nextButton.click();
                waitForLoadingProductsPage();
            } catch (NoSuchElementException e) {
                System.out.println("No more pages, ending loop.");
                break;
            }
            pageCount++;
        }
    }


}
