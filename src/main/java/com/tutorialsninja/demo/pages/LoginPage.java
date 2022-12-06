package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage extends Utility {

    By returningCustomer = By.xpath("//h2[contains(text(),'Returning Customer')]");
    By emailAddressField = By.id("input-email");
    By passwordField = By.id("input-password");
    By loginButton = By.xpath("//form[contains(@action,'login')]//input[@type='submit']");


    public String verifyLoginPageText(){
        return getTextFromElement(returningCustomer);
    }

    public void enterEmailAddress(String text){
        sendTextToElement(emailAddressField, text);
    }
    public void enterPassword(String text){
        sendTextToElement(passwordField, text);
    }
    public void clickOnLoginButton(){
        clickOnElement(loginButton);
    }
}




