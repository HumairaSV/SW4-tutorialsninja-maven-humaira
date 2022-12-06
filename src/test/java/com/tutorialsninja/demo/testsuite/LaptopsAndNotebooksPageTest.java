package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;

public class LaptopsAndNotebooksPageTest extends BaseTest {
    HomePage homePage = new HomePage();
    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        homePage.mouseHoverOnLaptopsAndNotebooksTabAndClick();
        homePage.selectShowAllLaptopsAndNotebooksFromDropDown();
        Assert.assertEquals(laptopsAndNotebooksPage.getPageName(), "Laptops & Notebooks", "Not navigated to Laptops & Notebooks page");

    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){
        homePage.mouseHoverOnLaptopsAndNotebooksTabAndClick();
        homePage.selectShowAllLaptopsAndNotebooksFromDropDown();
        Collections.sort(laptopsAndNotebooksPage.getProductNamesListedUnderLaptopsAndNotebooks(), Collections.reverseOrder());
        Assert.assertEquals(laptopsAndNotebooksPage.getProductNamesByPrice("Price (High > Low)"), laptopsAndNotebooksPage.getProductNamesListedUnderLaptopsAndNotebooks(),"Product not sorted by price High to Low");
    }



}
