package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class RegisterPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[text()='Register Account']")
    WebElement registerAccountText;
    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstname;
    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastname;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement email;
    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement telephone;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement password;
    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement confirmPassword;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@name='agree']")
    WebElement agreeCheckBox;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'buttons']//input[@value='Continue']")
    WebElement continueButton;

    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyRegisterAccount() {
        Reporter.log("Verify Register Account Text " + registerAccountText.toString());
        return getTextFromElement(registerAccountText);
    }

    public void enterFirstName(String text) {
        Reporter.log("Enter FirstName " + text + " to firstname field " + firstname.toString());
        sendTextToElement(firstname, text + getAlphaNumericString(5));
    }

    public void enterLastName(String text) {
        Reporter.log("Enter lastname " + text + " to lastname field " + lastname.toString());
        sendTextToElement(lastname, text + getAlphaNumericString(5));
    }

    public void enterEmail(String text) {
        Reporter.log("Enter Email " + text + " to email field " + email.toString());
        sendTextToElement(email, text + getAlphaNumericString(5));
    }

    public void enterTelephone(String text) {
        Reporter.log("Enter telephone " + text + " to telephone field " + telephone.toString());
        sendTextToElement(telephone, text);
    }

    public void enterPassword(String text) {
        Reporter.log("Enter password " + text + " to password field " + password.toString());
        sendTextToElement(password, text);
    }

    public void enterConformPassword(String text) {
        Reporter.log("Enter Conformpassword " + text + " to confirm password field " + confirmPassword.toString());
        sendTextToElement(confirmPassword, text);
    }

    public void clickOnSubcribe() {
        List<WebElement> radioButtons = driver.findElements(By.xpath("//fieldset[3]//input"));
        for (WebElement e : radioButtons) {
            if (e.getText().equals("Yes")) {
                e.click();
                break;
            }
        }

    }

    public void clickOnAgree() {
        Reporter.log("Click on Agree" + agreeCheckBox.toString());
        clickOnElement(agreeCheckBox);
    }

    public void clickOnContinue() {
        Reporter.log("Click on continue" + continueButton.toString());
        clickOnElement(continueButton);
    }
}
