package com.olxchallenge.stepdefs.register;

import com.olxchallenge.pages.register.GmailPage;
import com.olxchallenge.pages.register.RegisterPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class GmailPageStepDefs {

    private WebDriver driver;
    private GmailPage gmailPage;
    private RegisterPage registerPage;


    @Before
    public void GmailPageStepDefs() throws Throwable {
        final File file = new File("src/test/resources/driver/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        gmailPage = new GmailPage(driver);
        registerPage = new RegisterPage(driver);
    }

    @When("^I acess my email for activate the user$")
    public void accessEmailWithCredentials(){
        gmailPage.accessGmailWithCredentials();
    }

    @Given("^I access Gmail$")
    public void accessGmail(){
        gmailPage.accessPage();
    }

    @When("^Accces the sent email of Otobom$")
    public void accessEmail(){
        gmailPage.readEmail();
    }

    @When("^I click in the sent link$")
    public void clickOnActivationLink(){
        gmailPage.activateAccount();
    }

    @Then("^I see the confirmation message of activation$")
    public void verifyConfirmationMessageActivation()
    {
        registerPage.verifyMessageConfirmationActivation();
    }

    @After
    public void closeDriver(){
        driver.close();
        driver.quit();
    }
}
