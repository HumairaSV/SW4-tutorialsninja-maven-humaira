package com.tutorialsninja.demo.testsuite;


import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

public class DesktopPageTest extends BaseTest {
    HomePage homePage = new HomePage();
    DesktopPage desktopPage = new DesktopPage();

    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        homePage.mouseHoverOnDesktopsTabAndClick();
        homePage.selectShowAllDesktopsFromDropDown();
        Assert.assertEquals(desktopPage.getPageName(), "Desktops","Not navigated to the Desktops page");
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder(){
        homePage.mouseHoverOnDesktopsTabAndClick();
        homePage.selectShowAllDesktopsFromDropDown();
        desktopPage.getProductNamesListedUnderDesktops();
        Collections.reverse(desktopPage.getProductNamesListedUnderDesktops());
        Assert.assertEquals(desktopPage.getProductNamesListByNameZToA("Name (Z - A)"), desktopPage.getProductNamesListedUnderDesktops(), "Products not sorted by Z to A");
    }

}

