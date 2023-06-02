package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class VerifyTestCasesPage extends BasePage{
    public VerifyTestCasesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//b[contains(text(),'Test Cases')]")
    private WebElement testCasesText;


    public void verifyUserIsOnTestCasesPage(){
        Assert.assertTrue(testCasesText.isDisplayed(), "user is not in test cases page");
    }




}
