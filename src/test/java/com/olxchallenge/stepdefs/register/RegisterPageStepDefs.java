package com.olxchallenge.stepdefs.register;

import com.olxchallenge.pages.homepage.HomePage;
import com.olxchallenge.pages.register.RegisterPage;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class RegisterPageStepDefs {

    private WebDriver driver;
    private RegisterPage registerPage;
    private HomePage homePage;

    @Before
    public void RegisterPageStepDefs() throws Throwable {
        final File file = new File("src/test/resources/driver/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        registerPage = new RegisterPage(driver);
        homePage = new HomePage(driver);
    }

    @Given("^I access Otobom page$")
    public void accessOtobomPage(){
        homePage.navigateToHomePage();
    }

    @When("^I click in My Account$")
    public void clickOnMyAccount(){
        homePage.clickOnMyAccount();
    }

    @Then("^I can register a new user$")
    public void verifyIfIsPossibleCreateANewUser(){
        registerPage.verifyRegisterBoxIsDisplayed();
    }

    @When("^I click to register a new user$")
    public void clickForRegisterNewUser(){
        registerPage.clickForRegisterANewUser();
    }

    @Then("^I see the reasons for create a user on Otobom$")
    public void verifyReasonsToCreateAuserOTobom(){
        registerPage.verifyIfElementIsDisplayedWithClass("text-content");
    }

    @Given("^I click to create an account$")
    public void clickForCreateAnAccount(){
        registerPage.clickForCreateAnAccount();
    }

    @When("^Fill the foolow user fields\\:$")
    public void fillUserFields(DataTable values){
        registerPage.fillFields(values);
    }

    @When("^Accept the terms$")
    public void acceptTerms(){
        registerPage.acceptTerms();
    }

    @When("^I click for register a new user$")
    public void clickForRegister(){
        registerPage.clickOnRegsister();
    }

    @Then("^I see a resgistration confirmation message")
    public void confirmRegistrationMessage(){
        registerPage.verifyMessageConfirmRegistrationIsDisplayed();
    }

    @After
    public void closeDriver(){
        driver.close();
        driver.quit();
    }
}

