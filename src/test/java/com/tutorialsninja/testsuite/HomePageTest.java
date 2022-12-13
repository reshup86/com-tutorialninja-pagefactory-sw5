package com.tutorialsninja.testsuite;

import com.tutorialsninja.pages.ComponentsPage;
import com.tutorialsninja.pages.DesktopPage;
import com.tutorialsninja.pages.HomePage;
import com.tutorialsninja.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    HomePage homePage;
    DesktopPage deskTopPage;
    LaptopsAndNotebooksPage laptopsAndNoteBooksPage;
    ComponentsPage componentsPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        deskTopPage = new DesktopPage();
        laptopsAndNoteBooksPage = new LaptopsAndNotebooksPage();
        componentsPage = new ComponentsPage();
    }


    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homePage.mouseHoverToDesktopAndClick();
        homePage.selectMenu("Show All DeskTops");
        String expectedDeskTopText = "Desktops";
        Assert.assertEquals(deskTopPage.navigateToDesktopErrorMessage(), expectedDeskTopText, "DeskTops isnot displayed");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        homePage.mouseHoverToLaptopsNotebooksAndClick();
        homePage.selectMenu("Show All Laptops & Notebooks");
        String expectedLaptopsandNotebooksText = "Laptops & Notebooks";
        Assert.assertEquals(laptopsAndNoteBooksPage.navigateToLaptopsNotebooksErrorMessage(), expectedLaptopsandNotebooksText, "Text isnot display");
    }

    @Test(groups = "regression")
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        homePage.mouseHoverToComponentsAndClick();
        homePage.selectMenu("Show All Components");
        Assert.assertEquals(componentsPage.navigateToComponentsErrorMessage(), "Components", "Text is not display");
    }
}
