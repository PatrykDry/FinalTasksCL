package org.example.pageobject;

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
    public void fillAddressForm(String alias, String address, String city, String postalCode, Integer country, String phone){
        WebElement aliasFormInput = driver.findElement(By.cssSelector("input[name=alias]"));
        aliasFormInput.sendKeys(alias);

        WebElement addressFormInput = driver.findElement(By.cssSelector("input[name=address1]"));
        addressFormInput.sendKeys(address);

        WebElement cityFormInput = driver.findElement(By.cssSelector("input[name=city]"));
        cityFormInput.sendKeys(city);

        WebElement postalCodeFormInput = driver.findElement(By.cssSelector("input[name=postcode]"));
        postalCodeFormInput.sendKeys(postalCode);

        WebElement countryFormInput = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[10]/div[1]/select"));
        countryFormInput.click();
        Select selectCountry = new Select(countryFormInput);
        selectCountry.selectByIndex(country);

        WebElement phoneFormInput = driver.findElement(By.cssSelector("input[name=phone]"));
        phoneFormInput.sendKeys(phone);
    }

    public void clickSaveAddressButton(){
        WebElement clickSaveButton = driver.findElement(By.cssSelector("#content > div > div > form > footer > button"));
        clickSaveButton.click();
    }
}
