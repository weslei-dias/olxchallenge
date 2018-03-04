package com.olxchallenge.stepdefs.advert;

import com.olxchallenge.pages.advert.AdvertPage;
import com.olxchallenge.pages.homepage.HomePage;
import com.olxchallenge.pages.login.LoginPage;
import com.olxchallenge.pages.useraccount.UserAccountPage;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

/**
 * Created by weslei on 04/12/17.
 */
public class AdvertPageStepDefs {

    private WebDriver driver;
    private AdvertPage advertPage;
    private HomePage homePage;
    private LoginPage loginPage;
    private UserAccountPage userAccountPage;

    @Before
    public void AdvertPageStepDefs() {
        final File file = new File("src/test/resources/driver/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        driver = new ChromeDriver();
        advertPage = new AdvertPage(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        userAccountPage = new UserAccountPage(driver);
    }

    @Given("^I access new advert page$")
    public void accessNewAdvertPage(){
        advertPage.accessNewAdvertPage("https://www.otodom.pl/nowe-ogloszenie/kategoria/");
    }

    @When("^I click for rent a room$")
    public void clickForRentARoom(){
        advertPage.clickForRentARoom();
    }

    @Then("^I see the rent room advert page$")
    public void validateAccessRentRoomAdvert(){
        Assert.assertEquals("https://www.otodom.pl/wynajem/pokoj/nowe-ogloszenie/",
                driver.getCurrentUrl());
    }

    @Given("^I fill the follow fields\\:$")
    public void fillFormFields(DataTable values){
        advertPage.fillFormAdvert(values);
    }

    @When("^I click to see the previous$")
    public void clickForPrevious(){
        advertPage.clickForPrevious();
    }

    @Then("^I want to see and submit my advert$")
    public void seePrevious(){
        advertPage.submitAdvert();
    }

    @Then("^The confirmation link to activate the advert$")
    public void checkIfThePgeConfirmationAdvert(){
        Assert.assertEquals("https://www.otodom.pl/nowe-ogloszenie/confirmpage/3tWCv/activate/",
                driver.getCurrentUrl());
    }

    @Given("^I logged in Otobom page$")
    public void accessOtobomPageWithCredentials(){
        homePage.navigateToHomePage();
        homePage.clickOnMyAccount();
        loginPage.login();
    }

    @When("^I click to add a new advert$")
    public void clickOnNewAdvert(){
        userAccountPage.clickForCreateNewAdvert();
    }

    @When("^Create a new rent room advert with the follow values\\:$")
    public void createCompleteAdvert(DataTable values){
        advertPage.createCompleteAdvert(values);
    }

    @Then("^I see my advert on pending adverts")
    public void accessPendingsAdverts(){
        advertPage.accessUrl("https://www.otodom.pl/mojekonto/waiting/");
    }

    @After
    public void closeDriver(){
        driver.close();
        driver.quit();
    }

}
