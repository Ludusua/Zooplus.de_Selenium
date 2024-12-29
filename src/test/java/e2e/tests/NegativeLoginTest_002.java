package e2e.tests;

import e2e.pages.StartPage;
import e2e.pages.LoginPage;
import e2e.pages.OverviewPage;
import org.testng.annotations.Test;

public class NegativeLoginTest_002 extends TestBase{

    LoginPage loginPage;

    StartPage startPage;

    OverviewPage overviewPage;

    public void negativeMethod(String email,String password,boolean emptyEmail,boolean emptyPassword,boolean shortPassword) throws InterruptedException {
        String myZoo = "Mein zooplus";
        startPage =new StartPage(app.driver);
        startPage.clickOnCookies();
        startPage.waitForLoadingStartPage();
        startPage.moveMouseToDropDownMyZoo();
        startPage.clickOnOneOfDropDownElement(myZoo);

        loginPage=new LoginPage(app.driver);
        loginPage.waitForLoadingLoginPage();
        if (emptyEmail){
            loginPage.setDateLoginPage(email,password);
            loginPage.waitForEmailError();
        }if (emptyPassword){
            loginPage.setDateLoginPage(email,password);
            loginPage.waitForEmptyPasswordError();
        }if (shortPassword){
            loginPage.setDateLoginPage(email,password);
            loginPage.waitForShortPasswordError();
        }


    }
    @Test
    public void emptyEmail() throws InterruptedException {
        negativeMethod("","Virthunter@12",true,false,false);
    }

    @Test
    public void emptyPassword() throws InterruptedException {
        negativeMethod("Virthunter@gmail.com","",false,true,false);
    }
    @Test
    public void shortPassword() throws InterruptedException {
        negativeMethod("Virthunter@gmail.com","Vi",false,false,true);
    }
}
