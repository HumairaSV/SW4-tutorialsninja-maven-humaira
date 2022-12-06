package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.DesktopPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.LaptopsAndNotebooksPage;
import com.tutorialsninja.demo.pages.ShoppingCartPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartPageTest extends BaseTest {
    HomePage homePage = new HomePage();
    DesktopPage desktopPage = new DesktopPage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();


    @Test
    public void verifyProductAddedToShoppingCartSuccessFully(){
        homePage.changeCurrency("£ Pound Sterling");
        homePage.mouseHoverOnDesktopsTabAndClick();
        homePage.selectShowAllDesktopsFromDropDown();
        desktopPage.getProductNamesListByNameZToA("Name (Z - A)");
        desktopPage.selectHpProduct();
        Assert.assertEquals(desktopPage.getTextFromHpProduct(), "HP LP3065", "HP LP3065 Product not display");
        desktopPage.selectDeliveryDate("2023","November", "30");
        desktopPage.addProductToCart();
        Assert.assertEquals(desktopPage.getTextToConfirmProductAddedToCart(),"Success: You have added HP LP3065 to your shopping cart!\n" + "×","Product not added to cart");
        shoppingCartPage.clickOnShoppingCartLinkInSuccessMessage();
        Assert.assertTrue(shoppingCartPage.getPageNameShoppingCart().contains("Shopping Cart"), "Not navigated to Shopping Cart Page" );
        Assert.assertEquals(shoppingCartPage.confirmHpProductName(), "HP LP3065", "Product name does not match");
        Assert.assertTrue(shoppingCartPage.getTheDeliveryDate().contains("2023-11-30"), "Delivery date does not match");
        Assert.assertEquals(shoppingCartPage.getTextForTheModelOfSelectedProduct(), "Product 21", "Model does not match");
        Assert.assertEquals(shoppingCartPage.getTheTotalAmount(), "£74.73", "Total does not match");
    }


}
