package addNewAddressInMyStoreApp;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class MyStoreSteps {

    private static WebDriver driver;



    @Given ("User opened url https:\\/\\/mystore-testlab.coderslab.pl")
    public void openMainPAge() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication");


    }

    @When("User clicked on SignIn button And clicked LogIn button after entered corect email and password")
    public void testLogin() {
        LoginPageObject loginPageObject = new LoginPageObject(driver);
        loginPageObject.loginAs("alan@gmail.com","12345");
    }
    @And("clicked on View Customer Account button")
    public void user_is_loged_on_his_account() {
        MainPageObject accountObject = new MainPageObject(driver);
        accountObject.ViewAccountOptions();
    }

    @And("clicked on Adresses button")
    public void userClickOnAddresses() {
        YourAccountPageObj yourAccountPageObj = new YourAccountPageObj(driver);
        yourAccountPageObj.clickOnAddressesButton();
    }


    @And("clicked on Create new address button")
    public void clickedOnCreateNewAddressButton() {
        YourAddressesPageObj yourAddressesPageObj = new YourAddressesPageObj(driver);
        yourAddressesPageObj.clickOnAddressesButton();
    }


    @And("^filed the form input: (.*)$")
    public void fillTheAliasInput(String alias) {
        FormPageObj formPageObj = new FormPageObj(driver);
        formPageObj.setAlias(alias);

    }


    @And("^filed the form inputt:(.*)$")
    public void filedTheFormInputAddress(String address) {
        FormPageObj formPageObj = new FormPageObj(driver);
        formPageObj.setAddress(address);
    }

    @And("^filed the form inputx:(.*)$")
    public void fillTheCityInput(String city) {
        FormPageObj formPageObj = new FormPageObj(driver);
        formPageObj.setCity(city);
    }
    @And("^filed the form inputy:(.*)$")
    public void enterTheZip(String zip){
        FormPageObj formPageObj = new FormPageObj(driver);
        formPageObj.setZipcode(zip);
    }
    @And("^filed the form inputz:(.*)$")
    public void enterThePhone(String phone) {
        FormPageObj formPageObj = new FormPageObj(driver);
        formPageObj.setPhone(phone);

    }
    @And("^choose the (.*)$")
    public void enterThecountry(String country){
        FormPageObj formPageObj = new FormPageObj(driver);
        formPageObj.clickCountry();
        formPageObj.choseCountry(country);

    }
    @And("check that data in form is correct")
    public void checkThatDataInFormIsCorrect() {
        FormPageObj formPageObj = new FormPageObj(driver);
        Assertions.assertEquals("Jacek", formPageObj.aliasInput.getAttribute("value"));
        Assertions.assertEquals("polna 7", formPageObj.addressInput.getAttribute("value"));
        Assertions.assertEquals("Mława", formPageObj.cityInput.getAttribute("value"));
        Assertions.assertEquals("06-500", formPageObj.zipInput.getAttribute("value"));
        Assertions.assertEquals("933666666", formPageObj.phoneInput.getAttribute("value"));

    }

    @And("clicked on save button")
    public void clickedOnSaveButton() {
        FormPageObj formPageObj = new FormPageObj(driver);
        formPageObj.clickSaveButton();
    }

    @Then("phrase Address successfully added is visible")
    public void phraseAddressSuceffulyAddedIsVissible() {
        YourAccountPageObj yourAccountPageObj = new YourAccountPageObj(driver);
        Assertions.assertEquals("Address successfully added!", yourAccountPageObj.addressSuccessfullyAdded.getText());
        //driver.quit();
    }



}