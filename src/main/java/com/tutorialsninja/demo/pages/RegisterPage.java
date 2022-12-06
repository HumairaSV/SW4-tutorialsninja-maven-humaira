package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class RegisterPage extends Utility {
    By registerAccount = By.xpath("//h1[contains(text(),'Register Account')]");
    By firstNameField = By.id("input-firstname");
    By lastNameField = By.id("input-lastname");
    By emailField = By.id("input-email");
    By phoneNoField = By.id("input-telephone");
    By passwordField = By.id("input-password");
    By confirmPasswordField = By.id("input-confirm");
    By radioButtonField = By.xpath("//fieldset[3]//input");
    By privacyPolicyCheckBox = By.xpath("//div[@class = 'buttons']//input[@name='agree']");
    By continueToRegister = By.xpath("//div[@class = 'buttons']//input[@value='Continue']");



    public String verifyTextRegisterAccount(){
        return getTextFromElement(registerAccount);
    }

    public void enterFirstName(String text){
        sendTextToElement(firstNameField, text);
    }

    public void enterLastName(String text){
        sendTextToElement(lastNameField, text);
    }

    public void enterEmailAddress(String text){
        sendTextToElement(emailField, text);
    }

    public void enterTelephoneNo(String text){
        sendTextToElement(phoneNoField, text);
    }

    public void enterPassword(String text){
        sendTextToElement(passwordField, text);
    }

    public void enterConfirmPassword(String text){
        sendTextToElement(confirmPasswordField, text);
    }

    public void selectRadioButtonToSubscribe(String text){
        List<WebElement> radioButtons = driver.findElements(radioButtonField);
        for (WebElement e : radioButtons) {
            if (e.getText().equals(text)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnPrivacyPolicyCheckbox(){
        clickOnElement(privacyPolicyCheckBox);
    }

    public void clickOnContinueToRegister(){
        clickOnElement(continueToRegister);
    }



}
