package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.Navbar;
import pageObjects.ProductListingPage;
import resources.Base;

import java.io.IOException;

public class SearchSteps extends Base {
    private ProductListingPage productListingPage;
    private Navbar navbar;

    @Before
    public void setDriver() throws IOException {
        driver = initialiseDriver();
        productListingPage = new ProductListingPage(driver);
        navbar = new Navbar(driver);
    }

    @When("User searches for {string}")
    public void userSearchesFor(String keyword) {
        navbar.getSearchIcon().click();
        navbar.getKeywords().sendKeys(keyword);
        navbar.getKeywords().sendKeys(Keys.ENTER);
    }

    @Then("Products list should be displayed")
    public void productsListShouldBeDisplayed() {
        Assert.assertTrue(productListingPage.getProductList().isDisplayed());
    }

    @Then("No search results should be displayed")
    public void noSearchResultsShouldBeDisplayed() {
        Assert.assertTrue(productListingPage.getNoProductsFoundText().isDisplayed());
        Assert.assertTrue(productListingPage.getNoProductsFoundHeader().isDisplayed());
    }
}
