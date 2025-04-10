package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Utilities.Utility.findWebElement;

public class P06_ThankYouPage {

    private final WebDriver driver;
    private final By thanksMsgLocator = By.xpath("//span[text()='Thank you for your purchase!']");

    public P06_ThankYouPage(WebDriver driver) {
        this.driver=driver;
    }

    public boolean checkVisibilityOfThanksMsg() {
        return findWebElement(driver, thanksMsgLocator).isDisplayed();
    }
}
