package Tests;
import Listeners.IInvokedMethodListenerClass;
import Listeners.ITestResultListenerClass;
import Pages.P01_LandingPage;
import Utilities.DataUtils;
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
public class TC01_LandingTest {

    @BeforeMethod
    public void setup() throws IOException {

        setupDriver(getPropertyValue("environment", "browser"));
        LogsUtils.info("Chrome Driver is Opened");
        getDriver().get(getPropertyValue("environment", "BASE_URL"));
        LogsUtils.info("Page is redirected to the LUMA");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void WriteValidSearchKeyWordTC() throws FileNotFoundException {
        LogsUtils.info("Argus is Wrote");
        new P01_LandingPage(getDriver()).writeValidSearchKeyWord(DataUtils.getJsonData("searchData" , "validSearchKeyword"));

    }

    @Test
    public void WriteValidSearchKeyWordAndClickEnterTC() throws FileNotFoundException {
        LogsUtils.info("Argus is Wrote");
        new P01_LandingPage(getDriver()).writeValidSearchKeyWord(DataUtils.getJsonData("searchData" , "validSearchKeyword"))
                .clickEnter();

    }

    @AfterMethod
    public void quit() {
        quitDriver();
    }
}