package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class LoginPage {

    protected static WebDriver driver;
    protected SoftAssert softAssert;


    public LoginPage(WebDriver driver , SoftAssert softAssert){
        this.driver = driver;
        this.softAssert = softAssert;
        PageFactory.initElements(this.driver, this);
    }









}

