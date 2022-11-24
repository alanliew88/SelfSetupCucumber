package stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.learningtogether;

public class Steps {


    public WebDriver driver ;
    public learningtogether lp;




    @Given("User Launch Chrome Browser")
    public void user_launch_chrome_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        lp = new learningtogether(driver);

    }
    @When("User open url {string}")
    public void user_open_url(String string) {
        driver.get(string);
        driver.manage().window().maximize();

    }
    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String string, String string2) {
        lp.setUserName(string);
        lp.setPassword(string2);



    }
    @When("Click on Login")
    public void click_on_login() {

        lp.clickLogin();


    }
    @Then("User can view Dashboard")
    public void user_can_view_dashboard() {
        Assert.assertEquals("Dashboard / nopCommerce administration", lp.getPageTitle());



    }
    @When("User click on the dropdown")
    public void user_click_on_the_dropdown() throws InterruptedException {
        lp.clickOnCustomersMenu();



    }
    @When("Click on {string} under the dropdown")
    public void click_on_under_the_dropdown(String string) throws InterruptedException {
        lp.clickOnCustomerMenuItem();

    }

    @Then("User click on the Add new button")
    public void user_click_on_the_add_new_button() {
        lp.clickonaddnewbutton();

    }




}
