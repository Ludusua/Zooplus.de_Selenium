package e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class OverviewPage extends StartPage {
    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[normalize-space()='Hallo Anatolii']")
    WebElement customerName;
    @FindBy(xpath = "//div[@class='TopBar_headerAccountFlyoutWrapper__zTQP1']//div[@id='shopHeaderAccountLink']")
    WebElement dropDownMeinZoo;


    @FindBy(xpath = "//*[@class='LowerBar_categoryBar__OMjjU']//*[@class='LowerBar_categoryItem__5VHca']")
    WebElement mainNavBarOneOfNineElements;
    @FindBy(xpath = "//*[@class='LowerBar_categoryItemLink__HE2tM' and @href='/shop/katzen']")
    WebElement katzenfutterUndZubehoer;
    @FindBy(xpath = "//a[normalize-space()='Diätfutter']")
    WebElement dietFuetter;
    @FindBy(xpath = "//*[@class='CategoryFlyout_flyOutContainer__XqaBh']")
    WebElement mainContainer;
    @FindBy(xpath = "//h1[normalize-space()='Royal Canin Katzenfutter']")
    WebElement royalCanin;
    @FindBy(xpath = "//div[@class='App_lowerBarWrapper__UOF_u']//nav")
    WebElement container;
    @FindBy(xpath = "//*[@class='loy-bppo-bannerContainer__title']")
    WebElement titleOnBonusPage;


    public void waitForLoadingOverviewPage() {
        getWait().forVisibility(customerName);
        Assert.assertTrue(customerName.isDisplayed());
        getWait().forVisibility(dropDownMeinZoo);
        Assert.assertTrue(dropDownMeinZoo.isDisplayed());
        getWait().forVisibility(container);
        Assert.assertTrue(container.isDisplayed());

    }

    public void moveMouseToDropDownMyZoo() {
        Actions actions = new Actions(driver);
        actions.moveToElement(dropDownMeinZoo).perform();
    }


    public void clickOnOneOfMainContainerElement(String element) {
        List<WebElement> elements = driver.findElements(By.xpath("//*[@class='CategoryFlyout_flyOutContainer__XqaBh']"));
        for (WebElement element1 : elements) {
            if (element1.getText().equalsIgnoreCase(element)) {
                element1.click();
                break;
            }
        }
    }

    public void moveToOneOfMainNavBarElement(String element) {
        List<WebElement> elements = driver.findElements(By.xpath("//*[@id='header-category-links']//*[@class='LowerBar_categoryItem__5VHca']"));
        getWait().forAllVisibility(elements);
        for (WebElement element1 : elements) {
            if (element1.getText().contains(element)) {
                Actions actions = new Actions(driver);
                actions.moveToElement(element1).perform();
                break;
            }
        }
    }


    public void clickOnAllElementsOfDropDownMenu(List<String> expectedTitles) {
        moveMouseToDropDownMyZoo();
        List<WebElement> menus = driver.findElements(By.xpath("//*[@class='Flyout-module_flyoutVisible__u9qJE Flyout-module_flyout__qLvdx']//*[@class='Flyout-module_linkText__OZGD8']"));
        int menuItemsCount = menus.size();
        System.out.println(menuItemsCount);
        for (int i = 0; i < menuItemsCount; i++) {
            moveMouseToDropDownMyZoo();
            menus = driver.findElements(By.xpath("//*[@class='Flyout-module_flyoutVisible__u9qJE Flyout-module_flyout__qLvdx']//*[@class='Flyout-module_linkText__OZGD8']"));

            getWait().forAllVisibility(menus);
            if (menus.size() > i) {
                WebElement menuItem = menus.get(i);
                menuItem.click();
                try {
                    Thread.sleep(1000);
                    WebElement titleForAllPages = driver.findElement(By.xpath("//h1[contains(@class, 'title')] | //h2[contains(@class, 'title')]"));

                    if (titleForAllPages.isDisplayed()) {
                        getWait().forVisibility(titleForAllPages);

                        String actualPageTitle = titleForAllPages.getText();
                        System.out.println(actualPageTitle);

                        Assert.assertEquals(actualPageTitle, expectedTitles.get(i));
                    }

                } catch (Exception e) {
                    if (titleOnBonusPage.isDisplayed()) {
                        String actualBonusPageTitle = titleOnBonusPage.getText();
                        System.out.println(actualBonusPageTitle);

                        Assert.assertEquals(actualBonusPageTitle, expectedTitles.get(i));
                    } else {
                        System.out.println("Error");
                    }
                }
            }
        }
    }

    public void waitForSubMenuContainer(int numberOfContainer) {
        WebElement element = driver.findElement(By.xpath("//*[@id='header-category-flyout'][" + numberOfContainer + "]"));
        getWait().forVisibility(element);
        Assert.assertTrue(element.isDisplayed());
    }

    public void clickOnOneOfMainContainerElement(int category, int column, String element) {
        WebElement ctg = driver.findElement(By.xpath("//*[@id='header-category-flyout'][" + category + "]//*[@class='CategoryFlyout_animalPanelGroup___E_yP'][" + column + "]//*[text()='" + element + "']"));
        getWait().forVisibility(ctg);
        ctg.click();
    }


}
