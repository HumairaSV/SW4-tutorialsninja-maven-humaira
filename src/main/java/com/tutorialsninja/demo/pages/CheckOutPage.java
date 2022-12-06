package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;

public class CheckOutPage extends Utility {
    By checkOutButtonPageName= By.xpath("//h1[contains(text(),'Checkout')]");
    By newCustomerText = By.xpath("//h2[contains(text(),'New Customer')]");
    By guestCheckoutRadioButton = By.xpath("//input[@value= 'guest']");
    By continueButton = By.id("button-account");
    By firstName = By.cssSelector("#input-payment-firstname");
    By lastName = By.cssSelector("#input-payment-lastname");
    By email = By.cssSelector("#input-payment-email");
    By phoneNo = By.cssSelector("#input-payment-telephone");
    By addressLn1 = By.cssSelector("#input-payment-address-1");
    By cityField = By.cssSelector("#input-payment-city");
    By postCodeField = By.cssSelector("#input-payment-postcode");
    By countryField = By.xpath("//select[@id='input-payment-country']");
    By regionField = By.xpath("//select[@id='input-payment-zone']");
    By continueGuestButton = By.cssSelector("#button-guest");
    By textAreaCommentBox = By.xpath("//textarea[@name = 'comment']");
    By tAndCsCheckBox = By.xpath("//input[@type= 'checkbox']");
    By continueButtonToPay = By.cssSelector("#button-payment-method");
    By paymentWarningMessage = By.xpath("//div[@class='alert alert-danger alert-dismissible']");


    public String getPageNameCheckout(){
        return getTextFromElement(checkOutButtonPageName);
    }

    public String verifyNewCustomerText(){
        return getTextFromElement(newCustomerText);
    }

    public void clickOnGuestCheckoutRadioButton(){
        clickOnElement(guestCheckoutRadioButton);
    }

    public void clickOnNewCustomerContinueButton(){
        clickOnElement(continueButton);
    }

    public void enterFirstName(String text){
        sendTextToElement(firstName, text);
    }

    public void enterLastName(String text){

        sendTextToElement(lastName, text);
    }

    public void enterEmail(String emailId){
        sendTextToElement(email,emailId);
    }

    public void enterPhoneNo(String phNo){
        sendTextToElement(phoneNo,phNo);
    }

    public void enterAddressLn1(String address1){
        sendTextToElement(addressLn1, address1);
    }

    public void enterCity(String cityName){
        sendTextToElement(cityField, cityName);
    }

    public void enterPostCode(String postcodeText){
        sendTextToElement(postCodeField, postcodeText);
    }

    public void selectCountryFromDropDown(String countryName){
        selectByVisibleTextFromDropDown(countryField, countryName);
    }

    public void selectRegionFromDropDown(String regionName){
        selectByVisibleTextFromDropDown(regionField, regionName);
    }

    public void clickOnContinueGuestButton(){
        clickOnElement(continueGuestButton);
    }

    public void addCommentsAboutYourOrder(String orderText){
        sendTextToElement(textAreaCommentBox, orderText);
    }

    public void clickOnTermsAndConditionsCheckBox(){
        clickOnElement(tAndCsCheckBox);
    }

    public void clickOnContinueButtonToProceedToPayment(){
        clickOnElement(continueButtonToPay);
    }

    public String getPaymentWarningMessage(){
        return getTextFromElement(paymentWarningMessage);
    }



}
