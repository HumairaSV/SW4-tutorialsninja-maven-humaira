package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {

    By laptopsAndNotebooksText = By.xpath("//h2[contains(text(),'Laptops & Notebooks')]");
    By laptopsAndNotebooksPageSortList = By.xpath("//p[@class ='price']");
    By sortField = By.id("input-sort");
    By productMacBook = By.linkText("MacBook");
    By productNameMacBook = By.xpath("//h1[contains(text(),'MacBook')]");
    By addToCartButton = By.xpath("//button[@id='button-cart']");
    By successPopUpMessage = By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible");


    public String getPageName() {
        return getTextFromElement(laptopsAndNotebooksText);
    }

    public ArrayList getProductNamesListedUnderLaptopsAndNotebooks() {
        List<WebElement> products = driver.findElements(laptopsAndNotebooksPageSortList);
        List<Double> originalProductsPrice = new ArrayList<>();
        for (WebElement e : products) {
            System.out.println(e.getText());
            String[] arr = e.getText().split("Ex Tax:");
            originalProductsPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
        }
        return (ArrayList) originalProductsPrice;

    }
//"Price (High > Low)"
    public ArrayList getProductNamesByPrice(String priceSort) {
        selectByVisibleTextFromDropDown(sortField,priceSort );
        // After filter Price (High > Low) Get all the products name and stored into array list
        List<WebElement> products = driver.findElements(laptopsAndNotebooksPageSortList);
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement e : products) {
            String[] arr = e.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",","")));
        }
        return afterSortByPrice;
    }

    public void selectSortByPrice(String sortPrice){
        selectByVisibleTextFromDropDown(sortField,sortPrice );
    }

    public void clickOnProductMacBook(){
        clickOnElement(productMacBook);
    }

    public String getProductName() {
        return getTextFromElement(productNameMacBook);
    }

    public void clickOnAddToCartButton(){
        clickOnElement(addToCartButton);
    }

    public String getTextToConfirmProductAddedToCart(){
        return getTextFromElement(successPopUpMessage);
    }





}
