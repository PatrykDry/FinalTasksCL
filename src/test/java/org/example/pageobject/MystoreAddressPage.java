package org.example.pageobject;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MystoreAddressPage {
    private WebDriver driver;
    public MystoreAddressPage(WebDriver driver){
        this.driver = driver;
    }
    public void  createNewAddress(){
        WebElement createNewAddress = driver.findElement(By.cssSelector("a[data-link-action=add-address]"));
        createNewAddress.click();
    }
    public void fillAliasFromInput(String alias){
        WebElement aliasFormInput = driver.findElement(By.cssSelector("input[name=alias]"));
        aliasFormInput.sendKeys(alias);
        Assertions.assertEquals(alias,aliasFormInput.getAttribute("value"));
    }

    public void fillAddressFromInput(String address){
        WebElement addressFormInput = driver.findElement(By.cssSelector("input[name=address1]"));
        addressFormInput.sendKeys(address);
        Assertions.assertEquals(address,addressFormInput.getAttribute("value"));
    }

    public void fillCityFromInput(String city){
        WebElement cityFormInput = driver.findElement(By.cssSelector("input[name=city]"));
        cityFormInput.sendKeys(city);
        Assertions.assertEquals(city,cityFormInput.getAttribute("value"));
    }

    public void fillPostalCodeFromInput(String postalCode){
        WebElement postalCodeFormInput = driver.findElement(By.cssSelector("input[name=postcode]"));
        postalCodeFormInput.sendKeys(postalCode);
        Assertions.assertEquals(postalCode,postalCodeFormInput.getAttribute("value"));
    }

    public void chooseCountry(String country){
        WebElement countryFormInput = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[10]/div[1]/select"));
        countryFormInput.click();
        Select selectCountry = new Select(countryFormInput);
        selectCountry.selectByVisibleText(country);
    }

    public void fillPhoneFromInput(String phone){
        WebElement phoneFormInput = driver.findElement(By.cssSelector("input[name=phone]"));
        phoneFormInput.sendKeys(phone);
        Assertions.assertEquals(phone,phoneFormInput.getAttribute("value"));
    }

    public void clickSaveAddressButton(){
        WebElement clickSaveButton = driver.findElement(By.cssSelector("#content > div > div > form > footer > button"));
        clickSaveButton.click();
    }

    public void addressAddeddSuccessfully(){
        WebElement addressAddeddAlert = driver.findElement(By.xpath("//*[@id=\"notifications\"]/div/article/ul/li"));
        Assertions.assertEquals("Address successfully added!",addressAddeddAlert.getText());
    }
}
