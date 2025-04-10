package Pages;

import Utilities.DataUtils;
import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;

public class P01_LandingPage {

    private final WebDriver driver;

    private final By searchLocator = By.id("search");
    private final By searchIconLocator = By.id("search");
    private final By productLocator = By.xpath("//div[@data-product-id=\"158\" and contains(@class, \"price-box\")]/ancestor::li[contains(@class, \"product-item\")]");


    public P01_LandingPage(WebDriver driver){
        this.driver = driver;
    }

    public P01_LandingPage writeValidSearchKeyWord(String searchKeyword) throws FileNotFoundException {
        Utility.sendData(driver,searchLocator, searchKeyword);
        return new P01_LandingPage(driver);
    }

    public P04_SearchResultPage clickEnter(){
        Utility.clickEnter(driver);
        return new P04_SearchResultPage(driver);
    }

    public P02_ProductPage clickOnOneProduct(){
        Utility.scrolling(driver, productLocator);
        Utility.clickOnElement(driver,productLocator);
        return new P02_ProductPage(driver);
    }


}
