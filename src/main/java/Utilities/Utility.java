package Utilities;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.Key;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Utility {

    // Variable to store the screenshots path
    private static final String SCREENSHOTS_PATH = "test-outputs/Screenshots/";

    // Function to click on element
    public static void clickOnElement(WebDriver driver, By locator) {

        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    // Function to pass or send data to an element
    public static void sendData(WebDriver driver, By locator, String text) {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).sendKeys(text);
    }

    // Function to get text for an element
    public static String getText(WebDriver driver, By locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }

    // General wait
    public static WebDriverWait generalWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Function to convert locators to WebElement
    public static WebElement findWebElement(WebDriver driver, By locator) {
        return driver.findElement(locator);
    }

    // Function to selecting from dropdown menu
    public static void selectFromDropDown(WebDriver driver, By locator, int index) {
        new Select(findWebElement(driver, locator)).selectByIndex(index);
    }

    // Function to scrolling to an element
    public static void scrolling(WebDriver driver, By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", findWebElement(driver, locator));
    }

    public static void clickEnter(WebDriver driver) {
        new Actions(driver).sendKeys(Keys.ENTER).perform();
    }



    // Function to return the time to make things unique
    public static String getTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd-h-m-ssa").format(new Date());
    }

    // Function to take screenshots and store it in the file and generate it to the allure report
    public static void takeScreenShots(WebDriver driver, String screenshotName) {
        try {
            // capture screenshots using TakeScreenshot
            File screenshotSrc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Save screenshots to a file if needed
            File screenshotFile = new File(SCREENSHOTS_PATH + screenshotName + "-" + getTimeStamp() + ".png");
            FileUtils.copyFile(screenshotSrc, screenshotFile);

            // Attach screenshots to the report
            Allure.addAttachment(screenshotName, Files.newInputStream(Path.of(screenshotFile.getPath())));

        } catch (Exception e) {
            LogsUtils.error(e.getMessage());
        }
    }

}
