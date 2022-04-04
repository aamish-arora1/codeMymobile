package Practice.AppiumTestAutoamtion;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

/* base class contains driver setup and common util methods */
public class testBase {
	static AppiumDriver driver;
	Properties props;
	public testBase() throws IOException
	{
		//Load properties file stored in src/main/resources
		
		props = new Properties();
		  String propFileName = "resources/config.properties";
		  PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		  InputStream is = getClass().getClassLoader().getResourceAsStream(propFileName);
		  props.load(is);
	}
//@beforeTest
	public AppiumDriver initialise() throws MalformedURLException
	{
		//intialize and setup driver
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, props.getProperty("androidAutomationName"));	
		desiredCapabilities.setCapability("appPackage", props.getProperty("androidAppPackage"));
		desiredCapabilities.setCapability("appActivity", props.getProperty("androidAppActivity"));
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, props.getProperty("androidplatformVersion"));
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, props.getProperty("androiddeviceName"));
		desiredCapabilities.setCapability(MobileCapabilityType.UDID, props.getProperty("androidudid"));

		 driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
		 return driver;
	}
	
	public void waitForElementVisible(WebElement element)
	{
		//wait for element to be visible 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40)); wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void enterText(String str)
	{
		// enter text from keyboard
		
		 Actions a = new Actions(driver);
	        a.sendKeys(str);
	        a.perform();
	       driver.navigate().back();
	}
	
	
	public void scrollDown( )

	{
		//scroll down the screen
		
		new TouchAction((PerformsTouchActions) driver)
		.press(PointOption.point(566, 1616))
		.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
		.moveTo(PointOption.point(566, 200))
		.release().perform();
	}
	
	
	}
