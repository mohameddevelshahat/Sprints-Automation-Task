package Tests;
import Listeners.IInvokedMethodListenerClass;
import Listeners.ITestResultListenerClass;
import Pages.P01_LandingPage;
import Pages.P02_ProductPage;
import Pages.P05_ShippingPage;
import Utilities.LogsUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtils.getPropertyValue;

@Listeners({IInvokedMethodListenerClass.class, ITestResultListenerClass.class})
public class TC04_ShippingTest {

    @BeforeMethod
    public void setup() throws IOException {

        setupDriver(getPropertyValue("environment", "browser"));
        LogsUtils.info("Chrome Driver is Opened");
        getDriver().get(getPropertyValue("environment", "BASE_URL"));
        LogsUtils.info("Page is redirected to the LUMA");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void fillingShippingDetailsAndContinueTC() throws FileNotFoundException {
        // TODO : Open LUMA, scroll to the product and click on it
        LogsUtils.info("Scroll to the product and click on it");
        new P01_LandingPage(getDriver()).clickOnOneProduct();

        // TODO : CLick on size, color and add to cart button
        LogsUtils.info("Adding Product to cart");
        new P02_ProductPage(getDriver()).clickOnSizeButton().clickOnColorButton().clickOnAddToCartButton();

        // TODO : CLick on cart icon
        LogsUtils.info("Click On Cart Icon");
        new P02_ProductPage(getDriver()).clickOnCartButton();

        // TODO : CLick on Proceed To Checkout Button
        LogsUtils.info("Click On Proceed To Checkout");
        new P02_ProductPage(getDriver()).clickOnCheckoutButton();

        // // TODO : Fill Shipping Address Details
        LogsUtils.info("Fill Shipping Address Details");
        new P05_ShippingPage(getDriver()).writeEmailAddress().writeFirstName().writeLastName()
                .writeCompany().writeStreetAddress().writeCity().chooseState().writePostalCode()
                .chooseCountry().writePhoneNumber().clickOnShippingMethod().clickOnNextButton();
    }

    @AfterMethod
    public void quit() {
        quitDriver();
    }
}
