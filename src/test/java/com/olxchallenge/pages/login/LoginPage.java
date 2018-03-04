package com.olxchallenge.pages.login;

import com.olxchallenge.framework.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends AbstractPage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(){
        getElementById("login").sendKeys("qachallengept0512@gmail.com");
        getElementById("password").sendKeys("inicial051217");
        getElementByValueAndClassName("btn-default","Zaloguj").click();
    }

    public void accesLoginPage(){
        accessUrl("https://www.otodom.pl/konto/?ref%5B0%5D%5Baction%5D=myaccount&ref%5B0%5D%5Bmethod%5D=index");
    }

    public void logout(){
        getElementById("user_items").click();
        getElementById("logout").click();
    }
}
