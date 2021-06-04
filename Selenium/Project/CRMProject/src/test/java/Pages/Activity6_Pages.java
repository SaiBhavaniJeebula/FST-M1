package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Activity6_Pages {

	WebDriver driver;
	
	By activityMenu = By.linkText("Activities");
	
	public Activity6_Pages(WebDriver driver) {
		this.driver = driver;
	}
	
	public void activityMenu() {
		driver.manage().window().maximize();
		Assert.assertTrue(driver.findElement(activityMenu).isDisplayed(), "Activity menu item does not exists");
		System.out.println("Activity 6 is successfully completed");
	}
}
