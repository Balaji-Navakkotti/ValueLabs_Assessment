package Assessment.ValueLabs.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitUtility extends TestBase_Setup {
	
		private WebDriverWait wait;

		public void waitFortheContenttoLoad(By element, long timeOutInSeconds) {
			wait = new WebDriverWait(mobileDriver, timeOutInSeconds);
			wait.until(ExpectedConditions.presenceOfElementLocated(element));
		}
}
