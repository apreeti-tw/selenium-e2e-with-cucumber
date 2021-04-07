package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.Navbar;
import pageObjects.RegisterUserAndLoginPage;
import resources.Base;
import resources.Utilities;

import java.io.IOException;

public class LoginSteps extends Base {
    private Navbar navbar;
    private RegisterUserAndLoginPage registerUserAndLoginPage;

    @Before
    public void setDriver() throws IOException {
        driver = initialiseDriver();
    }

    @Given("User navigates to the {string} page")
    public void userNavigatesToThePage(String url){
        driver.get(url);
        navbar = new Navbar(driver);
        registerUserAndLoginPage = new RegisterUserAndLoginPage(driver);
    }

    @When("User logs in with username {string} and password {string}")
    public void userLogsInWithUsernameAndPassword(String username, String password) {
        navbar.getAccountIcon().click();
        navbar.getLogin().click();

        registerUserAndLoginPage.getEmail().sendKeys(username);
        registerUserAndLoginPage.getPassword().sendKeys(password);
        registerUserAndLoginPage.getLogin().click();
    }

    @Then("User is logged in successfully")
    public void userIsLoggedInSuccessfully() {
        Assert.assertTrue(Utilities.getSuccessAlert().getText().contains("Logged in successfully"));
        navbar.getAccountIcon().click();
        Assert.assertTrue(navbar.getLogout().isDisplayed());
    }

    @Then("An error message is displayed")
    public void anErrorMessageIsDisplayed() {
        Assert.assertTrue(Utilities.getErrorAlert().getText().contains("Invalid email or password."));
    }

    @After
    public void teardown(){
        driver.close();
        driver.quit();
    }

    @When("User signs up with {string} and {string}")
    public void userSignsUpWithAnd(String username, String password) {
        navbar.getAccountIcon().click();
        navbar.getSignUp().click();

        registerUserAndLoginPage.getEmail().sendKeys(username);
        registerUserAndLoginPage.getPassword().sendKeys(password);
        registerUserAndLoginPage.getConfirmPassword().sendKeys(password);
        registerUserAndLoginPage.getSignUp().click();
    }

    @Then("User is registered successfully")
    public void userIsRegisteredSuccessfully() {
        Assert.assertTrue(Utilities.getSuccessAlert().getText().contains("Welcome! You have signed up successfully."));
        navbar.getAccountIcon().click();
        Assert.assertTrue(navbar.getLogout().isDisplayed());
    }
}
