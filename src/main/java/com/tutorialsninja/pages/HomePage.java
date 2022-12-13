package com.tutorialsninja.pages;

import com.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul/li[contains(@class, 'open')]/div/child::*")
    List<WebElement> topMenu;
    @CacheLookup
    @FindBy(linkText = "Desktops")
    WebElement desktopLink;
    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopNotebooksLink;
    @CacheLookup
    @FindBy(linkText = "Components")
    WebElement componentsLink;
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currencyLink;
    @CacheLookup
    @FindBy(xpath = "//span[text()='My Account']")
    WebElement myAccountLink;

    @CacheLookup
    @FindAll(@FindBy(xpath = "//ul[@class = 'dropdown-menu']/li"))
    List<WebElement> currencyList;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnCurrency(String currencyChoice) {
        Reporter.log("Clicking on currency dropdown");
        clickOnElement(currencyLink);
        try {
            selectMenu(currencyList, currencyChoice);
        } catch (StaleElementReferenceException e) {
            List<WebElement> currencyList;
        }
    }

    public void selectMenu(String menu) {
// List<WebElement> topMenuList = driver.findElements(topMenu);
        try {
            for (WebElement element : topMenu) {
                if (element.getText().equalsIgnoreCase(menu)) {
                    element.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            //topMenu = driver.findElements(topMenu);
        }
    }

    public void mouseHoverToDesktopAndClick() {
        Reporter.log("Mouse Hovering to Desktop and Clicking on it: " + desktopLink.toString());
        mouseHoverToElementAndClick(desktopLink);
    }

    public void mouseHoverToLaptopsNotebooksAndClick() {
        Reporter.log("Mouse Hovering to LaptopsNotebooks and Clicking on it: " + laptopNotebooksLink.toString());
        mouseHoverToElementAndClick(laptopNotebooksLink);
    }

    public void mouseHoverToComponentsAndClick() {
        Reporter.log("Mouse Hovering to Components and Clicking on it: " + componentsLink.toString());
        mouseHoverToElementAndClick(componentsLink);
    }

    public void clickOnMyAccount() {
        Reporter.log("Clicking on my account: " + myAccountLink.toString());
        clickOnElement(myAccountLink);
    }

    public void selectMyAccountOptions(String menu) {
        String exp = String.format("//a[text()='%s']", menu);
        driver.findElement(By.xpath(exp)).click();
    }
}

