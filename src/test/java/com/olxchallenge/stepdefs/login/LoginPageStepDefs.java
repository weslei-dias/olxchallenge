package com.olxchallenge.stepdefs.login;

import com.olxchallenge.pages.homepage.HomePage;
import com.olxchallenge.pages.login.LoginPage;
import com.olxchallenge.pages.useraccount.UserAccountPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class LoginPageStepDefs {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void LoginPageStepDefs() {
        final File file = new File("src/test/resources/driver/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @Given("^I acces the Otobom Login page$")
    public void accessLoginPage() {
        loginPage.accesLoginPage();
    }

    @When("^I fill my credentials$")
    public void fillCredentials() {
        loginPage.login();
    }

    @Then("^I see my personal page$")
    public void verufyPersonalPage() {
        loginPage.verifyURL("https://www.otodom.pl/mojekonto/");
    }

    @Given("^I am logged in the system$")
    public void accessPageWithCredentials() {
        loginPage.accesLoginPage();
        loginPage.login();
    }

    @When("^I click to logout$")
    public void clickToLogout() {
        loginPage.logout();
    }

    @Then("^I see the Otodom home page$")
    public void verifyHomePage(){
        loginPage.verifyURL("https://www.otodom.pl/");
    }

    @After
    public void closeDriver(){
        driver.close();
        driver.quit();
    }
}

