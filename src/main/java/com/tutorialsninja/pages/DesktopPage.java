package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.*;

public class DesktopPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement desktopText;
    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortByAToZ;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'HP LP3065')]")
    WebElement hpProduct;

    public DesktopPage() {
        PageFactory.initElements(driver, this);
    }

    public String navigateToDesktopErrorMessage() {
        Reporter.log("Navigate to desktop error message");
        return getTextFromElement(desktopText);

    }

    public Map<String, ArrayList> arrangeProductInDescendingOrder() {
        Reporter.log("Arrange products in descending order");
        Map<String, ArrayList> mapArrays = new HashMap<String, ArrayList>();
        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
        Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);
        // Select sort by Name Z - A
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");
        // After filter Z -A Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        mapArrays.put("originalProductsName", originalProductsName);
        mapArrays.put("afterSortByZToAProductsName", afterSortByZToAProductsName);
        return mapArrays;
        // Assert.assertEquals("Product not sorted into Z to A order",
        //  originalProductsName, afterSortByZToAProductsName);
    }

    public void sortByName() {
        Reporter.log("Selecting text from drop down");
        selectByVisibleTextFromDropDown(sortByAToZ, "Name (A - Z)");
    }

    public void clickOnHpProduct() {
        Reporter.log("Cliking on HP product");
        clickOnElement(hpProduct);
    }
}
