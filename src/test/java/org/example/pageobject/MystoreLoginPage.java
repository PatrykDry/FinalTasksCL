package org.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MystoreLoginPage {
    private WebDriver driver;

    public MystoreLoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void fillLoginForm(String emailToInput, String passwordToInput){
        WebElement emailInput = this.driver.findElement(By.name("email"));
        emailInput.sendKeys(emailToInput);
        WebElement passwordInput = this.driver.findElement(By.name("password"));
        passwordInput.sendKeys(passwordToInput);
    }

    public void clickSignInButton(){
        WebElement submitButton = driver.findElement(By.id("submit-login"));
        submitButton.click();
    }

}
