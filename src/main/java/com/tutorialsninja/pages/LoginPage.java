package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Returning Customer')]")
    WebElement returningCustomerText;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailId;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordfield;
    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginText;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
    public String verifyReturningCustomer() {
        Reporter.log("Verifying returning customer: " + returningCustomerText.toString());
        return getTextFromElement(returningCustomerText);
    }

    public void enterEmailId(String email) {
        Reporter.log("Enter email " + email + " to email field " + emailId.toString());
        sendTextToElement(emailId, email);
    }

    public void enterPassword(String password) {
        Reporter.log("Enter password " + password + " to email field " + passwordfield.toString());
        sendTextToElement(passwordfield, password);
    }

    public void clickOnLoginButton() {
        Reporter.log("Click on login button" + loginText.toString());
        clickOnElement(loginText);
    }
}
