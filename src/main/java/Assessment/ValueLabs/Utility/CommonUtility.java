package Assessment.ValueLabs.Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CommonUtility {
	
		private WebDriver driver;

		public CommonUtility(WebDriver driver) {
			this.driver = driver;
		}

		public void maximizeBrowser() {
			driver.manage().window().maximize();
		}
}
