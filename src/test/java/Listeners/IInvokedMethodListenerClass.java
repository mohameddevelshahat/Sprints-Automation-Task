package Listeners;

import Utilities.LogsUtils;
import Utilities.Utility;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

import static DriverFactory.DriverFactory.getDriver;

public class IInvokedMethodListenerClass implements IInvokedMethodListener {

    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
    }

    // This function is being running after the tests is failed and take a screenshot
    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {

        // This Line to take a full screenshot and highlight to the cart icon in the Landing page
        // Utility.takeFullScreenShot(getDriver(), new P02_LandingPage(getDriver()).getNumberOfSelectedProductsOnCart());

        if (testResult.getStatus() == ITestResult.FAILURE) {
            LogsUtils.info("The Test Cases" + " " + testResult.getName() + " " + "Failed");
            Utility.takeScreenShots(getDriver(), testResult.getName());
        }
    }
}
