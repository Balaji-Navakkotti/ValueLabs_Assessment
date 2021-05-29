package Assessment.ValueLabs.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Assessment.ValueLabs.Utility.WaitUtility;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class YourCartPageObjects {
	
	AndroidDriver<MobileElement> driver;
	MainPageObjects mainPageObjects;
	WaitUtility waitUtility;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-REMOVE']")
	WebElement yourcartRemoveButton;
	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc='test-CONTINUE SHOPPING']")
	WebElement continueShoppingButton;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-CHECKOUT']")
	WebElement checkout;
	
	By byCheckout = By.xpath("//android.view.ViewGroup[@content-desc='test-CHECKOUT']");
	
	By byFirstname = By.xpath("//android.widget.EditText[@content-desc='test-First Name']");
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc='test-First Name']")
	WebElement firstname;
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc='test-Last Name']")
	WebElement lastname;
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc='test-Zip/Postal Code']")
	WebElement zipcode;
	
	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='test-CONTINUE']")
	WebElement continueButton;
	
	By byContinueButton = By.xpath("//android.view.ViewGroup[@content-desc='test-CONTINUE']");
	
	By byPaymentPage = By.xpath("//*[@class='android.widget.TextView' and @text='CHECKOUT: OVERVIEW']");
	
	@FindBy(xpath = "//*[@class='android.widget.TextView' and @text='CHECKOUT: OVERVIEW']")
	WebElement paymentpageTitle;
	
	public YourCartPageObjects(AndroidDriver<MobileElement> driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitUtility = new WaitUtility();
	}
	
	public void clickRemoveButton()
	{
		yourcartRemoveButton.click();
	}
	
	public void verifyPriceItem()
	{
		mainPageObjects = new MainPageObjects(driver);
		mainPageObjects.firstItemPrice.isDisplayed();
	}
	
	public void continueShoppingButton() {
		continueShoppingButton.click();
	}
	
	public void checkOutButton()
	{
		waitUtility.waitFortheContenttoLoad(byCheckout, 10);		
		checkout.click();
	}
	
	public void sendFirstname(String name)
	{
		waitUtility.waitFortheContenttoLoad(byFirstname, 10);
		firstname.sendKeys(name);
	}
	
	public void sendLastname(String name)
	{
		lastname.sendKeys(name);
	}
	public void sendZipcode(String pincode)
	{
		zipcode.sendKeys(pincode);
	}
	
	public void enterContactDetails(String firstname, String lastname, String pincode)
	{
		sendFirstname(firstname);
		sendLastname(lastname);
		sendZipcode(pincode);
	}
	
	public void clickContinueButton()
	{
		waitUtility.waitFortheContenttoLoad(byContinueButton, 10);
		continueButton.click();
	}
	
	public void verifyPaymentPage()
	{
		waitUtility.waitFortheContenttoLoad(byPaymentPage, 10);
		paymentpageTitle.isDisplayed();
	}
	
}
