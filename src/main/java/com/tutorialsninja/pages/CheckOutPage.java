package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CheckOutPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Checkout')]")
    WebElement checkOutText;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'New Customer')]")
    WebElement newCustomerText;
    @CacheLookup
    @FindBy(xpath = "//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label[1]/input[1]")
    WebElement clickOnRadioButton;
    @CacheLookup
    @FindBy(id = "button-account")
    WebElement clickOnContinueButton;

    @CacheLookup
    @FindBy(id = "input-payment-firstname")
    WebElement firstName;
    @CacheLookup
    @FindBy(id = "input-payment-lastname")
    WebElement lastName;
    @CacheLookup
    @FindBy(id = "input-payment-email")
    WebElement email;
    @CacheLookup
    @FindBy(id = "input-payment-telephone")
    WebElement telephone;
    @CacheLookup
    @FindBy(id = "input-payment-address-1")
    WebElement address;
    @CacheLookup
    @FindBy(id = "input-payment-city")
    WebElement city;
    @CacheLookup
    @FindBy(id = "input-payment-postcode")
    WebElement postcode;
    @CacheLookup
    @FindBy(id = "input-payment-country")
    WebElement country;
    @CacheLookup
    @FindBy(id = "input-payment-zone")
    WebElement state;
    @CacheLookup
    @FindBy(id = "button-guest")
    WebElement continueLink;
    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible'][text()='Warning: Payment method required!']")
    WebElement warningMessage;
    @CacheLookup
    @FindBy(xpath = "//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/p[2]/textarea[1]")
    WebElement addCommentsText;
    @CacheLookup
    @FindBy(xpath = "//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/input[1]")
    WebElement addTerms;
    @CacheLookup
    @FindBy(id = "button-payment-method")
    WebElement checkoutContinueLink;

    public CheckOutPage() {
        PageFactory.initElements(driver, this);
    }
    public String verifyCheckoutText() {
        Reporter.log("verify checkout text " + checkOutText.toString());
        return getTextFromElement(checkOutText);
    }

    public String verifyCustomerText() {
        Reporter.log("verify customer text " + newCustomerText.toString());
        return getTextFromElement(newCustomerText);
    }

    public void clickOnGuestCheckOut() {
        Reporter.log("click on guest checkout " + clickOnContinueButton.toString());
        clickOnElement(clickOnRadioButton);
        clickOnElement(clickOnContinueButton);
    }

    public void enterFirstName(String text) {
        Reporter.log("Enter firstname " + text + " to firstName field " + firstName.toString());
        sendTextToElement(firstName, text);
    }

    public void enterLastName(String text) {
        Reporter.log("Enter Lastname " + text + " to lastname field " + lastName.toString());
        sendTextToElement(lastName, text);
    }

    public void enterEmail(String text) {
        Reporter.log("Enter email " + text + " to email field " + email.toString());
        sendTextToElement(email, text);
    }

    public void enterTelephone(String text) {
        Reporter.log("Enter Telephone " + text + " to telephone field " + telephone.toString());
        sendTextToElement(telephone, text);
    }

    public void enterAddress(String text) {
        Reporter.log("Enter Address " + text + " to Address field " + address.toString());
        sendTextToElement(address, text);
    }

    public void enterCity(String text) {
        Reporter.log("Enter City " + text + " to city field " + city.toString());
        sendTextToElement(city, text);
    }

    public void enterPostcode(String text) {
        Reporter.log("Enter Postcode " + text + " to postcode field " + postcode.toString());
        sendTextToElement(postcode, text);
    }

    public void entercountry(String text) {
        Reporter.log("Enter country " + text + " to country field " + country.toString());
        selectByValueFromDropDown(country, text);
    }

    public void enterState(String text) {
        Reporter.log("Enter State " + text + " to state field " + state.toString());
        selectByValueFromDropDown(state, text);
    }

    public void clickOnContinue() {
        Reporter.log("Click on continue" + continueLink.toString());
        clickOnElement(continueLink);
    }

    public String verifyWarningMethod() {
        Reporter.log("Verify warning method" + warningMessage.toString());
        System.out.println("Warning" + getTextFromElement(warningMessage));
        return getTextFromElement(warningMessage);
    }

    public void addComments() {
        Reporter.log("Add Comments" + addCommentsText.toString());
        sendTextToElement(addCommentsText, "This is my comment");
    }

    public void clickOnCheckBox() {
        Reporter.log("click on checkbox" + addTerms.toString());
        clickOnElement(addTerms);
    }

    public void checkOutContinueButton() {
        Reporter.log("click on checkout continueButton " + checkoutContinueLink.toString());
        clickOnElement(checkoutContinueLink);
    }
}