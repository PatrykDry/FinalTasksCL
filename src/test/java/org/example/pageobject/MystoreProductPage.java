package org.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MystoreProductPage {
    private WebDriver driver;

    public MystoreProductPage(WebDriver driver){
        this.driver = driver;
    }

    public void pickSizeOfProduct(int size){
        WebElement productSize = this.driver.findElement(By.className("form-control-select"));
        productSize.click();
        Select selectSize = new Select(productSize);
        selectSize.selectByIndex(size);
    }

    public void quantityOfProduct(int quantity){
        WebElement productAmount = this.driver.findElement(By.id("quantity_wanted"));
        productAmount.click();
        productAmount.sendKeys(Keys.chord(Keys.CONTROL,"a"));
    //    productAmount.clear();
        productAmount.sendKeys(String.valueOf(quantity));
    }

    public void addToCart(){
        WebElement addToCart = this.driver.findElement(By.className("add-to-cart"));
        addToCart.click();
    }

    public void proceedToCheckout(){
        WebElement proceedToCheckout = this.driver.findElement(By.cssSelector("#blockcart-modal > div > div > div.modal-body > div > div.col-md-7 > div > div > a"));
        proceedToCheckout.click();
    }
}

