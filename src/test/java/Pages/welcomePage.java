package Pages;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Practice.AppiumTestAutoamtion.testBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class welcomePage extends testBase{
	AppiumDriver driver;
	String buisness;
	
	public welcomePage(AppiumDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id="com.onupkeep:id/button_sign_up")
	private WebElement signUp;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='Log in.']")
	public WebElement logIn;
	
	@AndroidFindBy(id="com.onupkeep:id/textinput_placeholder")
	private WebElement email;
	
	@AndroidFindBy(id="com.onupkeep:id/edit_text_password")
	private WebElement pass;
	
	@AndroidFindBy(id="com.onupkeep:id/edit_text_first_name")
	private WebElement firstName;
	
	@AndroidFindBy(id="com.onupkeep:id/edit_text_last_name")
	private WebElement lastName;
	
	@AndroidFindBy(id="com.onupkeep:id/edit_text_phone_number")
	private WebElement phone;
	
	@AndroidFindBy(id="com.onupkeep:id/edit_text_company_name")
	private WebElement cmpnyName;
	
	@AndroidFindBy(id="com.onupkeep:id/edit_text_job_title")
	private WebElement title;
	
	@AndroidFindBy(id="com.onupkeep:id/button_signup")
	private WebElement getStarted;
	
	@AndroidFindBy(id="com.onupkeep:id/tv_facility_building")
	private WebElement buisnessBuilding;

	@AndroidFindBy(id="com.onupkeep:id/action_settings")
	private WebElement settings;

	@AndroidFindBy(id="com.onupkeep:id/rl_logout")
	private WebElement logOut;
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement okButton;
	
	
	public void clickSignUp()
	{
		waitForElementVisible(signUp);
		signUp.click();
	}
	
	public void clickLogIn()
	{
		logIn.click();
	}
	
	public void fillDetails(String email,String pass,String name,String lastName,String phone,String companyName,String title)
	{
		waitForElementVisible(this.email);
		this.email.click();
		enterText(email);
		this.pass.sendKeys(pass);
		this.firstName.sendKeys(name);
		this.lastName.sendKeys(lastName);
		this.phone.sendKeys(phone);
		this.cmpnyName.sendKeys(companyName);
		this.title.sendKeys(title);
	}
	
	public void clickGetStarted()
	{
		getStarted.click();
	}
	
	public void selectBuisnessType(String str)
	{
		buisnessBuilding.click();
	}
	
	public void clickSettings()
	{
		waitForElementVisible(settings);
		settings.click();
		Assert.assertTrue(logOut.isDisplayed());
	}
	
	public void clickLogOut()
	{
		waitForElementVisible(logOut);
		logOut.click();
		waitForElementVisible(okButton);
		okButton.click();
		Assert.assertTrue(signUp.isDisplayed());
	}
}
