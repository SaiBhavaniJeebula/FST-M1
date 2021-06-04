package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import TestUtils.BaseClass;

public class Activity4_Pages extends BaseClass{
	
	WebDriver driver;
	WebDriverWait wait;
	
	By username = By.id("user_name");
	By password = By.id("username_password");
	By loginButton = By.id("bigbutton");
	By actionsTab = By.id("tab-actions");
			
	public Activity4_Pages(WebDriver driver) {
		this.driver = driver;
	}
	
	public void loginApp() {
		driver.findElement(username).sendKeys(prop.getProperty("username"));
		driver.findElement(password).sendKeys(prop.getProperty("password"));
		driver.findElement(loginButton).click();
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(actionsTab));
		Assert.assertTrue(driver.findElement(actionsTab).isEnabled(), "App is not logged in");
		System.out.println("Activity 4 is successfully completed");
	}

}
