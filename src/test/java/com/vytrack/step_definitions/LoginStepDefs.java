package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {

        System.out.println("Opening the login page");
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @Then("I should be able to see the dashboard page")
    public void i_should_be_able_to_see_the_dashboard_page() {
        System.out.println("Verifying dashboard page");
        BrowserUtils.waitFor(2);
        Assert.assertTrue(Driver.get().getTitle().contains("Dashboard"));

    }

    @When("I login as a sales manager")
    public void i_login_as_a_sales_manager() {
        System.out.println("Logging in as a sales manager");
        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
    }

    @When("I login as a driver")
    public void i_login_as_a_driver() {
        System.out.println("Logging in as a driver");
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);

    }

    @When("I login as a store manager")
    public void i_login_as_a_store_manager() {
        System.out.println("Logging in as a store manager");
        LoginPage loginPage = new LoginPage();
        loginPage.login("storemanager87", "UserUser123");
    }


}
