package org.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MystoreMainPage {
    private WebDriver driver;

    public MystoreMainPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickUserIcon(){
        WebElement signinButton = this.driver.findElement(By.cssSelector("#_desktop_user_info > div > a"));
        signinButton.click();
    }
}

