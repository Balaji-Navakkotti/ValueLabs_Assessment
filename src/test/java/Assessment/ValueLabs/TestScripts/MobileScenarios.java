package Assessment.ValueLabs.TestScripts;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import Assessment.ValueLabs.PageObjects.LoginPageObjects;
import Assessment.ValueLabs.PageObjects.MainPageObjects;
import Assessment.ValueLabs.PageObjects.YourCartPageObjects;
import Assessment.ValueLabs.Utility.TestBase_Setup;
import Assessment.ValueLabs.Utility.WaitUtility;
import io.appium.java_client.remote.YouiEngineCapabilityType;

public class MobileScenarios extends TestBase_Setup {

	LoginPageObjects loginPageObjects;
	MainPageObjects mainPageObjects;
	YourCartPageObjects yourCartPageObjects;

	@Test(priority = 0)
	public void LoginScenario() {

		loginPageObjects = new LoginPageObjects(mobileDriver);
		// waiting for the login button to be displayed in the screen
		loginPageObjects.waitForLoginButton();

		// Sending Search query to the youtube search textbox and
		log.info("Application is Launched in the mobile");
		loginPageObjects.scrollThePage();

		loginPageObjects.selectCredentials();

		log.info("Application scrolled the page");
		loginPageObjects.clickLoginButton();
		log.info("Login button is clicked");
	}

	@Test(priority = 1)
	public void SelectItemAndRemove() throws InterruptedException {

		mainPageObjects = new MainPageObjects(mobileDriver);

		log.info("main page is displayed");
		mainPageObjects.selectFirstItem();

		log.info("First item is selected");
		mainPageObjects.navigateToYourcart();

		log.info("yourcart page is displayed");
		yourCartPageObjects = new YourCartPageObjects(mobileDriver);
		yourCartPageObjects.verifyPriceItem();

		yourCartPageObjects.clickRemoveButton();
		log.info("item in yourcart is removed");
	}

	@Test(priority = 2)
	public void SelectTheProductandCompleteCheckout() throws InterruptedException {

		mainPageObjects = new MainPageObjects(mobileDriver);
		// Tap on continue shopping
		log.info("Click on continue shopping");
		yourCartPageObjects.continueShoppingButton();
		
		// Select an item
		log.info("main page is displayed");
		mainPageObjects.selectFirstItem();
		
		// Navigate to yourcart
		log.info("First item is selected");
		mainPageObjects.navigateToYourcart();
		
		log.info("Tap on checkOut Button ");
		yourCartPageObjects.checkOutButton();
		
		// Enter the required contact details
		log.info("Enter contact details");
		yourCartPageObjects.enterContactDetails("Test", "One", "560103");
		
		log.info("Clicked on continue button");
		yourCartPageObjects.clickContinueButton();
		
		log.info("Verify the payment page is displayed");
		yourCartPageObjects.verifyPaymentPage();
	}

}
