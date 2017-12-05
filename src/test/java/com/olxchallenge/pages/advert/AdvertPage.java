package com.olxchallenge.pages.advert;

import com.olxchallenge.framework.AbstractPage;
import cucumber.api.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AdvertPage extends AbstractPage {
    public AdvertPage(WebDriver driver) {
        super(driver);
    }

    public void accessNewAdvertPage(String url) {
        accessUrl(url);
    }

    public void clickForRentARoom() {
        List<WebElement> elements = (new WebDriverWait(getDriver(), 12))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("h4")));

        WebElement rooms = getElementByValue(elements, "pokoje");
        Actions action = new Actions(getDriver());
        action.moveToElement(rooms);
        action.perform();

        WebElement element = getElementByCssSelector("a[href='https://www.otodom.pl/wynajem/pokoj/nowe-ogloszenie/']");
        element.click();
    }


    public void fillFormAdvert(DataTable values) {

        List<List<String>> data = values.raw();

        getElementById("add-title").sendKeys(data.get(0).get(1));

        getElementByName("data[param_price][1]").sendKeys(data.get(1).get(1));

        Select priceSelector = new Select(getElementByName("data[param_price][currency]"));
        priceSelector.selectByValue("EUR");

        getElementByName("data[param_rent][1]").sendKeys(data.get(2).get(1));

        Select rentSelector = new Select(getElementByName("data[param_rent][currency]"));
        rentSelector.selectByValue("EUR");

        getElementByName("data[param_deposit][1]").sendKeys(data.get(3).get(1));

        Select depositSelector = new Select(getElementByName("data[param_deposit][currency]"));
        depositSelector.selectByValue("EUR");

        getElementByName("data[param_roomsize]").sendKeys(data.get(4).get(1));
        getElementByName("data[param_m]").sendKeys(data.get(5).get(1));


        getDriver().findElement(By.id("checkbox-broker")).click();

        scroolPage();
        getElementByClassName("select2-selection--single").click();
        getElementByClassName("select2-search__field").sendKeys(data.get(7).get(1));
        getElementByClassName("select2-results__option--highlighted").click();

        getElementById("wysiwyg_ifr").sendKeys(data.get(8).get(1));
        getElementById("add-person").sendKeys(data.get(9).get(1));
        getElementById("add-email").sendKeys(data.get(10).get(1));
        getElementById("accept").click();
    }

    public void clickForPrevious() {
        getDriver().findElement(By.id("preview-link")).click();
    }

    public void submitAdvert() {
        List<WebElement> elements = (new WebDriverWait(getDriver(), 12))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("btn-default")));
        WebElement element = getElementByValue(elements, "Zatwierd?");
        element.click();
    }

    public void createCompleteAdvert(DataTable values){
        driverWait(10);
        clickForRentARoom();
        fillFormAdvert(values);
        clickForPrevious();
        submitAdvert();

    }
}
