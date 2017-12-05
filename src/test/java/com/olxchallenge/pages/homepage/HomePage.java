package com.olxchallenge.pages.homepage;

import com.olxchallenge.framework.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends AbstractPage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage() {
        accessUrl("https://www.otodom.pl/");
    }

    public void clickOnNewAdvert() {

        WebElement btNewAdvert = getElementByClassName("navbar-adding");
        btNewAdvert.click();
        driverWait(5);
    }

    public void clickOnMyAccount(){
        WebElement btMyAccount = getElementById("my_account");
        btMyAccount.click();
    }
}
