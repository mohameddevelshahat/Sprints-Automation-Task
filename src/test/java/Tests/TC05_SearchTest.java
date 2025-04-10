package Tests;

import Pages.P01_LandingPage;
import Pages.P04_SearchResultPage;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import Listeners.IInvokedMethodListenerClass;
import Listeners.ITestResultListenerClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import static DriverFactory.DriverFactory.*;
import static Utilities.DataUtils.getPropertyValue;

@Listeners({IInvokedMethodListenerClass.class, ITestResultListenerClass.class})
public class TC05_SearchTest {

    @BeforeMethod
    public void setup() throws IOException {

        setupDriver(getPropertyValue("environment", "browser"));
        LogsUtils.info("Chrome Driver is Opened");
        getDriver().get(getPropertyValue("environment", "BASE_URL"));
        LogsUtils.info("Page is redirected to the LUMA");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkTheVisibilityOfValidSearchKeywordTC() throws FileNotFoundException {
        // TODO : Open LUMA and search for "argus"
        LogsUtils.info("Argus is wrote and enter clicked");
        new P01_LandingPage(getDriver())
                .writeValidSearchKeyWord(DataUtils.getJsonData("searchData" , "validSearchKeyword"))
                        .clickEnter();
        LogsUtils.info("Got search result msg : Search results for: 'argus'");
        Assert.assertEquals(new P04_SearchResultPage(getDriver()).getSearchMsgResultsText() , "Search results for: 'argus'");
    }

    @Test
    public void checkTheVisibilityOfValidSearchProductTC() throws FileNotFoundException {
        // TODO : Open LUMA and search for "argus"
        LogsUtils.info("Argus is wrote and enter clicked");
        new P01_LandingPage(getDriver())
                .writeValidSearchKeyWord(DataUtils.getJsonData("searchData" , "validSearchKeyword"))
                .clickEnter();
        LogsUtils.info("Got search result product and scroll to it to compare the name");
        Assert.assertEquals(new P04_SearchResultPage(getDriver()).getProductResultNameText() , "Argus All-Weather Tank");
    }

    @Test
    public void checkInvalidSearchTC() throws FileNotFoundException {
        // TODO : Open LUMA and search for "argus"
        LogsUtils.info("@@@ as special Chars is wrote and enter clicked");
        new P01_LandingPage(getDriver())
                .writeValidSearchKeyWord(DataUtils.getJsonData("searchData" , "invalidSearchKeyword"))
                .clickEnter();
        LogsUtils.info("Got no result found and check the msg");
        Assert.assertEquals(new P04_SearchResultPage(getDriver()).getNoResultFoundText() , "Your search returned no results.");
    }

    @AfterMethod
    public void quit() {
        quitDriver();
    }
}
