package org.example.first;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MystoreLoginPage {
    @Test
    public void mystoreLoginPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("wuh03167@cdfaq.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("123QWE!@#");

        WebElement submitButton = driver.findElement(By.id("submit-login"));
        submitButton.click();
    }
}
