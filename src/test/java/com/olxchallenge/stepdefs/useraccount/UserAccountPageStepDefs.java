package com.olxchallenge.stepdefs.useraccount;

import com.olxchallenge.pages.homepage.HomePage;
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

public class UserAccountPageStepDefs {

    private WebDriver driver;
    private HomePage homePage;
    private UserAccountPage userAccountPage;


    @Before
    public void UserAccountPageStepDefs() {
        final File file = new File("src/test/resources/driver/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        userAccountPage = new UserAccountPage(driver);
    }

    @Given("^Click in configurations$")
    public void clickOnConfigurations() {
        userAccountPage.clickOnConfigurations();
    }

    @When("^I fill my password informations$")
    public void fillPasswordInformations() {
        userAccountPage.fillPasswordChanges();
    }

    @Then("^I see the confirmation page$")
    public void verifyConfirmationPage(){
        userAccountPage.confirmationPage();
    }


    @After
    public void closeDriver(){
        driver.close();
        driver.quit();
    }
}
