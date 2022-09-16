package org.example.pageobject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;

public class MystoreBuyProductTest {
    private WebDriver driver;

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        this.driver.get("https://mystore-testlab.coderslab.pl");
    }

    @Test
    public void mystoreLoginPage() throws IOException {
        MystoreMainPage mystoreMainPage = new MystoreMainPage(this.driver);
        mystoreMainPage.clickUserIcon();

        MystoreLoginPage mystoreLoginPage = new MystoreLoginPage(this.driver);
        mystoreLoginPage.fillLoginForm("wuh03167@cdfaq.com","123QWE!@#");
        mystoreLoginPage.clickSignInButton();

        MystoreAccountPage mystoreAccountPage = new MystoreAccountPage(this.driver);
        mystoreAccountPage.clickToMainPage();
        mystoreMainPage.selectItem();

        MystoreProductPage mystoreProductPage = new MystoreProductPage(this.driver);
        mystoreProductPage.pickSizeOfProduct(1);
        mystoreProductPage.quantityOfProduct(5);
        mystoreProductPage.addToCart();
        mystoreProductPage.proceedToCheckout();

        MystoreShoppingCartPage mystoreShoppingCartPage = new MystoreShoppingCartPage(this.driver);
        mystoreShoppingCartPage.proceedToCheckout();

        MystoreOrderPage mystoreOrderPage = new MystoreOrderPage(this.driver);
        mystoreOrderPage.confirmAddress();

        mystoreOrderPage.pickShippingMethod();
        mystoreOrderPage.confirmShippingMethod();
        mystoreOrderPage.pickPaymentMethod();
        mystoreOrderPage.agreeTermsOfService();
        mystoreOrderPage.confirmOrder();
        mystoreOrderPage.saveScreenshot();

        driver.quit();

    }

}
