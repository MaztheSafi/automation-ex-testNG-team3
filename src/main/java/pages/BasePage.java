package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public abstract class BasePage {


    protected static WebDriver driver;
    protected SoftAssert softAssert;


    public BasePage(WebDriver driver , SoftAssert softAssert){
        this.driver = driver;
        this.softAssert = softAssert;
        PageFactory.initElements(this.driver, this);
    }



















}
