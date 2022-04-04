package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import Practice.AppiumTestAutoamtion.testBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class logInPage extends testBase{
	AppiumDriver driver;
	public logInPage(AppiumDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Log in.']")
	public WebElement logIn;
	
	@AndroidFindBy(id="com.onupkeep:id/textinput_placeholder")
	public WebElement userName;
	
	@AndroidFindBy(id="com.onupkeep:id/edit_text_password")
	public WebElement pass;
	
	@AndroidFindBy(id="com.onupkeep:id/login_button")
	public WebElement logInButton;
	
	public void clickLogin()
	{
		waitForElementVisible(logIn);
		logIn.click();
		Assert.assertTrue(userName.isDisplayed());
	}
	
	public void logIn(String user,String passWord)
	{
		userName.click();
		enterText(user);
		pass.sendKeys(passWord);
		logInButton.click();
	}
	
}
