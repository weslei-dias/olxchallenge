package com.olxchallenge.pages.useraccount;

import com.olxchallenge.framework.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserAccountPage extends AbstractPage {
    public UserAccountPage(WebDriver driver) {
        super(driver);
    }

    public void clickForCreateNewAdvert(){
        WebElement linkForNewAdvert = getElementByCssSelector("a[href='https://www.otodom.pl/nowe-ogloszenie/']");
        linkForNewAdvert.click();
        driverWait(5);
    }

    public void clickOnConfigurations(){
        WebElement linkForNewAdvert = getElementByCssSelector("a[href='https://www.otodom.pl/mojekonto/ustawienia/']");
        linkForNewAdvert.click();
    }

    public void fillPasswordChanges(){
        getElementByName("password[current_password]").sendKeys("inicial051217");
        getElementByName("password[password]").sendKeys("inicial05");
        getElementByName("password[password2]").sendKeys("inicial05");
        getElementById("passwordInput").click();
    }

    public void confirmationPage(){
        verifyIfElementIsDisplayedWithClass("confirm-page");
    }
}
