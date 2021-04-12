package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.Base;

public class ProductListingPage extends Base {
    private WebDriver driver;

    @FindBy(xpath = "//div[@data-hook='homepage_products']")
    private WebElement productList;

    @FindBy(className = "plp-not-found-header")
    private WebElement noProductsFoundHeader;

    @FindBy(className = "plp-not-found-text")
    private WebElement noProductsFoundText;

    public ProductListingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getProductList(){
        return productList;
    }

    public WebElement getNoProductsFoundHeader(){
        return noProductsFoundHeader;
    }

    public WebElement getNoProductsFoundText(){
        return noProductsFoundText;
    }
}
