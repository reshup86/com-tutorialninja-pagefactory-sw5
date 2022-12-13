package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SuccessPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement yourAccountText;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement sucessContinue;

    public SuccessPage() {
        PageFactory.initElements(driver, this);
    }
    public String verifyYourAccountMessage() {
        Reporter.log("Verify your Account Message" + yourAccountText.toString());
        return getTextFromElement(yourAccountText);
    }

    public void clickOnSucessContinueButton() {
        Reporter.log("Click on sucess continue button " + sucessContinue.toString());
        clickOnElement(sucessContinue);
    }
}
