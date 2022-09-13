package org.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MystoreOrderPage {
    private WebDriver driver;

    public MystoreOrderPage(WebDriver driver){
        this.driver = driver;
    }


    public void clickContinueButton(){
        WebElement clickButton = this.driver.findElement(By.name("confirm-addresses"));
        clickButton.click();
    }

    public void shippingMethod(){
        WebElement shippingMethod = this.driver.findElement(By.id("delivery_option_2"));
        shippingMethod.click();
    }
}

