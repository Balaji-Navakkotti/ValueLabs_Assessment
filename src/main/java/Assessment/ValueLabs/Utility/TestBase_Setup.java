package Assessment.ValueLabs.Utility;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Assessment.ValueLabs.Common.GenerateExtentReport;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestBase_Setup {

	protected static WebDriver webDriver;
	protected static AndroidDriver<MobileElement> mobileDriver;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static Logger log;
	public static String className;
	private CommonUtility commonUtility;
	private GenerateExtentReport generateExtentReport;
	public String mode;

	@BeforeTest
	public void initializeDriver() throws MalformedURLException {
		DesiredCapabilities capabilities = DesiredCapabilities.android();
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "10");
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("browserName", "");
		capabilities.setCapability("autoGrantPermissions", "true");
		capabilities.setCapability("app",
				System.getProperty("user.dir")+"/app/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
		;
		capabilities.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");
		capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
		mobileDriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		generateExtentReport = new GenerateExtentReport();
		generateExtentReport.init();
	}

	@BeforeClass
	public void getClassName() {
		className = this.getClass().getSimpleName();
		log = LogManager.getLogger(className);
	}

	@BeforeMethod
	public void browserInit(Method methodName) {
		logger = extent.startTest(className + " Started");
	}

	@AfterMethod
	public void endMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
			String screenshotPath = generateExtentReport.getScreenshot();
			// To add it in the extent report
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(LogStatus.PASS, "Test Case Passed is " + result.getName());
		}
		extent.endTest(logger);
	}

	@AfterTest
	public void endReport() {
		extent.flush();
		mobileDriver.quit();
	}
}
