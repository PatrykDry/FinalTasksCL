package org.example.pageobject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MystorePageTest {
    private WebDriver driver;

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        this.driver.get("https://mystore-testlab.coderslab.pl");
    }

    @Test
    public void mystoreLoginPage() {
        MystoreMainPage mystoreMainPage = new MystoreMainPage(this.driver);
        mystoreMainPage.clickUserIcon();

        MystoreLoginPage mystoreLoginPage = new MystoreLoginPage(this.driver);
        mystoreLoginPage.fillLoginForm("wuh03167@cdfaq.com","123QWE!@#");
        mystoreLoginPage.clickSignInButton();

        MystoreAccountPage mystoreAccountPage = new MystoreAccountPage(this.driver);
        mystoreAccountPage.clickAddressIcon();

        MystoreAddressPage mystoreAddressPage = new MystoreAddressPage(this.driver);
        mystoreAddressPage.createNewAddress();
        mystoreAddressPage.fillAddressForm("Alias","Address","City","11-300",1,"123 321 456");
        mystoreAddressPage.clickSaveAddressButton();
    }
}
