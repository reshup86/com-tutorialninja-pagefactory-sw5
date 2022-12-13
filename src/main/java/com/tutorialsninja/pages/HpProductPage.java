package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class HpProductPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'HP LP3065')]")
    WebElement hpText;
    @CacheLookup
    @FindBy(id = "input-quantity")
    WebElement inputQuantity;
    @CacheLookup
    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement addToCartLink;
    @CacheLookup
    @FindBy(xpath = "//body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/h1[1]")
    WebElement addToCartText;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartLink;

    public HpProductPage() {
        PageFactory.initElements(driver, this);
    }

    public String HpTextErrorMessage() {
        Reporter.log("Displaying error message");
        return getTextFromElement(hpText);

    }

    public void selectDate(String year, String month, String date) {
        Reporter.log("Selecting date, month and year");
        clickOnElement(By.xpath("//button[@class='btn btn-default']/i[@class='fa fa-calendar']")); // Opens the date picker
        while (true) {
            String monthYear = driver.findElement(By.xpath("//div[@class='datepicker-days']/table/thead/tr/th[@class='picker-switch']")).getText(); // Nov 2022
            String arr[] = monthYear.split(" ");

            String mon = arr[0];
            String yer = arr[1];

            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class='datepicker-days']/table[@class='table-condensed']/thead/tr/th[@class='next']"));
            }
        }

        // select date
        List<WebElement> allDates = driver.findElements(By.xpath("//table[@class='table-condensed']/tbody//tr//td"));
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;
            }
        }

    }

    public void changeProductQuantity() {
        Reporter.log("Enter quantity to quantity field " + inputQuantity.toString());
        driver.findElement(By.id("input-quantity")).clear();
        sendTextToElement(inputQuantity, "1");
    }

    public void clickOnAddToCartButton() {
        Reporter.log("Clicking on add to cart button");
        clickOnElement(addToCartLink);
    }

    public String addToCartErrorMessage() {
        Reporter.log("Displaying error message");
        return getTextFromElement(addToCartText);
    }

    public void clickOnShoppingCartButton() {
        Reporter.log("Clicking on shopping cart link");
        clickOnElement(shoppingCartLink);
    }
}
