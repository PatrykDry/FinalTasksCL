package org.example;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstTask {
    @Test
    public void prestaShopUserLogin() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");

        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("wuh03167@cdfaq.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("123QWE!@#");

        WebElement submitButton = driver.findElement(By.id("submit-login"));
        submitButton.click();

        // Subpage

        WebElement addressesButton = driver.findElement(By.id("addresses-link"));
        addressesButton.click();

        WebElement createNewAddressButton = driver.findElement(By.cssSelector("a[data-link-action=add-address]"));
        createNewAddressButton.click();

        //fill form
        WebElement aliasFormInput = driver.findElement(By.cssSelector("input[name=alias]"));
        aliasFormInput.sendKeys("Alias");
        WebElement addressFormInput = driver.findElement(By.cssSelector("input[name=address1]"));
        addressFormInput.sendKeys("Address");
        WebElement cityFormInput = driver.findElement(By.cssSelector("input[name=city]"));
        cityFormInput.sendKeys("City");
        WebElement postalCodeFormInput = driver.findElement(By.cssSelector("input[name=postcode]"));
        postalCodeFormInput.sendKeys("Alias");

        WebElement countryFormInput = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[10]/div[1]/select"));
        countryFormInput.click();
        Select selectCountry = new Select(countryFormInput);
        selectCountry.selectByIndex(1);

        WebElement phoneFormInput = driver.findElement(By.cssSelector("input[name=phone]"));
        phoneFormInput.sendKeys("123456789");
        driver.quit();

    }
}