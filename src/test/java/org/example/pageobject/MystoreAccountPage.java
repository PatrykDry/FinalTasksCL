package org.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MystoreAccountPage {
    private WebDriver driver;

    public MystoreAccountPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickAddressIcon(){
        WebElement addressesButton = driver.findElement(By.id("addresses-link"));
        addressesButton.click();
    }
    public void clickToMainPage(){
        WebElement clickToMainPage = driver.findElement(By.cssSelector("#_desktop_logo > a"));
        clickToMainPage.click();
    }
}
