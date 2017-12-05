package com.olxchallenge.framework;

import cucumber.api.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class AbstractPage {

    private WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait driverWait(long timeoutSeconds) {
        return new WebDriverWait(driver, timeoutSeconds);
    }

    public WebElement getElementByClassName(String className){
        WebElement element = driverWait(10)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .className(className)));
        return element;
    }

    public WebElement getElementById(String id){
        WebElement element = driverWait(10)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .id(id)));
        return element;
    }

    public WebElement getElementByName(String name){
        WebElement element = driverWait(10)
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .name(name)));
        return element;
    }

    public void accessUrl(String url){
        getDriver().get(url);
    }


    public WebElement fillField(String identifier){
        WebElement elemtFind = null;
        WebElement elementById = driver.findElement(By.id(identifier));
        WebElement elementByClass = driver.findElement(By.className(identifier));
        WebElement elementByName = driver.findElement(By.name(identifier));


        if(elementById != null){
            elemtFind = elementById;
        }else if(elementByClass != null){
            elemtFind = elementByClass;
        }else if (elementByName != null){
            elemtFind = elementByName;
        }

        return elemtFind;
    }

    public WebElement getElementByValue(List<WebElement> elements, String value){
        WebElement roomElement = null;
        for (WebElement element : elements){
            if (element.getAttribute("innerText").equals(value)){
                roomElement = element;
                break;
            }
        }

        return roomElement;
    }

    public WebElement getElementByCssSelector(String cssSelector){
        return getDriver().findElement(
                By.cssSelector(cssSelector));
    }

    public List<WebElement> getElementsByClass(String className)    {
        List<WebElement> elements = (new WebDriverWait(getDriver(), 12))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(className)));
        return elements;
    }

    public WebElement getElementByValueAndName(String name, String value)    {
        List<WebElement> elements = (new WebDriverWait(getDriver(), 12))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name(name)));
        return getElementByValue(elements, value);
    }

    public WebElement getElementByValueAndClassName(String className, String value)    {
        List<WebElement> elements = (new WebDriverWait(getDriver(), 12))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className(className)));
        return getElementByValue(elements, value);
    }

    public void scroolPage(){
        JavascriptExecutor Scrool = (JavascriptExecutor) driver;
        Scrool.executeScript("window.scrollBy(0, window.innerHeight/2)", "");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void verifyURL(String url){
        Assert.assertEquals(getDriver().getCurrentUrl(), url);
    }

    public void verifyIfElementIsDisplayedWithClass(String className) {
        WebElement element = getElementByClassName(className);
        Assert.assertEquals(true, element.isDisplayed());
    }
}
