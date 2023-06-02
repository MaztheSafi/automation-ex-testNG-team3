package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.ConfigReader;

import static com.sun.java.swing.action.ActionManager.utilities;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[text()=' Signup / Login']")
    private WebElement singInSignUpButton;
    @FindBy(xpath = "//a[text()=' Logged in as ']")
    private WebElement loginAsUserText;
    @FindBy(xpath = "//a[text()=' Contact us']")
    private WebElement contactUsBtn;
    @FindBy(xpath = " //a[text()=' Test Cases']")
    private WebElement testCasesBtn;
    @FindBy(xpath = "//a[text()=' Products']")
    private WebElement productsBtn;
    @FindBy(xpath = "//h2[text()='Subscription']")
    private WebElement subscriptionText;
    @FindBy(id = "susbscribe_email")
    private WebElement subscriptionEmailInput;
    @FindBy(id = "subscribe")
    private WebElement subscribeBtn;
    @FindBy(xpath = "//a[text()=' Cart']")
    private WebElement cartBtn;
    @FindBy(xpath = "(//a[text()='View Product'])[1]/i")
    private WebElement viewFirstProductBtn;
    @FindBy(xpath = "(//a[text()='Add to cart'])[1]")
    private WebElement addToCartBtn;
    @FindBy(xpath = "//button[text()='Continue Shopping']")
    private WebElement continueBtn;
    @FindBy(xpath = "//div[@id='accordian']")
    private WebElement categoriesBox;
    @FindBy(xpath = "//a[contains(.,'Women')]")
    private WebElement womenCategoryBtn;
    @FindBy(xpath = "//div[@id='Women']//div//ul//li//a[contains(.,'Dress')]")
    private WebElement dressBtnUnderWomen;
    @FindBy(xpath = "//h2[text()='Women - Dress Products']")
    private WebElement womanCategoryDisplayText;
    @FindBy(xpath = "//a[contains(.,'Men')]")
    private WebElement menCategoryBtn;
    @FindBy(xpath = "//div[@id='Men']//div//ul//li//a[contains(.,'Jeans ')]")
    private WebElement jeansBtnUnderMen;
    @FindBy(xpath = "//h2[text()='Men - Jeans Products']")
    private WebElement menCategoryDisplayText;
    @FindBy(xpath = "//div[@class='brands_products']")
    private WebElement brands;
    @FindBy(xpath = "//a[text()='Polo']")
    private WebElement poloBrandBtn;


    public void clickOnSingInSignUpBtn(){
        singInSignUpButton.click();
    }
    public void verifyLogInAsUser(){
        Assert.assertTrue(loginAsUserText.getText().trim().equalsIgnoreCase("Logged in as "+ ConfigReader.getProperty("name")), "Log in as user not visible");
    }
    public void verifyUserIsOnAHomePage(){
        Assert.assertTrue(driver.getTitle().trim().equalsIgnoreCase("Automation Exercise"));
    }
    public void clickOnContactUsBtn(){
        contactUsBtn.click();
    }
    public void clickTestCasesBtn(){
        testCasesBtn.click();
    }
    public void clickOnProductBtn(){
        productsBtn.click();
    }

    public void scrollDownToFooter(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
    }
    public void verifySubscriptionTextVisible(){
        Assert.assertTrue(subscriptionText.isDisplayed(), "Subscription text is not visible");
    }
    public void enterEmailToSubscribe(String str) throws InterruptedException {
        subscriptionEmailInput.sendKeys(str);
        Thread.sleep(3000);
        subscribeBtn.click();
    }
    public void clickOnCartBtn(){
        cartBtn.click();
    }
    public void clickOnViewProduct(){
        viewFirstProductBtn.click();
    }
    public void addToCart(){
        addToCartBtn.click();
    }
    public void clickContinueShoppingBtn(){
        continueBtn.click();
    }
    public void scrollUpToHeader(){
        WebElement element = driver.findElement(By.tagName("header"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)", "");
    }
    public void verifyVisibilityOfCategoryMenu(){
        Assert.assertTrue(categoriesBox.isDisplayed(), "Category Box is not visible");
    }
    public void clickOnWomenCategory(){
        womenCategoryBtn.click();
    }
    public void clickOnDressUnderWomen(){
        dressBtnUnderWomen.click();
    }
    public void verifyWomenCategoryIsDisplay(){
        Assert.assertTrue(womanCategoryDisplayText.isDisplayed(), "Woman category is not display");
    }
    public void clickOnMenCategory() {
        menCategoryBtn.click();
    }
    public void clickOnJeanUnderMenCategory(){
        jeansBtnUnderMen.click();
    }
    public void verifyMenCategoryIsDisplay(){
        Assert.assertTrue(menCategoryDisplayText.isDisplayed(), "Men category is not display");
    }
    public void verifyBrandsAreVisible(){
        Assert.assertTrue(brands.isDisplayed(), "Brand is not displayed");
    }
    public void clickOnPoloBrand(){
        poloBrandBtn.click();
    }



}