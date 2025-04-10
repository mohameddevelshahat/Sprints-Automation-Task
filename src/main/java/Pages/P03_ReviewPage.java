package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P03_ReviewPage {

    private final WebDriver driver;
    private final By placeOrderLocator = By.xpath("//button[contains(@class, 'checkout') and @title='Place Order']");
    private final By checkBillingLocator = By.xpath("//input[@id='billing-address-same-as-shipping-checkmo']");

    public P03_ReviewPage(WebDriver driver) {
        this.driver=driver;
    }

    public P03_ReviewPage clickOnCheckboxButton(){
        Utility.scrolling(driver, checkBillingLocator);
        Utility.clickOnElement(driver, checkBillingLocator);
        return new P03_ReviewPage(driver);
    }

    public P06_ThankYouPage clickOnPlaceOrderButton(){
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(placeOrderLocator));
        Utility.scrolling(driver, placeOrderLocator);
        Utility.clickOnElement(driver, placeOrderLocator);
        return new P06_ThankYouPage(driver);
    }
}
