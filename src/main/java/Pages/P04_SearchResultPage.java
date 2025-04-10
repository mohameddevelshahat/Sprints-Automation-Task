package Pages;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static Utilities.Utility.findWebElement;

public class P04_SearchResultPage {

    private final WebDriver driver;
    private final By searchForLocator = By.xpath("//span[@class=\"base\" and @data-ui-id=\"page-title-wrapper\"]");
    private final By productLocator = By.xpath("//a[normalize-space(text())=\"Argus All-Weather Tank\"]");
    private final By noResultLocator = By.xpath("//div[contains(text(), 'Your search returned no results')]");

    public P04_SearchResultPage(WebDriver driver) {
        this.driver=driver;
    }

    public String getSearchMsgResultsText() {
        return Utility.getText(driver,searchForLocator);
    }

    public String getProductResultNameText() {
        Utility.scrolling(driver , productLocator);
        return Utility.getText(driver,productLocator);
    }

    public String getNoResultFoundText() {
        Utility.scrolling(driver , noResultLocator);
        return Utility.getText(driver,noResultLocator);
    }

}

