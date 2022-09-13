package org.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MystoreShoppingCartPage {
    private WebDriver driver;

    public MystoreShoppingCartPage(WebDriver driver){
        this.driver = driver;
    }

    public void proceedToCheckout(){
        WebElement proceedToCheckout = this.driver.findElement(By.cssSelector("#main > div > div.cart-grid-right.col-xs-12.col-lg-4 > div.card.cart-summary > div.checkout.cart-detailed-actions.card-block > div > a"));
        proceedToCheckout.click();
    }
}

