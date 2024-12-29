package e2e.tests;

import e2e.pages.LoginPage;
import e2e.pages.OverviewPage;
import e2e.pages.StartPage;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PositiveLoginTest_001 extends TestBase {

    LoginPage loginPage;

    StartPage startPage;

    OverviewPage overviewPage;

    @Test
    public void positiveLoginTest() throws InterruptedException {
        String email = "Virthunter@gmail.com";
        String password = "Virthunter@12";
        String myZoo = "Mein zooplus";

        startPage = new StartPage(app.driver);
        startPage.clickOnCookies();
        startPage.waitForLoadingStartPage();
        startPage.moveMouseToDropDownMyZoo();
        startPage.clickOnOneOfDropDownElement(myZoo);

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoadingLoginPage();
        loginPage.setDateLoginPage(email, password);
        overviewPage = new OverviewPage(app.driver);
        overviewPage.waitForLoadingOverviewPage();
    }
}
