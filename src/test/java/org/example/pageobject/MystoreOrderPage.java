package org.example.pageobject;

import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class MystoreOrderPage {
    private WebDriver driver;

    public MystoreOrderPage(WebDriver driver){
        this.driver = driver;
    }

    public void confirmAddress(){
        WebElement clickButton = this.driver.findElement(By.name("confirm-addresses"));
        clickButton.click();
    }

    public void pickShippingMethod(){
        WebElement shippingMethod = this.driver.findElement(By.id("delivery_option_1"));
        if (!shippingMethod.isSelected())
            shippingMethod.click();
    }

    public void confirmShippingMethod(){
        WebElement clickButton = this.driver.findElement(By.name("confirmDeliveryOption"));
        clickButton.click();
    }

    public void pickPaymentMethod(){
        WebElement paymentMethod = this.driver.findElement(By.id("payment-option-1"));
        if (!paymentMethod.isSelected())
            paymentMethod.click();
    }

    public void agreeTermsOfService(){
        WebElement termsOfService = this.driver.findElement(By.cssSelector("input[type=checkbox]"));
        if (!termsOfService.isSelected())
            termsOfService.click();
    }

    public void confirmOrder(){
        WebElement confirmOrder = this.driver.findElement(By.id("payment-confirmation"));
        confirmOrder.click();
    }

    public void saveScreenshot() throws IOException {
        File tmpScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String currentDateTime = LocalDateTime.now().toString().replaceAll(":", "_");
        Files.copy(tmpScreenshot.toPath(), Paths.get("C:", "test-evidence", "mystore-"+currentDateTime+".png"));

    }
}

