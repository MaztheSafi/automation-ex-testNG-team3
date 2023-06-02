package com.academy.techcenture.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

public class ContactUSPage extends BasePage {

    public ContactUSPage(WebDriver driver, SoftAssert softAssert) {
        super(driver, softAssert);
    }

    @FindBy(xpath = "//h2[text()='Get In Touch']")
    protected WebElement getInTouchDisplayed;

    @FindBy(xpath = "//input[name='name']")
    protected WebElement contactUsNameInput;

    @FindBy(xpath = "//input[type='email']")
    protected WebElement contactUsEmailInput;

    @FindBy(xpath = "//input[name='subject']")
    protected WebElement contactUsSubjectInput;

    @FindBy(xpath = "//textarea[name='message']")
    protected WebElement contactUsMessageInput;

    @FindBy(xpath = "//input[name='upload_file']")
    protected WebElement contactUsUploadFileInput;

    @FindBy(xpath = "//input[data-qa='submit-button']")
    protected WebElement contactUsSubmitButtn;

//Click OK button Not sure How To do it!!!!---
    @FindBy(xpath = "//div[text()='Success! Your details have been submitted successfully.']")
    protected WebElement contactUsSuccessSubmitMessage;

    @FindBy(xpath = "//i[class='fa fa-angle-double-left']")
    protected WebElement contactUsSuccessHomeButtn;






//--------------------------------------Methods-------------------------------
//---TestCase6---
    public void ContactUs(){
        contactIcon.click();
        getInTouchDisplayed.isDisplayed();
        contactUsNameInput.sendKeys();
        contactUsEmailInput.sendKeys();
        contactUsMessageInput.sendKeys();
        contactUsUploadFileInput.click();
        contactUsSubmitButtn.click();
        contactUsSuccessSubmitMessage.isDisplayed();
        contactUsSuccessHomeButtn.click();
        navigateToHomePage();

    }

}
