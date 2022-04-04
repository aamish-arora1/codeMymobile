package Practice.AppiumTestAutoamtion;

import java.io.IOException;
import org.testng.annotations.Test;
import Pages.logInPage;
import Pages.welcomePage;
import Pages.workOrder;
import io.appium.java_client.AppiumDriver;

public class LoginPageStep extends testBase {

	welcomePage wc;
	workOrder wo;
	logInPage li;
	AppiumDriver driver;
	
	public LoginPageStep() throws IOException {
		driver=initialise();
		wc=new welcomePage(driver);
		wo=new workOrder(driver);
		li=new logInPage(driver);
	}
	
	@Test(enabled=false)
	public void signUp()
	{
		wc.clickSignUp();
		wc.fillDetails("abcd@abcd.com", "Abcdef@123", "ab", "cd", "123456789", "abab", "Mr");
		wc.clickGetStarted();
		wc.selectBuisnessType("skip");
	}
	
	@Test(priority=1)
	public void logIn()
	{
		li.clickLogin();
		li.logIn("aamish.arora1@gmail.com", "Aamish1996");
	}
	
	@Test(priority=2)
	public void createWorkOrder()
	{
		wo.clickAddOption();
		wo.clickWorkOrder();
		wo.addWorkTitle("Test","testing");
		wo.addWorkPriority("Low");
		wo.addWorkerDetails();
		wo.saveWorkOrder();
	}
	
	@Test(priority=3)
	public void appLogOut()
	{
		wc.clickSettings();
		wc.clickLogOut();
	}


}
