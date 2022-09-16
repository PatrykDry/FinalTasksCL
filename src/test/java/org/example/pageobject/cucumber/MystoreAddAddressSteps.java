package org.example.pageobject.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageobject.MystoreAccountPage;
import org.example.pageobject.MystoreAddressPage;
import org.example.pageobject.MystoreLoginPage;
import org.example.pageobject.MystoreMainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MystoreAddAddressSteps {
    private WebDriver driver;
    private MystoreAddressPage mystoreAddressPage;
    private MystoreAccountPage mystoreAccountPage;
    private MystoreLoginPage mystoreLoginPage;
    private MystoreMainPage mystoreMainPage;

    @Given("^User opened url https:\\/\\/mystore-testlab.coderslab.pl$")
    public void openUrlInBrowser(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        this.driver.get("https://mystore-testlab.coderslab.pl");

        this.mystoreAddressPage = new MystoreAddressPage(this.driver);
        this.mystoreAccountPage = new MystoreAccountPage(this.driver);
        this.mystoreLoginPage = new MystoreLoginPage(this.driver);
        this.mystoreMainPage = new MystoreMainPage(this.driver);
    }

    @When("^User clicked sign in then filled out the form with data and clicked log in$")
    public void logInUser(){
        mystoreMainPage.clickUserIcon();
        mystoreLoginPage.fillLoginForm("wuh03167@cdfaq.com","123QWE!@#");
        mystoreLoginPage.clickSignInButton();
        mystoreAccountPage.clickAddressIcon();
    }


    @And("^clicked on Create new address button$")
    public void createNewAddress(){
        mystoreAddressPage.createNewAddress();
    }

    @And("^filed the Alias form input: (.*)$")
    public void fillAliasFromInput(String alias){
        mystoreAddressPage.fillAliasFromInput(alias);
    }

    @And("^filed the Address form input:(.*)$")
    public void fillAddressFromInput(String address){
        mystoreAddressPage.fillAddressFromInput(address);
    }

    @And("^filed the City form input:(.*)$")
    public void fillCityFromInput(String city){
        mystoreAddressPage.fillCityFromInput(city);
    }

    @And("^filed the PostalCode form input:(.*)$")
    public void fillPostalCodeFromInput(String postalCode){
        mystoreAddressPage.fillPostalCodeFromInput(postalCode);
    }

    @And("^entered the Country: (.*)$")
    public void enterCountry(String country){
        mystoreAddressPage.chooseCountry(country);
    }

    @And("^filed the Phone form input:(.*)$")
    public void fillPhoneFromInput(String phone){
        mystoreAddressPage.fillPhoneFromInput(phone);
    }


    @And("^clicked on save button$")
    public void clickSaveButton(){
        mystoreAddressPage.clickSaveAddressButton();
    }

    @Then("^check that address is added$")
    public void checkThatAddressIsAdded(){
        mystoreAddressPage.addressAddeddSuccessfully();
    }
}
