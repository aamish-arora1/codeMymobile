package Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Practice.AppiumTestAutoamtion.testBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class workOrder extends testBase {
	AppiumDriver driver;
	public workOrder(AppiumDriver driver) throws IOException {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(id="com.onupkeep:id/bottom_nav_center")
	private WebElement addOption;
	
	@AndroidFindBy(id="com.onupkeep:id/action_item_create_work_order")
	private WebElement workOrder;
	
	@AndroidFindBy(id="com.onupkeep:id/work_order_title")
	private WebElement woTitle;
	
	@AndroidFindBy(id="com.onupkeep:id/additional_notes")
	private WebElement woDesc;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Aamish Arora\"]")
	private WebElement addWorker;
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@resource-id='com.onupkeep:id/add_support_user_layout']//child::android.widget.ImageView")
	private WebElement additionalWorker;
	
	@AndroidFindBy(id="com.onupkeep:id/button_save_delete")
	private WebElement saveWO;
	
	
	public void clickAddOption()
	{
		waitForElementVisible(addOption);
		addOption.click();
	}
	
	public void clickWorkOrder()
	{
		waitForElementVisible(workOrder);
		workOrder.click();
	}
	
	public void addWorkTitle(String str,String desc)
	{
		waitForElementVisible(woTitle);
		woTitle.sendKeys(str);
		woDesc.sendKeys(desc);
	}
	
	public void addWorkPriority(String priority)
	{
		String str="none";
		if(priority=="Low")
			str="one";
		else if(priority=="Medium")
			str="two";
		else if(priority=="High")
			str="three";
		driver.findElement(By.id("com.onupkeep:id/"+str));
	}
	public void addWorkerDetails()
	{
		waitForElementVisible(additionalWorker);
		additionalWorker.click();
		addWorker.click();
	}
	
	public void saveWorkOrder()
	{
		scrollDown();
		saveWO.click();
	}
}
