package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ShoppingCartPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/h1[contains(text(), 'Shopping Cart')]")
    WebElement shoppingCartText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productNameText;
    @CacheLookup
    @FindBy(xpath = "//div[@class='input-group date']/input")
    WebElement deliveryDateText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[3]")
    WebElement modelText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement priceText;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a")
    WebElement macBookNameText;
    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement macBookQuantity;
    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement macBookUpdateButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class = 'table-responsive']/table/tbody/tr/td[6]")
    WebElement macBookTotal;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    WebElement checkoutButton;

    public ShoppingCartPage() {
        PageFactory.initElements(driver, this);
    }

    public String shoppingCartTextErrorMessage() {
        Reporter.log("Enter shoppingcart text error message " + shoppingCartText.toString());
        return getTextFromElement(shoppingCartText);
    }

    public String productNameErrorMessage() {
        Reporter.log(" Verify Product name error Message" + productNameText.toString());
        return getTextFromElement(productNameText);
    }

    public String deliveryDateErrorMessage() {
        return deliveryDateText.getAttribute("value");
        //return driver.findElement(deliveryDateText).getAttribute("value");
    }

    public String modelErrorMessage() {
        Reporter.log("Verify model error message" + modelText.toString());
        return getTextFromElement(modelText);
    }

    public String priceTotalErrorMessage() {
        Reporter.log("Verify price total error message" + priceText.toString());
        return getTextFromElement(priceText);
    }

    public String macBookNameErrorMessage() {
        Reporter.log("Verify Macbook name error message" + macBookNameText.toString());
        return getTextFromElement(macBookNameText);
    }

    public void updateMacBookQuantity() {
        //driver.findElement(By.xpath("//input[contains(@name, 'quantity')]")).clear();

        macBookQuantity.clear();
        sendTextToElement(macBookQuantity, "2");
        clickOnElement(macBookUpdateButton);
    }

    public String macBookTotalErrorMessage() {
        Reporter.log("Verify macbook total error message" + macBookTotal.toString());
        return getTextFromElement(macBookTotal);
    }

    public void clickOnCheckButton() {
        Reporter.log("Click on check button" + checkoutButton.toString());
        clickOnElement(checkoutButton);
    }
}
