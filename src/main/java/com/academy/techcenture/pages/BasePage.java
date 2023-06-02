package com.academy.techcenture.pages;

import com.academy.techcenture.utilities.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public abstract class BasePage {


    protected static WebDriver driver;
    protected SoftAssert softAssert;


    public BasePage(WebDriver driver , SoftAssert softAssert){
        this.driver = driver;
        this.softAssert = softAssert;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//img[alt='Website for automation practice']")
    protected WebElement logoImage;


    @FindBy(className = "fa fa-home")
    protected WebElement homeIcon;

    @FindBy(xpath = "//a[href='/products']")
    protected WebElement productIcon;

    @FindBy(xpath = "//a[href='/view_cart']")
    protected WebElement cartIcon;

    @FindBy(xpath = "//a[href='/login']")
    protected WebElement loginSignUpIcon;

    @FindBy(xpath = "//a[href='/test_cases']")
    protected WebElement casesIcon;

    @FindBy(xpath = "//a[href='/api_list']")
    protected WebElement apiIcon;

    @FindBy(className = "fa fa-youtube-play")
    protected WebElement videoIcon;

    @FindBy(xpath = "//a[href='/contact_us']")
    protected WebElement contactIcon;

//----------------------------------------Methods------------------------

//Navigate to the url---Home Page------
public void navigateToHomePage(){
    driver.get(ConfigReader.getProperty("url"));
    softAssert.assertTrue(homeIcon.isDisplayed());
    softAssert.assertTrue(logoImage.getText().equals("Website for automation practice"));
}

    public void ProductsLink() {
        softAssert.assertTrue(productIcon.isDisplayed());

    }

    public void CartLink() {
        softAssert.assertTrue(cartIcon.isDisplayed());

    }
    public void loginSignUpLink() {
        softAssert.assertTrue(loginSignUpIcon.isDisplayed());

    }
    public void CasesLink() {
        softAssert.assertTrue(casesIcon.isDisplayed());

    }
    public void APILink() {
        softAssert.assertTrue(apiIcon.isDisplayed());

    }
    public void VideosLink() {
        softAssert.assertTrue(videoIcon.isDisplayed());

    }

    public void ContactLink() {
        softAssert.assertTrue(contactIcon.isDisplayed());

    }

 }
