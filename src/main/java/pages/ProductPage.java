package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.ConfigReader;

import java.util.List;

public class ProductPage extends BasePage{
    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='features_items']")
    private WebElement allProducts;
    @FindBy(xpath = "(//div[@class='features_items']/div/following-sibling::div)[1]/div/div/following-sibling::div/ul/li/a/i")
    private WebElement firstProduct;
    @FindBy(id = "search_product")
    private WebElement searchProductInput;
    @FindBy(id = "submit_search")
    private WebElement submitSearchBtn;
    @FindBy(xpath = "//p[contains(text(),'Top')]")
    private List<WebElement> searchedProducts;
    @FindBy(xpath = "(//div[@class='features_items']/div)[1]")
    private WebElement firstItem;
    @FindBy(xpath = "//a[@data-product-id='1' and text()='Add to cart']/i")
    private WebElement addToCartBtn;
    @FindBy(xpath = "//a[@data-product-id='2' and text()='Add to cart']/i")
    private WebElement addToCarSecondItemBtn;
    @FindBy(xpath = "//button[text()='Continue Shopping']")
    private WebElement continueShoppingBtn;
    @FindBy(xpath = "//a/u[text()='View Cart']")
    private WebElement viewCartBtn;
    @FindBy(xpath = "//a[@data-product-id='1']/../h2")
    private WebElement firstItemPrice;
    @FindBy(xpath = "//a[@data-product-id='2']/../h2")
    private WebElement secondItemPrice;
    @FindBy(xpath = "//h2[text()='Searched Products']")
    private WebElement searchProductsText;
    @FindBy(xpath = "//p[contains(text(),'Dress')]")
    private List<WebElement> productsDresses;



    public void verifyUserOnAProductPage(){
        Assert.assertTrue(driver.getTitle().trim().equalsIgnoreCase("Automation Exercise - All Products"), "User is not on a product page");
    }
    public void verifyAllProductsIsVisible(){
        Assert.assertTrue(allProducts.isDisplayed(), "Products Are not visible");
    }
    public void clickOnFirstProduct(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,550)", "");
        firstProduct.click();
    }
    public void searchProduct(String str){
        searchProductInput.sendKeys(str);
        submitSearchBtn.click();
    }
    public void verifyVisibilitySearchedProducts(String str){
        List<WebElement> products = driver.findElements(By.xpath("//p[contains(text(),'"+str+"')]/../../../../.."));
        for (int i = 0; i < products.size(); i++) {
            Assert.assertTrue(products.get(i).isDisplayed(), "Product"+products.get(i)+"is not visible");

        }
    }
    public void hoverOverFistItem(){
        Actions actions = new Actions(driver);
        actions.moveToElement(firstItem);
    }
    public void addFirstItemToTeCart(){
        addToCartBtn.click();
    }
    public void addSecondItemToTeCart(){
        addToCarSecondItemBtn.click();
    }
    public void clickContinueShoppingBtn(){
        continueShoppingBtn.click();
    }
    public void clickViewCart(){
        viewCartBtn.click();
    }
    public void savePriceData(){
        String price1 = firstItemPrice.getText().trim();
        ConfigReader.setProperty("price1",price1);
        String price2 = secondItemPrice.getText().trim();
        ConfigReader.setProperty("price2", price2);

    }
    public void verifySearchProductsTextIsVisible(){
        Assert.assertTrue(searchProductsText.isDisplayed(), "Searched products text is not visible");
    }
    public void verifySearchProductsIsVisibleAndRelatedToSearch(String str) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> searchedProducts = driver.findElements(By.xpath("//p[contains(text(),'"+ str +"')]"));
        for (int i = 0; i < searchedProducts.size(); i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,350)", "");
            Assert.assertTrue(searchedProducts.get(i).isDisplayed(), "Product  is not displayed");
            js.executeScript("window.scrollBy(0,200)", "");
            i++;
        }
    }
    public void addSearchedProductsToCart() throws InterruptedException {
        List<WebElement> addToCartProducts = driver.findElements(By.xpath("//a[text()='Add to cart']"));
        for (int i = 0; i < addToCartProducts.size(); i++) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,150)", "");
            addToCartProducts.get(i).click();
            clickContinueShoppingBtn();
            js.executeScript("window.scrollBy(0,200)", "");
            Thread.sleep(1000);
            i++;
        }
        ConfigReader.setProperty("productSize",String.valueOf(addToCartProducts.size()));

    }
}
