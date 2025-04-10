package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P02_ProductPage {

    private final WebDriver driver;
    private final By addToCartLocator = By.xpath("//button[@type=\"submit\" and @title=\"Add to Cart\" and contains(@class, \"tocart\")]");
    private final By sizeLocator = By.xpath("//div[@option-id=\"168\"]\n");
    private final By colorLocator = By.xpath("//div[@option-id=\"49\"]");
    private final By cartLocator = By.xpath("//span[@class=\"counter-number\" and normalize-space()=\"1\"]");
    private final By proceedToCheckoutLocator = By.xpath("//button[@id=\"top-cart-btn-checkout\" and normalize-space()=\"Proceed to Checkout\"]");
    private final By productAddedTextLocator = By.xpath("(//div[contains(., \"You added\") and contains(., \"to your shopping cart\")])[6]");

    public P02_ProductPage(WebDriver driver) {
        this.driver=driver;
    }

    public P02_ProductPage clickOnSizeButton(){
        Utility.scrolling(driver, sizeLocator);
        Utility.clickOnElement(driver,sizeLocator);
        return new P02_ProductPage(driver);
    }
    public P02_ProductPage clickOnColorButton(){
        Utility.clickOnElement(driver,colorLocator);
        return new P02_ProductPage(driver);
    }
    public P02_ProductPage clickOnAddToCartButton(){
        Utility.scrolling(driver, addToCartLocator);
        Utility.clickOnElement(driver,addToCartLocator);
        return new P02_ProductPage(driver);
    }

    public String getProductAddedSuccessfullyText() {
        Utility.scrolling(driver , productAddedTextLocator);
        return Utility.getText(driver,productAddedTextLocator);
    }

    public P02_ProductPage clickOnCartButton(){
        Utility.scrolling(driver, cartLocator);
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.not(ExpectedConditions.textToBe(cartLocator, "0")));
        Utility.clickOnElement(driver,cartLocator);
        return new P02_ProductPage(driver);
    }

    public P05_ShippingPage clickOnCheckoutButton(){
        Utility.clickOnElement(driver,proceedToCheckoutLocator);
        return new P05_ShippingPage(driver);
    }

}
