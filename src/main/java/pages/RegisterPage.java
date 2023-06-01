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

        @FindBy ()



        public void navigateToUrl(){
            driver.get(ConfigReader.getProperty("url"));
        }

        public void verifyRegisterPage(){
            registerButton.click();
            softAssert.assertTrue(newUserSignup);


            softAssert.assertTrue(loginButton.isEnabled());
            loginButton.click();
        }









    }
