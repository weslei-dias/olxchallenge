package com.olxchallenge.pages.register;

import com.olxchallenge.framework.AbstractPage;
import cucumber.api.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegisterPage extends AbstractPage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void verifyRegisterBoxIsDisplayed(){
        verifyIfElementIsDisplayedWithClass("register-box");
    }

    public void clickForRegisterANewUser(){
        WebElement linkForRegisterUser = getElementByCssSelector("a[href='https://www.otodom.pl/konto/korzysci/']");
        linkForRegisterUser.click();
    }

    public void clickForCreateAnAccount(){
        WebElement linkForCreateAccount = getElementByCssSelector("a[href='https://www.otodom.pl/konto/rejestracja/']");
        linkForCreateAccount.click();
    }

    public void fillFields(DataTable values){
        List<List<String>> data = values.raw();
        getElementById("userEmail").sendKeys(data.get(0).get(1));
        getElementById("userPass").sendKeys(data.get(1).get(1));
        getElementById("userPass-repeat").sendKeys(data.get(2).get(1));
    }

    public void acceptTerms(){
        List<WebElement> elements = getElementsByClass("df_line");

        for (WebElement element : elements){
            element.click();
        }
    }

    public void clickOnRegsister(){
        WebElement registerButton = getElementByClassName("form-group-submit");
        registerButton.click();
    }

    public void verifyMessageConfirmRegistrationIsDisplayed(){
        verifyIfElementIsDisplayedWithClass("confirm-page");
    }

    public void verifyMessageConfirmationActivation(){
        verifyIfElementIsDisplayedWithClass("confirm-page successbox");
    }

}
