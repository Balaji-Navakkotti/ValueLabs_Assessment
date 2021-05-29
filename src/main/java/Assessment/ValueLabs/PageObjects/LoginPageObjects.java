package Assessment.ValueLabs.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class LoginPageObjects {

	AndroidDriver<MobileElement> driver;
	Dimension windowSize;
	WebDriverWait wait;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-standard_user']")
	MobileElement credentials;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-LOGIN']")
	MobileElement loginButton;
	
	By loginelement = By.xpath("//android.view.ViewGroup[@content-desc='test-LOGIN']");

	public LoginPageObjects(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public void selectCredentials() {
		credentials.click();
	}

	public void scrollThePage() {
		//Getting the size of the window size
		Dimension size = driver.manage().window().getSize();
		//calculating the size of the window
		int startX = (int) (size.width * 0.5);
		int starty = (int) (size.height * 0.75);
		int endX = (int) (size.width * 0.5);
		int endy = (int) (size.height * 0.2);
		
		new TouchAction(driver).press(PointOption.point(startX, starty))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
				.moveTo(PointOption.point(endX, endy))
				.release().perform();
	}
	
	public void waitForLoginButton()
	{
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(loginelement));
	}
	
	
}
