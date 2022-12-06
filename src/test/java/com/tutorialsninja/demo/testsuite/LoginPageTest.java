package com.tutorialsninja.demo.testsuite;

import com.tutorialsninja.demo.pages.AccountPage;
import com.tutorialsninja.demo.pages.HomePage;
import com.tutorialsninja.demo.pages.LoginPage;
import com.tutorialsninja.demo.pages.RegisterPage;
import com.tutorialsninja.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    AccountPage accountPage = new AccountPage();

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Login");
        Assert.assertEquals(loginPage.verifyLoginPageText(), "Returning Customer", "Not navigated to Login Page" );
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //first registering new account to check login functionality
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Register");
        registerPage.enterFirstName("Testinghumsi2");
        registerPage.enterLastName("Sareshw");
        registerPage.enterEmailAddress("Testinghumsi2@gmail.com");
        registerPage.enterTelephoneNo("0789458585");
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

        //testing the login functionality
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Login");
        loginPage.enterEmailAddress("Testinghumsi2@gmail.com");
        loginPage.enterPassword("Password987");
        loginPage.clickOnLoginButton();
        Assert.assertEquals(accountPage.verifyMyAccountPageName(), "My Account", "Not navigated to My account page");
        homePage.clickOnMyAccountLink();
        homePage.selectMyAccountOptions("Logout");
        Assert.assertEquals(accountPage.verifyAccountLogoutText(), "Account Logout", "Not logged out of the account");
        accountPage.clickOnContinueToNavigateToHomepage();




    }

}
