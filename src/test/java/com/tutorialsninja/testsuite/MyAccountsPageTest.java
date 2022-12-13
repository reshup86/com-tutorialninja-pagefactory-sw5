package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.*;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyAccountsPageTest extends BaseTest {

    HomePage homePage;
    RegisterPage registerPage;
    LoginPage loginPage;
    SuccessPage sucessPage;
    MyAccountPage myAccountPage;
    LogOutPage logOutPage;


    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        registerPage = new RegisterPage();
        loginPage = new LoginPage();
        sucessPage = new SuccessPage();
        myAccountPage = new MyAccountPage();
        logOutPage = new LogOutPage();

    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Register");
        Assert.assertEquals(registerPage.verifyRegisterAccount(), "Register Account", "Text is not displayed");

    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Login");
        Assert.assertEquals(loginPage.verifyReturningCustomer(), "Returning Customer", "Text isnot display");
    }

    @Test(groups = "regression")
    public void verifyThatUserRegisterAccountSuccessfully() {
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Register");
        registerPage.enterFirstName("John");
        registerPage.enterLastName("Wong");
        registerPage.enterEmail("jo@example.com");
        registerPage.enterTelephone("235665656");
        registerPage.enterPassword("test123");
        registerPage.enterConformPassword("test123");
        registerPage.clickOnSubcribe();
        registerPage.clickOnAgree();
        registerPage.clickOnContinue();
        Assert.assertEquals(sucessPage.verifyYourAccountMessage(), "Your Account Has Been Created!", "Text is not display");
        sucessPage.clickOnSucessContinueButton();
        myAccountPage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Logout");
        Assert.assertEquals(logOutPage.verifyAccountLogoutText(), "Account Logout", "Text is not Display");
        logOutPage.clickOnContinue();
    }

    @Test(groups = "regression")
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException{
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Login");
        loginPage.enterEmailId("prime123@gmail.com");
        loginPage.enterPassword("test123");
        loginPage.clickOnLoginButton();
        Thread.sleep(2000);
        homePage.clickOnMyAccount();
        homePage.selectMyAccountOptions("Logout");
        Assert.assertEquals(logOutPage.verifyAccountLogoutText(), "Account Logout", "Text is not Display");
        logOutPage.clickOnContinue();

    }
}
