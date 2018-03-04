package com.olxchallenge.stepdefs.homepage;

import com.olxchallenge.pages.homepage.HomePage;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class HomePageStepDefs {
    private WebDriver driver;
    private HomePage homePage;

    @Before
    public void HomePageStepDefs() throws Throwable {
        final File file = new File("src/test/resources/driver/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }


    @Given("^I access Otobom home page$")
    public void accessHomePage(){
        homePage.navigateToHomePage();
    }

    @When("^I click on the New Advert button$")
    public void clickOnNewAdvert(){
        homePage.clickOnNewAdvert();
    }

    @Then("^I see the new advert page$")
    public void validateAccessOnAdvertPage(){
        Assert.assertEquals("https://www.otodom.pl/nowe-ogloszenie/kategoria/",
                driver.getCurrentUrl());
    }


    @After
    public void closeHomePage(){
        driver.close();
    }


}
