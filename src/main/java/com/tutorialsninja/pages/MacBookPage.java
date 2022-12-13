package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class MacBookPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'MacBook')]")
    WebElement macBookText;
    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement macAddToCart;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartLink;

    public MacBookPage(){
        PageFactory.initElements(driver, this);
    }
    public String macBookErrorMessage() {
        Reporter.log("Verify Macbook error Message " + macBookText.toString());
        return getTextFromElement(macBookText);
    }

    public void macBookAddToCart() {
        Reporter.log("mac book add to cart" + macAddToCart.toString());
        clickOnElement(macAddToCart);

    }

    public void clickOnShoppingCartButton() {
        Reporter.log("Click on shopping cart button" + shoppingCartLink.toString());
        clickOnElement(shoppingCartLink);
    }
}
