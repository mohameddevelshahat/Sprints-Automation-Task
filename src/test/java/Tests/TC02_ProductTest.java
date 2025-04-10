package Tests;
import Listeners.IInvokedMethodListenerClass;
import Listeners.ITestResultListenerClass;
import Pages.P01_LandingPage;
import Pages.P02_ProductPage;
import Utilities.LogsUtils;
import org.testng.Assert;
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
public class TC02_ProductTest {

    @BeforeMethod
    public void setup() throws IOException {

        setupDriver(getPropertyValue("environment", "browser"));
        LogsUtils.info("Chrome Driver is Opened");
        getDriver().get(getPropertyValue("environment", "BASE_URL"));
        LogsUtils.info("Page is redirected to the LUMA");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void clickOnTheProductTC() throws FileNotFoundException {
        // TODO : Open LUMA, scroll to the product and click on it
        LogsUtils.info("Scroll to the product and click on it");
        new P01_LandingPage(getDriver()).clickOnOneProduct();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://magento.softwaretestingboard.com/hero-hoodie.html");
    }

    @Test
    public void addingProductToCartTC() throws FileNotFoundException {
        // TODO : Open LUMA, scroll to the product and click on it
        LogsUtils.info("Scroll to the product and click on it");
        new P01_LandingPage(getDriver()).clickOnOneProduct();

        // TODO : CLick on size, color and add to cart button
        LogsUtils.info("Adding Product to cart");
        new P02_ProductPage(getDriver()).clickOnSizeButton().clickOnColorButton().clickOnAddToCartButton();
    }

    @Test
    public void clickOnCartIconTC() throws FileNotFoundException {
        // TODO : Open LUMA, scroll to the product and click on it
        LogsUtils.info("Scroll to the product and click on it");
        new P01_LandingPage(getDriver()).clickOnOneProduct();

        // TODO : CLick on size, color and add to cart button
        LogsUtils.info("Adding Product to cart");
        new P02_ProductPage(getDriver()).clickOnSizeButton().clickOnColorButton().clickOnAddToCartButton();

        // TODO : CLick on cart icon
        LogsUtils.info("Click On Cart Icon");
        new P02_ProductPage(getDriver()).clickOnCartButton();
    }

    @Test
    public void productAddedToCartSuccessfullyValidationTC() throws FileNotFoundException {
        // TODO : Open LUMA, scroll to the product and click on it
        LogsUtils.info("Scroll to the product and click on it");
        new P01_LandingPage(getDriver()).clickOnOneProduct();

        // TODO : CLick on size, color and add to cart button
        LogsUtils.info("Adding Product to cart");
        new P02_ProductPage(getDriver()).clickOnSizeButton().clickOnColorButton().clickOnAddToCartButton();
        Assert.assertEquals(new P02_ProductPage(getDriver()).getProductAddedSuccessfullyText() , "You added Hero Hoodie to your shopping cart.");
    }

    @Test
    public void clickOnProceedToCheckoutTC() throws FileNotFoundException {
        // TODO : Open LUMA, scroll to the product and click on it
        LogsUtils.info("Scroll to the product and click on it");
        new P01_LandingPage(getDriver()).clickOnOneProduct();

        // TODO : CLick on size, color and add to cart button
        LogsUtils.info("Adding Product to cart");
        new P02_ProductPage(getDriver()).clickOnSizeButton().clickOnColorButton().clickOnAddToCartButton();

        // TODO : CLick on cart icon
        LogsUtils.info("Click On Cart Icon");
        new P02_ProductPage(getDriver()).clickOnCartButton();

        // TODO : CLick on cart icon
        LogsUtils.info("Click On Proceed To Checkout");
        new P02_ProductPage(getDriver()).clickOnCheckoutButton();
    }

    @AfterMethod
    public void quit() {
        quitDriver();
    }
}
