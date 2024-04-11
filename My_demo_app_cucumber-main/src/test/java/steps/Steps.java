package steps;

import io.appium.java_client.AppiumBy;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import setup.StartStopServer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Steps extends StartStopServer {

    @Before("@setUp")
    public void setup() {
        runServer();
    }

    @After("@setUp")
    public void stop() {
        tearDown();
    }

    @Given("User is on {string} page")
    public void user_is_on_page(String page) {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"" + page + "\")")).isDisplayed();
    }

    @Given("User is on Login page")
    public void user_is_on_login_page() throws InterruptedException {
        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"open menu\"]")).click();
        Thread.sleep(500);
        driver.findElement(AppiumBy.androidUIAutomator("text(\"Log In\")")).click();
        Thread.sleep(1000);
    }

    @When("User clicks {string} button")
    public void user_click_button(String button) {
        driver.findElement(AppiumBy.accessibilityId(button)).click();
    }

    @Then("First product title is {string}")
    public void first_product_title_is(String title) {
        String element = driver.findElements(AppiumBy.androidUIAutomator(
                "description(\"store item text\")")).get(0).getText();
        assertEquals(title, element);
    }


    @When("User enters Email {string}")
    public void userEntersEmailEmail(String email) {
        driver.findElements(AppiumBy.androidUIAutomator("className(\"android.widget.EditText\")")).get(0).click();
        driver.findElements(AppiumBy.androidUIAutomator("className(\"android.widget.EditText\")")).get(0).sendKeys(email);
    }

    @And("User enters Password {string}")
    public void userEntersPasswordPassword(String password) {
        driver.findElements(AppiumBy.androidUIAutomator("className(\"android.widget.EditText\")")).get(1).click();
        driver.findElements(AppiumBy.androidUIAutomator("className(\"android.widget.EditText\")")).get(1).sendKeys(password);
    }

    @Then("User is logged in and redirected to Product Page")
    public void userIsLoggedInAndRedirectedToProductPage() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiSelector().text(\"Products\")")).isDisplayed();
    }

    @And("User clicks Login")
    public void userClicksLogin() {
        driver.findElements(AppiumBy.androidUIAutomator("className(\"android.widget.TextView\").textContains(\"Login\")")).get(1).click();
    }

    @Then("Page title is Login")
    public void pageTitleIsLogin() {
        String title = driver.findElements(AppiumBy.androidUIAutomator("className(\"android.widget.TextView\").textContains(\"Login\")")).get(0).getText();
        assertEquals("Login", title);
    }

    @Then("Error message is displayed")
    public void errorMessageIsDisplayed() {
        driver.findElement(AppiumBy.androidUIAutomator("className(\"android.widget.TextView\").textContains(\"Provided credentials\")")).isDisplayed();

    }

    @Then("Error message is displayed lockedout")
    public void errorMessageIsDisplayedLockedout() {
        driver.findElement(AppiumBy.androidUIAutomator("className(\"android.widget.TextView\").textContains(\"Sorry, this user\")")).isDisplayed();

    }

    @Given("User in open menu dropdown")
    public void userInOpenMenuDropdown() {
        driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"open menu\"]")).click();


    }

    @When("User clicks Logout button")
    public void userClicksLogoutButton() {
        driver.findElement(AppiumBy.androidUIAutomator("text(\"Log Out\")")).click();

    }

    @And("Clicks Logout")
    public void clicksLogout() {
        driver.findElement(AppiumBy.id("android:id/button1")).click();
    }

    @Then("User is Logged out")
    public void userIsLoggedOut() {
        assertTrue(driver.findElement(AppiumBy.id("android:id/alertTitle")).isDisplayed());
    }

    @And("User clicks Cancel")
    public void userClicksCancel() {
        driver.findElement(AppiumBy.id("android:id/button2")).click();
    }

    @Then("User is still logged in")
    public void userIsStillLoggedIn() {
        driver.findElement(AppiumBy.androidUIAutomator("text(\"Log In\")")).click();
        assertTrue(driver.findElement(AppiumBy.androidUIAutomator("text(\"No Items\")")).isDisplayed());
    }
}
