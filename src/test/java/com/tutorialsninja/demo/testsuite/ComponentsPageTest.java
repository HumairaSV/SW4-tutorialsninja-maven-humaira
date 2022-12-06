package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.ComponentsPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComponentsPageTest extends BaseTest {

    HomePage homePage = new HomePage();
    ComponentsPage componentsPage = new ComponentsPage();

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        homePage.mouseHoverOnComponentsTabAndClick();
        homePage.selectShowAllComponentsFromDropDown();
        Assert.assertEquals(componentsPage.getPageName(), "Components", "Not navigated to the Components Page");
    }
}
