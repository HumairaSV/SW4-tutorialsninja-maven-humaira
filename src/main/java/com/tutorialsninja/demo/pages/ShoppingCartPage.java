package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;

public class ShoppingCartPage extends Utility {

    public String product;
    By shoppingCartPage  = By.xpath("//div[@id='content']//h1");
    By hPProductNameInShoppingCart = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a");
    By deliveryDate = By.xpath("//small[contains(text(),'Delivery Date: 2023-11-30')]");
    By model = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[3]");
    By totalAmount = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]");
    By shoppingCartLink = By.xpath("//a[contains(text(),'shopping cart')]");
    By quantityField = By.xpath("//input[contains(@name, 'quantity')]");
    By updateButton = By.xpath("//button[contains(@data-original-title, 'Update')]");
    By cartUpdatedMessage = By.xpath("//div[@id='checkout-cart']/div[1]");
    By macBookProductNameInShoppingCart = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a");
    By checkOutButton = By.xpath("//a[contains(text(),'Checkout')]");


    public String getPageNameShoppingCart(){
        return getTextFromElement(shoppingCartPage);
    }

    public void clickOnShoppingCartLinkInSuccessMessage(){
        clickOnElement(shoppingCartLink);
    }

    public String confirmHpProductName(){
        return getTextFromElement(hPProductNameInShoppingCart);
    }

    public String getTheDeliveryDate(){
        return getTextFromElement(deliveryDate);
    }

    public String getTextForTheModelOfSelectedProduct(){
        return getTextFromElement(model);
    }

    public String getTheTotalAmount(){
        return getTextFromElement(totalAmount);
    }

    public String confirmMacBkProductName(){
        return getTextFromElement(macBookProductNameInShoppingCart);
    }

    public void updateQuantityToTwo(String qty){
        driver.findElement(quantityField).clear();
        sendTextToElement(quantityField, qty);
    }

    public void clickToUpdateQty(){
        clickOnElement(updateButton);
    }

    public String confirmQtyUpdatedMessage(){
        return getTextFromElement(cartUpdatedMessage);
    }

    public void clickOnCheckoutButton(){
        clickOnElement(checkOutButton);
    }





}



