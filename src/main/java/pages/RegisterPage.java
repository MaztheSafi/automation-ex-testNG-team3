package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import utilities.ConfigReader;

public class RegisterPage {

        protected static WebDriver driver;
        protected SoftAssert softAssert;


        public RegisterPage(WebDriver driver , SoftAssert softAssert){
            this.driver = driver;
            this.softAssert = softAssert;
            PageFactory.initElements(this.driver, this);
        }


        public void verifyTitle(){
            String loginPageTitle = driver.getTitle();
            softAssert.assertEquals(loginPageTitle, "Web Orders Login");
        }
        @FindBy(className = "fa fa-lock")
        protected WebElement registerButton;


        @FindBy(xpath= "//h2[text()='New User Signup!']")
        protected WebElement newUserSignup;

        @FindBy(xpath = "// input [@data-qa='signup-name']")
        protected WebElement userNameInput;

        @FindBy(xpath = "// input [@data-qa='signup-email']")
        protected WebElement userEmailInput;
        @FindBy(xpath = "// button[@data-qa='signup-button']")
        protected WebElement signupButton;

        @FindBy(xpath = "//b[text()='Enter Account Information']")
        protected WebElement verifyAcctInfo;

        @FindBy(xpath = "//label[text()='Title']")
        protected WebElement userPageTitle;
        @FindBy(id = "//input[@id='name']")
        protected WebElement getUserNameInput;
        @FindBy(id = "//input[@id='email']")
        protected WebElement getUserEmailInput;
        @FindBy(id = "//input[@id='password']")
        protected WebElement userPasswordInput;

        @FindBy(id = "//select[@id='days']")
        protected WebElement userDobDay;
        @FindBy(id = "//select[@id='months']")
        protected WebElement userDobMonth;
        @FindBy(id = "//select[@id='years']")
        protected WebElement userDobYear;

        @FindBy(className = "//div[@class='checkbox']")
        protected WebElement newsLetterCheckbox;




    public void navigateToUrl(){
            driver.get(ConfigReader.getProperty("url"));
        }

        public void verifyRegisterPage(){
            registerButton.click();
            softAssert.assertTrue(userNameInput.isDisplayed());
            signupButton.click();

        }


        public void personalInformation(){

            userNameInput.sendKeys("username");
            userEmailInput.sendKeys(("email"));
            softAssert.assertTrue(userPageTitle.isDisplayed());
            getUserNameInput.sendKeys("name");
            getUserEmailInput.sendKeys("email");
            userPasswordInput.sendKeys("password");

            userDobDay.click();

            userDobMonth.click();

            userDobYear.click();

            newsLetterCheckbox.click();
        }


        public void verifyPageHeader(){
            softAssert.assertTrue(verifyAcctInfo.isDisplayed());
        }






    }
