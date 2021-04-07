package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import resources.Base;

public class Navbar extends Base {
    private WebDriver driver;
    private By accountIcon = By.cssSelector("#account-button");
    private By signUp = By.cssSelector("a[href*=signup]");
    private By login = By.cssSelector("a[href*=login]");
    private By logout = By.cssSelector("a[href*=logout]");
    private By searchIcon = By.className("search-icons");
    private By keywords = By.id("keywords");

    public Navbar(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getAccountIcon(){
        return driver.findElement(accountIcon);
    }

    public WebElement getLogout() {
        return driver.findElement(logout);
    }

    public WebElement getLogin() {
        return driver.findElement(login);
    }

    public WebElement getSignUp(){
        return driver.findElement(signUp);
    }

    public WebElement getSearchIcon(){
        return driver.findElement(searchIcon);
    }

    public WebElement getKeywords(){
        return driver.findElement(keywords);
    }
}