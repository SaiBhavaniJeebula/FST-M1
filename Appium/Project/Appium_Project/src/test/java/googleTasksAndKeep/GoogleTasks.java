package googleTasksAndKeep;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class GoogleTasks {
	
	AndroidDriver driver;
	
	@BeforeClass
	public void initiateDriver() throws InterruptedException, IOException {
		
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "2eed910sa");
        caps.setCapability("deviceName", "My Phone");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("ensureWebviewsHavePages", true); 
        
        // Instantiate Appium Driver
        try {
            // Initialize driver
            driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
            System.out.println("Google Tasks app is open");
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }        
    }
	
	@Test
	public void activity1() throws InterruptedException {
		
		Thread.sleep(3000);
//		WebDriverWait wait = null;
//		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementById("welcome_get_started")));
		driver.findElementById("welcome_get_started").click();
		
		createTasks("Complete Activity with Google Tasks");
		createTasks("Complete Activity with Google Keep");
		createTasks("Complete second Activity with Google Keep");
		
	}
	
	public void createTasks(String titleText) throws InterruptedException {
		
		String title = titleText;
		
		Thread.sleep(500);
		driver.findElementByAccessibilityId("Create new task").click();
		Thread.sleep(500);
		driver.findElementById("add_task_title").sendKeys(title);
		driver.findElementById("add_task_done").click();
		Thread.sleep(500);
		driver.findElementById("task_name").click();
		Assert.assertEquals(driver.findElementById("edit_title").getText(), title);
		Thread.sleep(1000);
		driver.findElementById("edit_task_complete_button").click();
		Thread.sleep(500);
		
	}
	
	
	@AfterClass
	public void quitdriver() {
		driver.quit();
	}

}
