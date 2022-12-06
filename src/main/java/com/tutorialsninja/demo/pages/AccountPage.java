package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;

public class AccountPage extends Utility {

    By accountCreatedText = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");
    By continueButtonAcctCreated = By.xpath("//a[contains(text(),'Continue')]");
    By accountLogoutText = By.xpath("//h1[contains(text(),'Account Logout')]");
    By continueToHomepage = By.xpath("//a[contains(text(),'Continue')]");
    By myAccountPage = By.xpath("//h2[contains(text(),'My Account')]");


    public String verifyAccountCreatedText(){
        return getTextFromElement(accountCreatedText);
    }

    public void clickOnContinueToNavigateToAccount(){
        clickOnElement(continueButtonAcctCreated);
    }

    public String verifyAccountLogoutText(){
        return getTextFromElement(accountLogoutText);

    }

    public void clickOnContinueToNavigateToHomepage(){
        clickOnElement(continueToHomepage);
    }

    public String verifyMyAccountPageName(){
        return getTextFromElement(myAccountPage);
    }



}
