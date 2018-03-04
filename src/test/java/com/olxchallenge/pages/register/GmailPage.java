package com.olxchallenge.pages.register;

import com.olxchallenge.framework.AbstractPage;
import org.openqa.selenium.WebDriver;

public class GmailPage extends AbstractPage {
    public GmailPage(WebDriver driver) {
        super(driver);
    }

    public void accessPage(){
        accessUrl("https://mail.google.com/");
    }

    public void accessGmailWithCredentials(){
        getElementById("identifierId").sendKeys("qachallengept0512@gmail.com");
        getElementById("identifierNext").click();
        getElementByName("password").sendKeys("inicial051217");
        getElementById("passwordNext").click();
        driverWait(10);
    }

    public void readEmail(){
        getElementByClassName("aDP").click();
    }

    public void activateAccount(){
        getElementById("m_-833233119156782511confirmLink").click();
    }

}
