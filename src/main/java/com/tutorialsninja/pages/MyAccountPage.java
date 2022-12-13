package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class MyAccountPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountLink;

    public MyAccountPage() {
        PageFactory.initElements(driver, this);
    }
    public void clickOnMyAccountLink() {
        Reporter.log("Click on my account link " + myAccountLink.toString());
        clickOnElement(myAccountLink);
    }


}
