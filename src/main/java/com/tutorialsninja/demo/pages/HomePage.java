package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends Utility {

    By desktops = By.linkText("Desktops");
    By showAllDesktops = By.linkText("Show All Desktops");
    By laptopsAndNotebooks = By.linkText("Laptops & Notebooks");
    By showAllLaptopsAndNotebooks = By.linkText("Show All Laptops & Notebooks");
    By components = By.linkText("Components");
    By showAllComponents = By.linkText("Show All Components");
    By currency = By.xpath("//span[contains(text(),'Currency')]");
    By currencyList = By.xpath("//ul[@class = 'dropdown-menu']/li");
    By accountList = By.xpath("//div[@id='top-links']//li[contains(@class,'open')]/ul/li");
    By myAccount = By.xpath("//span[contains(text(),'My Account')]");




    public void mouseHoverOnDesktopsTabAndClick() {
        mouseHoverToElementAndClick(desktops);
    }

    public void selectShowAllDesktopsFromDropDown() {
        selectMenu(showAllDesktops, "Show All Desktops");
    }

    public void mouseHoverOnLaptopsAndNotebooksTabAndClick() {
        mouseHoverToElementAndClick(laptopsAndNotebooks);
    }

    public void selectShowAllLaptopsAndNotebooksFromDropDown() {
        selectMenu(showAllLaptopsAndNotebooks, "Show All Laptops & Notebooks");
    }

    public void mouseHoverOnComponentsTabAndClick() {
        mouseHoverToElementAndClick(components);
    }

    public void selectShowAllComponentsFromDropDown() {
        selectMenu(showAllComponents, "Show All Components");
    }

    public void changeCurrency(String currencyChoice) {
        clickOnElement(currency);
        List<WebElement> currencyList1 = driver.findElements(currencyList);
        for (WebElement e : currencyList1) {
            if (e.getText().equalsIgnoreCase(currencyChoice)) {
                e.click();
                break;
            }
        }
    }

    public void selectMyAccountOptions(String option) {
        List<WebElement> myAccountList = driver.findElements(accountList);
        try {
            for (WebElement options : myAccountList) {
                if (options.getText().equalsIgnoreCase(option)) {
                    options.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            myAccountList = driver.findElements(accountList);
        }
    }

    public void clickOnMyAccountLink(){
        clickOnElement(myAccount);
    }






}
