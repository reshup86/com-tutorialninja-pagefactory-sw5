package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ComponentsPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Components')]")
    WebElement componentsTest;

    public ComponentsPage() {
        PageFactory.initElements(driver, this);
    }

    public String navigateToComponentsErrorMessage() {
        Reporter.log("verify navigate to components error message" + componentsTest.toString());
        return getTextFromElement(componentsTest);
    }
}
