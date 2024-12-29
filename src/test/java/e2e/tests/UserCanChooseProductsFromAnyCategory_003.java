package e2e.tests;

import e2e.enums.SubMenu;
import e2e.enums.SubSubMenu;
import e2e.pages.*;
import org.testng.annotations.Test;

public class UserCanChooseProductsFromAnyCategory_003 extends TestBase {

    LoginPage loginPage;

    StartPage startPage;

    OverviewPage overviewPage;

    ProductsPage productsPage;

    @Test
    public void UseCanClickOnOneElementOfMainNavBarTest() throws InterruptedException {


        String email = "Virthunter@gmail.com";
        String password = "Virthunter@12";
        String myZoo = "Mein zooplus";
        String katzen = "Hundefutter";
        String subSubMenu = "Rocco";

        startPage = new StartPage(app.driver);
        startPage.clickOnCookies();
        startPage.waitForLoadingStartPage();
        startPage.moveMouseToDropDownMyZoo();
        Thread.sleep(3000);
        startPage.clickOnOneOfDropDownElement(myZoo);

        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoadingLoginPage();
        loginPage.setDateLoginPage(email, password);

        overviewPage = new OverviewPage(app.driver);
        overviewPage.waitForLoadingOverviewPage();
        overviewPage.moveToOneOfMainNavBarElement(katzen);
        overviewPage.waitForSubMenuContainer(SubMenu.HUNDER.getValue());
        overviewPage.clickOnOneOfMainContainerElement(SubMenu.HUNDER.getValue(), SubSubMenu.SECTIONTWO.getValue(), subSubMenu);// короче тут какая шляпа посмотри в метод я там в локатор закидываю разные данные почему я так сделал да потому что нету одного локатора который бы ползрдил ко всем елементам ко всей той хуевой тучи товаров когда ты наводишься на какуб то категорию(я бы мог записать все вручнуб в скобках но решил сделать енамы что бы один раз в енамаз прописать все возможное и потом чисто в тесте вызвать то что тебе нудно пкороче просто зайди в енамаы и посмотри все там более менее понятно все )
        productsPage = new ProductsPage(app.driver);
        productsPage.waitForLoadingProductsPage();
        productsPage.checkIfAllProductsHaveCorrectName("Rocco");


    }


}
