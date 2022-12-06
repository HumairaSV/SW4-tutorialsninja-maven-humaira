package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.AccountPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.RegisterPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountPageTest extends BaseTest {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();
    AccountPage accountPage = new AccountPage();

    @Test
    public void verifyThatUserRegisterAccountSuccessfully(){
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Register");
        registerPage.enterFirstName("Testinghv"+getAlphaNumericString(2));
        registerPage.enterLastName("Automode"+getAlphaNumericString(2));
        registerPage.enterEmailAddress("Testinghv"+getAlphaNumericString(2)+"@gmail.com");
        registerPage.enterTelephoneNo("07552141254");
        registerPage.enterPassword("Password987");
        registerPage.enterConfirmPassword("Password987");
        registerPage.selectRadioButtonToSubscribe("Yes");
        registerPage.clickOnPrivacyPolicyCheckbox();
        registerPage.clickOnContinueToRegister();
        Assert.assertEquals(accountPage.verifyAccountCreatedText(), "Your Account Has Been Created!", "Account created text not displayed");
        accountPage.clickOnContinueToNavigateToAccount();
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Logout");
        Assert.assertEquals(accountPage.verifyAccountLogoutText(), "Account Logout", "Not logged out of the account");
        accountPage.clickOnContinueToNavigateToHomepage();
    }
}
