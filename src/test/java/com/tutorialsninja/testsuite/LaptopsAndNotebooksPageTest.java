package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Map;

public class LaptopsAndNotebooksPageTest extends BaseTest {
    HomePage homePage;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    MacBookPage macBookPage;
    ShoppingCartPage shoppingCartPage;
    CheckOutPage checkOutPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        macBookPage = new MacBookPage();
        shoppingCartPage = new ShoppingCartPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        homePage.mouseHoverToLaptopsNotebooksAndClick();
        homePage.selectMenu("Show All Laptops & Notebooks");
        Thread.sleep(5000);
        Map<String, ArrayList> mapArrays = laptopsAndNotebooksPage.arrangeProductHighToLowOrder();
        Assert.assertEquals(mapArrays.get("originalProductsPrice"), mapArrays.get("afterSortByPrice"));

    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserPlaceOrderSuccessfully() {
        homePage.clickOnCurrency("£ Pound Sterling");
        homePage.mouseHoverToLaptopsNotebooksAndClick();
        homePage.selectMenu("Show All Laptops & Notebooks");
        laptopsAndNotebooksPage.clickOnMacBookLink();
        Assert.assertEquals(macBookPage.macBookErrorMessage(), "MacBook", "MacBook Product not display");
        macBookPage.macBookAddToCart();
        Assert.assertTrue(getTextFromElement(By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible")).contains("Success: You have added MacBook to your shopping cart!"), "Product not added to cart");
        macBookPage.clickOnShoppingCartButton();
        Assert.assertEquals(shoppingCartPage.shoppingCartTextErrorMessage(), "Shopping Cart  (0.00kg)", "Shopping cart is not displayed");
        Assert.assertEquals(shoppingCartPage.macBookNameErrorMessage(), "MacBook", "Product name not matched");
        shoppingCartPage.updateMacBookQuantity();
        Assert.assertTrue(getTextFromElement(By.xpath("//div[@id='checkout-cart']/div[1]")).contains("Success: You have modified your shopping cart!"), "Cart not modified");
        Assert.assertEquals(shoppingCartPage.macBookTotalErrorMessage(), "£737.45", "Total not matched");
        shoppingCartPage.clickOnCheckButton();
        Assert.assertEquals(checkOutPage.verifyCheckoutText(), "Checkout", "Invalid text displayed");
        //Assert.assertEquals(checkOutPage.verifyCustomerText(),"New Customer","Invalid text displayed");
        checkOutPage.clickOnGuestCheckOut();
        checkOutPage.enterFirstName("Shane");
        checkOutPage.enterLastName("Jhones");
        checkOutPage.enterEmail("shanejhones@example.com");
        checkOutPage.enterTelephone("98987654323");
        checkOutPage.enterAddress("3 Procter Close");
        checkOutPage.enterCity("Rugby");
        checkOutPage.enterPostcode("C2 4RT");
        checkOutPage.entercountry("222");
        checkOutPage.enterState("3603");
        checkOutPage.clickOnContinue();
        checkOutPage.addComments();
        checkOutPage.clickOnCheckBox();
        checkOutPage.checkOutContinueButton();

    }
}
