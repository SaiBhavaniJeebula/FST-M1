import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Activity4 {
	
	AndroidDriver driver;
	
	@BeforeClass
	public void initiateDriver() throws InterruptedException, IOException {
		
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "2eed910sa");
        caps.setCapability("deviceName", "My Phone");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.android.contacts");
        caps.setCapability("appActivity", ".activities.PeopleActivity");
        caps.setCapability("noReset", true);
 
        // Instantiate Appium Driver
//        AppiumDriver<MobileElement> driver = null;
        try {
            // Initialize driver
        	URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        	driver = new AndroidDriver<MobileElement>(appServer, caps);
        	System.out.println("Contacts is open");
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }        
    }
	
	@Test
	public void addAndVerifyContacts() throws InterruptedException {
		driver.findElementByAccessibilityId("Create new contact").click();
		Thread.sleep(500);
//		driver.findElementByXPath("//android.widget.EditText[@text='First name']").click();
		driver.findElementByXPath("//android.widget.EditText[@text='First name']").sendKeys("Aaditya");
		driver.findElementByXPath("//android.widget.LinearLayout/android.widget.EditText[2][@text='Last name']").sendKeys("Varma");
		driver.findElementByXPath("//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText[@text='Phone']").sendKeys("999148292");
		driver.findElementById("com.android.contacts:id/editor_menu_save_button").click();
		Thread.sleep(1000);
		String contactName = driver.findElementById("large_title").getText();
		Assert.assertEquals(contactName, "Aaditya Varma");
		
	}
	
	
	@AfterClass
	public void quitdriver() {
		driver.quit();
	}
}