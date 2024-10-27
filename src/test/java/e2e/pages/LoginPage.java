package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='username']")
    WebElement emailInputField;
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordInputField;
    @FindBy(xpath = "//button[@id='primary-btn']")
    WebElement loginButton;
    @FindBy(xpath = "//h2[normalize-space()='Ich bin bereits Kunde']")
    WebElement customerTitle;
    @FindBy(xpath = "//div[contains(text(),'Bitte geben Sie eine gültige E-Mail Adresse ein')]")
    WebElement emailError;
    @FindBy(xpath = "//div[contains(text(),'Bitte geben Sie ein Passwort ein')]")
    WebElement emptyPasswordFieldError;
    @FindBy(xpath = "//div[contains(text(),'Ihr Passwort muss mindestens 6 Zeichen enthalten')]")
    WebElement shortPasswordFieldError;



    public void waitForLoadingLoginPage(){
        getWait().forVisibility(customerTitle);
        Assert.assertTrue(customerTitle.isDisplayed());

        getWait().forVisibility(emailInputField);
        Assert.assertTrue(emailInputField.isDisplayed());

        getWait().forVisibility(passwordInputField);
        Assert.assertTrue(passwordInputField.isDisplayed());

        getWait().forVisibility(loginButton);
        Assert.assertTrue(loginButton.isDisplayed());
    }

    public void setDateLoginPage(String email,String password){
        waitForLoadingLoginPage();
        emailInputField.sendKeys(email);
        passwordInputField.sendKeys(password);
        loginButton.click();


    }

    public void waitForEmailError(){
        getWait().forVisibility(emailError);
    }

    public void waitForEmptyPasswordError(){
        getWait().forVisibility(emptyPasswordFieldError);
    }

    public void waitForShortPasswordError(){
        getWait().forVisibility(shortPasswordFieldError);
    }
//    public String getPrice(){
//        String name=customerTitle.getText();
//        return name;
//    }


}
