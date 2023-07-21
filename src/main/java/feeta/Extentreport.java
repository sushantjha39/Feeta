package feeta;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreport extends Base {
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeTest
	public void setExtent() {
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "./test-output/myReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("OS", "Windows 11");
		extent.setSystemInfo("Tester Name", "sushant");
		extent.setSystemInfo("Browser", "LocalHost");

	}

	@AfterTest
	public void endReport() {
		extent.flush();
	}

	@AfterMethod
    public void teardown(ITestResult result, ExtentTest test) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            if (test != null) {
                test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName());
                test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable());

                String screenshotPath = getScreenshot(driver, result.getName());
                test.addScreenCaptureFromPath("/Screenshots");
            } else {
                System.out.println("Test object is null in teardown()");
            }
        } else if (result.getStatus() == ITestResult.SKIP) {
            if (test != null) {
                test.log(Status.SKIP, "Test case SKIPPED IS " + result.getName());
            } else {
                System.out.println("Test object is null in teardown()");
            }
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            if (test != null) {
                test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
            } else {
                System.out.println("Test object is null in teardown()");
            }
        }
    }

	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
}