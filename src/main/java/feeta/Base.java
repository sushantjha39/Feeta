package feeta;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public static ChromeOptions options;
	public static ChromeDriver driver;
	public static Duration waitDuration;
	public static WebDriverWait wait;
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;

	public static void login() throws IOException, InterruptedException {
		String base = "https://feeta-test.jugaadathon.com/dashboard/collections";
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");

		driver = new ChromeDriver(options);
		waitDuration = Duration.ofSeconds(10);
		wait = new WebDriverWait(driver, waitDuration);

		driver.manage().window().maximize();
		driver.get(base);

		String instructionString = "Use your lattice account to login to the application";

		WebElement instruction = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[text()='Use your lattice account to login to the']")));
		WebElement instruction1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='application']")));
		boolean isValid1 = istextValid(instruction, instructionString, instruction1);

		if (isValid1) {
			System.out.println(" Instruction is correct");
		} else {
			System.out.println("Incorrect instruction");
		}

		WebElement Login = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\" LOGIN \"]")));

		if (Login.getText().equals("LOGIN")) {
			System.out.println(" Text is LOGIN");
		} else {
			System.out.println("Text is Not Login");
		}

		Login.click();
		WebElement Invalidemail = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-label='Email or phone']")));
		Invalidemail.sendKeys("Learningperspective081@gmail.com");
		WebElement Invalidnext = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']")));
		Invalidnext.click();
		WebElement tryagain = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Try again']")));
		tryagain.click();
		WebElement Validemail = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-label='Email or phone']")));
		Validemail.sendKeys("sushant@thelattice.in");
		WebElement Validnext = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next']")));
		Validnext.click();
		WebElement Validpassword = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-label='Enter your password']")));
		Validpassword.sendKeys("Sushantjha39^");
		WebElement Validnext1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Next1']")));
		Validnext1.click();
	}

//	@BeforeTest
//	public void setExtent() {
//		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "./test-output/myReport.html");
//		extent = new ExtentReports();
//		extent.attachReporter(htmlReporter);
//		extent.setSystemInfo("Hostname", "LocalHost");
//		extent.setSystemInfo("OS", "Windows 11");
//		extent.setSystemInfo("Tester Name", "sushant");
//		extent.setSystemInfo("Browser", "LocalHost");
//
//	}
//
//	@AfterTest
//	public void endReport() {
//		extent.flush();
//	}
//
//	@AfterMethod
//	public void teardown(ITestResult result) throws IOException {
//		if (result.getStatus() == ITestResult.FAILURE) {
//			test.log(Status.FAIL, "TEST CASE FAILED IS" + result.getName()); // to add name in extent report
//			test.log(Status.FAIL, "TEST CASE FAILED IS" + result.getThrowable());// to add error/exception in extent
//																					// report
//
//			String screenshotPath = Extentreport.getScreenshot(driver, result.getName());
//			test.addScreenCaptureFromPath(screenshotPath); // adding screenshot
//		} else if (result.getStatus() == ITestResult.SKIP) {
//			test.log(Status.SKIP, "Test case SKIPPED IS " + result.getName());
//		}
//
//		else if (result.getStatus() == ITestResult.SUCCESS) {
//			test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
//
//		}
//
//	}
//
//	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
//		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File source = ts.getScreenshotAs(OutputType.FILE);
//
//		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
//		File finalDestination = new File(destination);
//		FileUtils.copyFile(source, finalDestination);
//		return destination;
//	}

	public static void applyforleave() {
		WebElement applyforleave = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='APPLY FOR LEAVE']")));
		applyforleave.click();
		boolean isClick = wait.until(ExpectedConditions.elementToBeClickable(applyforleave)) != null;
		if (isClick) {
			System.out.println("Apply for Leave field is clickable");
		} else {
			System.out.println("Apply for Leave field is not clickable");
		}

	}

	public static void selectManager() throws InterruptedException {
		WebElement selectManager = wait.until(ExpectedConditions
				.visibilityOfElementLocated((By.cssSelector("[formcontrolname=\"managerNameFormControl\"]"))));
		Thread.sleep(2000);
		selectManager.click();
		WebElement managername = driver.findElement(By.xpath("//mat-option//*[text()=' Himanshu Rawat ']"));
		managername.click();
		Thread.sleep(2000);
	}

	public static void dateselector() {
		WebElement dateElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("svg.mat-datepicker-toggle-default-icon")));
		dateElement.click();
	}

	public static void submitbutton() throws InterruptedException {
		WebElement Submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='SUBMIT']")));
		Submit.click();
		driver.navigate().refresh();
		WebElement itemsperpage = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[aria-label=\"Items per page:\"]")));
		itemsperpage.click();

		WebElement selectperpage = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[@class='mat-option-text' and text()=' 20 ']")));
		selectperpage.click();
		Thread.sleep(1000);
	}

	private static boolean istextValid(WebElement instruction, String instructionString, WebElement instruction1) {
		String instructiontext = instruction.getText();
		String instructiontext2 = instruction1.getText();
		return instructionString.equals(instructiontext + " " + instructiontext2);
	}

	private static boolean isImageValid(WebElement imageElement, String headingname) {
		String actualImagePath = imageElement.getAttribute("src");
		return actualImagePath.equals(headingname);

	}

}
