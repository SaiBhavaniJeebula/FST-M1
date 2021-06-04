package Pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Activity1_Pages {
	
	WebDriver driver;
	String appTitle;
	
	public Activity1_Pages(WebDriver driver) {
		this.driver = driver;
	}
	
	public void validateAppTitle() {
		appTitle = driver.getTitle();
		Assert.assertEquals("SuiteCRM", appTitle);
		System.out.println("Activity 1 is successfully completed");
	}

}
