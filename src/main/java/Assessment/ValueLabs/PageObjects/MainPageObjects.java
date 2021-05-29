package Assessment.ValueLabs.PageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MainPageObjects {

	AndroidDriver<MobileElement> driver;

	@FindBy(xpath = "//android.widget.TextView[@content-desc='test-Price']")
	WebElement firstItemPrice;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-ADD TO CART']")
	WebElement firstBookButton;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-REMOVE']")
	WebElement removeButton;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Cart']")
	WebElement yourcartButton;

	public MainPageObjects(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void selectFirstItem() {
		firstBookButton.click();
	}

	public void navigateToYourcart() {
		yourcartButton.click();
	}

	public void verifyRemoveButton() {
		removeButton.isDisplayed();
	}
}
