package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopPage extends Utility {

    By desktopsText = By.xpath("//h2[contains(text(),'Desktops')]");
    By desktopPageSortList = By.xpath("//h4/a");
    By selectSortField = By.xpath("//select[@id='input-sort']");
    By hpProduct = By.xpath("//a[contains(text(),'HP LP3065')]");
    By hpProductText = By.xpath("//h1[contains(text(),'HP LP3065')]");
    By calendarIcon = By.xpath("//div[@class = 'input-group date']//button");
    By monthYearTag = By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']");
    By nextArrow = By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']");
    By selectAllDates = By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']");
    By addToCart =By.xpath("//button[@id='button-cart']");
    By productAddedToShoppingCartMessage = By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible");




    public String getPageName() {
        return getTextFromElement(desktopsText);
    }

    public ArrayList getProductNamesListedUnderDesktops() {
        List<WebElement> products = driver.findElements(desktopPageSortList);
        ArrayList<String> originalProductName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductName.add(e.getText());
            //sort arraylist by reverse order
        }
        return originalProductName;

    }

    public ArrayList getProductNamesListByNameZToA(String text) {
        selectByVisibleTextFromDropDown(selectSortField, text);
        //get all the product names sorted by Z to A and store into array list
        List<WebElement> products = driver.findElements(desktopPageSortList);
        ArrayList<String> afterSortByZtoAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZtoAProductsName.add(e.getText());
        }
        return afterSortByZtoAProductsName;
    }

    public void selectHpProduct(){
        clickOnElement(hpProduct);
    }

    public String getTextFromHpProduct(){
        return getTextFromElement(hpProductText);
    }

    public void selectDeliveryDate(String year, String month, String date){

        clickOnElement(calendarIcon);
        while (true) {
            String monthAndYear = driver.findElement(monthYearTag).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextArrow);
            }
        }
        List<WebElement> allDates = driver.findElements(selectAllDates);
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }

    public void addProductToCart(){
        clickOnElement(addToCart);
    }

    public String getTextToConfirmProductAddedToCart(){
        return getTextFromElement(productAddedToShoppingCartMessage);
    }


}