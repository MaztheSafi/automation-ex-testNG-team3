package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import com.academy.techcenture.utilities.ConfigReader;

import static com.academy.techcenture.utilities.ConfigReader.getProperty;

public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    public void verifyTitle() {
        String loginPageTitle = driver.getTitle();
        softAssert.assertEquals(loginPageTitle, "Web Orders Login");
    }

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    protected WebElement newUserSignup;

    @FindBy(xpath = "//label[text()='Title']") //Not sure//
    protected WebElement userPageTitle;

    @FindBy(xpath = "//input [@data-qa='signup-name']")
    protected WebElement userNameInput;

    @FindBy(xpath = "//input [@data-qa='signup-email']")
    protected WebElement userEmailInput;
    @FindBy(xpath = "// button[@data-qa='signup-button']")
    protected WebElement signupButton;

    @FindBy(xpath = "//b[text()='Enter Account Information']")
    protected WebElement verifyAcctInfoDisplayed;

    @FindBy(xpath = "//div[@id = 'uniform-id_gender1']")
    protected WebElement titleSelection;
    @FindBy(id = "//input[@id='name']")
    protected WebElement getUserNameInput;
    @FindBy(id = "//input[@id='email']")
    protected WebElement getUserEmailInput;

    @FindBy(id = "//input[@id='password']")
    protected WebElement userPasswordInput;
    @FindBy(xpath = "//select[@id='days']")
    protected WebElement userDobDay;
    @FindBy(xpath = "//select[@id='months']")
    protected WebElement userDobMonth;
    @FindBy(xpath = "//select[@id='years']")
    protected WebElement userDobYear;
    @FindBy(xpath = "//div[@id='uniform-newsletter']")
    protected WebElement newsLetterCheckbox;
    @FindBy(xpath = "//label[Text()='Receive special offers from our partners!']")//wrongElement
    protected WebElement receiveSpOffersCheckbox;

    @FindBy(xpath = "//[id = 'first_name']")
    protected WebElement firstNameInfo;

    @FindBy(xpath = "//[id =  'last_name']")
    protected WebElement lastNameInfo;

    @FindBy(xpath ="//[id =  'company']")
    protected WebElement companyInfo;

    @FindBy(xpath = "//[id =  'address1']")
    protected WebElement address1Info;

    @FindBy(xpath = "//[id =  'address2']")
    protected WebElement address2Info;

    @FindBy(xpath = "//[id =  'country']")
    protected WebElement countryInfo;

    @FindBy(xpath = "//[id =  'state']")
    protected WebElement stateInfo;

    @FindBy(xpath = "//[id =  'city']")
    protected WebElement cityInfo;

    @FindBy(xpath = "//[id =  'zipecode']")
    protected WebElement zipcodeInfo;

    @FindBy(xpath = "//[id =  'mobile_number']")
    protected WebElement mobile_numberInfo;

    @FindBy(xpath = "//button[data-qa = 'create-account']")
    protected WebElement createAccountBttn;

    @FindBy(xpath = "//h2[data-qa = 'account-created']")
    protected WebElement verifyAccountCreated;

    @FindBy(xpath = "//label[text()='Title']") //Not sure//
    protected WebElement newAccountCreatedPageTitle;

    @FindBy(xpath = "//a[data-qa = 'continue-button']")
    protected WebElement continueBttn;

    @FindBy(xpath = "//i[class ='fa fa-user']")//Need To Update
    protected WebElement loggedInAsUserIcon;

    @FindBy(xpath = "//a[href ='/delete_account']")
    protected WebElement deleteAccountBttn;

    @FindBy(xpath = "//b[data-qa ='account-deleted']")
    protected WebElement verifyAccountDeleted;

    @FindBy(xpath = "//p[text()='Email Address already exist!']")
    protected WebElement signUpError;

//-----------------Methods-----------------------------------------------------

    //---Case1----
    public void newUserRegistration() {
        loginSignUpIcon.click();
        newUserSignup.isDisplayed();
        userPageTitle.getText();
        userNameInput.sendKeys("username");
        userEmailInput.sendKeys(("email"));
        signupButton.click();


        titleSelection.click();
        getUserNameInput.sendKeys(getProperty("name"));
        getUserEmailInput.sendKeys(getProperty("email"));
        userPasswordInput.sendKeys(getProperty("password"));
        userDobDay.click();
        userDobMonth.click();
        userDobYear.click();
        newsLetterCheckbox.click();
        receiveSpOffersCheckbox.click();
        firstNameInfo.sendKeys();
        lastNameInfo.sendKeys();
        companyInfo.sendKeys();
        address1Info.sendKeys();
        address2Info.sendKeys();
        countryInfo.click();
        stateInfo.sendKeys();
        cityInfo.sendKeys();
        zipcodeInfo.sendKeys();
        mobile_numberInfo.sendKeys();
        createAccountBttn.click();
        verifyAccountCreated.isDisplayed();
        newAccountCreatedPageTitle.getText();
        continueBttn.click();
        loggedInAsUserIcon.isDisplayed();
        deleteAccountBttn.click();
        verifyAccountDeleted.isDisplayed();
        continueBttn.click();
    }


    //---TestCase5---
    public void RegisteredUserWithExistingEmail() {
        loginSignUpIcon.click();
        newUserSignup.isDisplayed();
        userPageTitle.getText();
        userNameInput.sendKeys(getProperty("username"));
        userEmailInput.sendKeys(getProperty("email"));
        signupButton.click();
        signUpError.isDisplayed();


    }
}



