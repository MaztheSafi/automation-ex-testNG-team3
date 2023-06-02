package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import static com.academy.techcenture.utilities.ConfigReader.getProperty;

public class LoginPage extends RegisterPage {
    public LoginPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    @FindBy(xpath = "//h2[text()='Login to your account']")
    protected WebElement loginToAccountVerification;

    @FindBy(xpath = "//input[placeholder='Email Address']")
    protected WebElement userEmailLoginInput;

    @FindBy(xpath = "//input[placeholder='Password']")
    protected WebElement userPasswordLoginInput;

    @FindBy(xpath = "//button[type='submit']")
    protected WebElement userLoginButtn;

    @FindBy(xpath = "//a[href='/logout']")
    protected WebElement loginError;

    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    protected WebElement logoutBttn;

//--------------------------------------Methods-------------------------------
//---TestCase2---
    public void LoginAndDelete(){
        loginSignUpIcon.click();
        loginToAccountVerification.isDisplayed();
        userEmailLoginInput.sendKeys(getProperty("email"));
        userPasswordLoginInput.sendKeys(getProperty("password"));
        userLoginButtn.click();
        loggedInAsUserIcon.isDisplayed();
        deleteAccountBttn.click();
        verifyAccountDeleted.isDisplayed();

    }

//---TestCase3---
    public void LoginNegative(){
        loginSignUpIcon.click();
        loginToAccountVerification.isDisplayed();
        userEmailLoginInput.sendKeys(getProperty("email"));
        userPasswordLoginInput.sendKeys(getProperty("wrongPassword"));
        userLoginButtn.click();
        loginError.isDisplayed();
    }

//---TestCase4---
    public void LoginAndLogOut(){
        loginSignUpIcon.click();
        loginToAccountVerification.isDisplayed();
        userEmailLoginInput.sendKeys(getProperty("email"));
        userPasswordLoginInput.sendKeys(getProperty("wrongPassword"));
        userLoginButtn.click();
        loggedInAsUserIcon.isDisplayed();
        logoutBttn.click();



    }
}

