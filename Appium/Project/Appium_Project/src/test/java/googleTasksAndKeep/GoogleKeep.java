package googleTasksAndKeep;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class GoogleKeep {
	
	AndroidDriver driver;
	
	@BeforeClass
	public void initiateDriver() throws InterruptedException, IOException {
		
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "2eed910sa");
        caps.setCapability("deviceName", "My Phone");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("ensureWebviewsHavePages", true); 
        
        // Instantiate Appium Driver
        try {
            // Initialize driver
            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
            System.out.println("Google Keep app is open");
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }        
    }
	
	@Test
	public void activity2() throws InterruptedException {
		
		Thread.sleep(1000);
		driver.findElementById("skip_welcome").click();
		Thread.sleep(500);
		driver.findElementByAccessibilityId("New text note").click();
		Thread.sleep(500);
		driver.findElementById("editable_title").sendKeys("Google Keep1 Title");
		driver.findElementById("edit_note_text").sendKeys("Google Keep1 Desc");
		driver.findElementByAccessibilityId("Open navigation drawer").click();
		Thread.sleep(1000);
		String Title = driver.findElementById("index_note_title").getText();
		Assert.assertEquals(Title, "Google Keep1 Title");
		String Desc = driver.findElementById("index_note_text_description").getText();
		Assert.assertEquals(Desc, "Google Keep1 Desc");
		Thread.sleep(500);
		
	}
	
	@Test
	public void activity3() throws InterruptedException {
		
		Thread.sleep(1000);
		driver.findElementByAccessibilityId("New text note").click();
		Thread.sleep(500);
		driver.findElementById("editable_title").sendKeys("Google Keep2 Title");
		driver.findElementById("edit_note_text").sendKeys("Google Keep2 Desc");
		Thread.sleep(500);
		driver.findElementById("menu_switch_to_list_view").click();
		Thread.sleep(500);
//		driver.findElementByXPath("//android.widget.TextView[@text='Pick a date & time']").click();
//		Thread.sleep(500);
		(new TouchAction(driver)).tap(494, 1089).perform();
		driver.findElementByXPath("//android.widget.TextView[@text='Today']").click();
		Thread.sleep(500);
		(new TouchAction(driver)).tap(389, 1199).perform();
		Thread.sleep(500);
		driver.findElementByXPath("//android.widget.TextView[@text='Afternoon']").click();
		Thread.sleep(500);
		driver.findElementById("save").click();
		Thread.sleep(1000);
		driver.findElementByAccessibilityId("Open navigation drawer").click();
		Thread.sleep(1000);
		Assert.assertTrue(driver.findElementById("reminder_chip_text").isDisplayed());
		(new TouchAction(driver)).tap(124, 824).perform();
		String Title = driver.findElementById("editable_title").getText();
		Assert.assertEquals(Title, "Google Keep2 Title");
		String Desc = driver.findElementById("edit_note_text").getText();
		Assert.assertEquals(Desc, "Google Keep2 Desc");
		Thread.sleep(500);
		
	}
	
	@AfterClass
	public void quitdriver() {
		driver.quit();
	}

}
