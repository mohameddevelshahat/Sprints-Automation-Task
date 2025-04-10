package Pages;

import Utilities.DataUtils;
import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;

public class P05_ShippingPage {

    private final WebDriver driver;

    private final By emailAddressLocator = By.xpath("(//input[@id=\"customer-email\"])[1]");
    private final By firstNameLocator = By.xpath("//input[@type=\"text\" and @name=\"firstname\"]");
    private final By lastNameLocator = By.xpath("//input[@type=\"text\" and @name=\"lastname\"]");
    private final By companyLocator = By.xpath("//input[@type=\"text\" and @name=\"company\"]");
    private final By streetAddressLocator = By.xpath("//input[@name=\"street[0]\" and @type=\"text\"]");
    private final By cityLocator = By.xpath("//input[@name=\"city\" and @type=\"text\"]");
    private final By stateLocator = By.xpath("//select[@name=\"region_id\"]");
    private final By postalCodeLocator = By.xpath("//input[@name='postcode']");
    private final By countryLocator = By.xpath("//select[@name=\"country_id\"]");
    private final By phoneNumberLocator = By.xpath("//input[@name='telephone']");
    private final By shippingMethodLocator = By.xpath("//input[@type='radio' and @value='flatrate_flatrate']");
    private final By nextButtonLocator = By.xpath("//button[.//span[text()='Next']]");

    public P05_ShippingPage(WebDriver driver) {
        this.driver=driver;
    }

    public P05_ShippingPage writeEmailAddress() throws FileNotFoundException {
        Utility.scrolling(driver, emailAddressLocator);
        Utility.sendData(driver,emailAddressLocator , DataUtils.getJsonData("shippingData","emailAddress"));
        return new P05_ShippingPage(driver);
    }

    public P05_ShippingPage writeFirstName() throws FileNotFoundException {
        Utility.scrolling(driver, firstNameLocator);
        Utility.sendData(driver,firstNameLocator , DataUtils.getJsonData("shippingData","firstName"));
        return new P05_ShippingPage(driver);
    }

    public P05_ShippingPage writeLastName() throws FileNotFoundException {
        Utility.scrolling(driver, lastNameLocator);
        Utility.sendData(driver,lastNameLocator , DataUtils.getJsonData("shippingData","lastName"));
        return new P05_ShippingPage(driver);
    }

    public P05_ShippingPage writeCompany() throws FileNotFoundException {
        Utility.scrolling(driver, companyLocator);
        Utility.sendData(driver,companyLocator , DataUtils.getJsonData("shippingData","companyName"));
        return new P05_ShippingPage(driver);
    }

    public P05_ShippingPage writeStreetAddress() throws FileNotFoundException {
        Utility.scrolling(driver, streetAddressLocator);
        Utility.sendData(driver,streetAddressLocator , DataUtils.getJsonData("shippingData","streetAddress"));
        return new P05_ShippingPage(driver);
    }

    public P05_ShippingPage writeCity() throws FileNotFoundException {
        Utility.scrolling(driver, cityLocator);
        Utility.sendData(driver,cityLocator , DataUtils.getJsonData("shippingData","cityName"));
        return new P05_ShippingPage(driver);
    }

    public P05_ShippingPage chooseState(){
        Utility.scrolling(driver, stateLocator);
        Utility.selectFromDropDown(driver,stateLocator,1);
        return new P05_ShippingPage(driver);
    }

    public P05_ShippingPage writePostalCode() throws FileNotFoundException {
        Utility.scrolling(driver, postalCodeLocator);
        Utility.sendData(driver,postalCodeLocator , DataUtils.getJsonData("shippingData","postalCode"));
        return new P05_ShippingPage(driver);
    }

    public P05_ShippingPage chooseCountry(){
        Utility.scrolling(driver, countryLocator);
        Utility.selectFromDropDown(driver,countryLocator,1);
        return new P05_ShippingPage(driver);
    }

    public P05_ShippingPage writePhoneNumber() throws FileNotFoundException {
        Utility.scrolling(driver, phoneNumberLocator);
        Utility.sendData(driver,phoneNumberLocator , DataUtils.getJsonData("shippingData","phoneNumber"));
        return new P05_ShippingPage(driver);
    }

    public P05_ShippingPage clickOnShippingMethod(){
        Utility.scrolling(driver, shippingMethodLocator);
        Utility.clickOnElement(driver, shippingMethodLocator);
        return new P05_ShippingPage(driver);
    }

    public P03_ReviewPage clickOnNextButton(){
        Utility.scrolling(driver, nextButtonLocator);
        Utility.clickOnElement(driver, nextButtonLocator);
        return new P03_ReviewPage(driver);
    }


}
