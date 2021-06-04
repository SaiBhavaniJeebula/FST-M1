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

public class Activity1 {
	
	AndroidDriver driver;
	
	@BeforeClass
	public void initiateDriver() throws InterruptedException, IOException {
		
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "2eed910sa");
        caps.setCapability("deviceName", "My Phone");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.android.calculator2");
        caps.setCapability("appActivity", "com.android.calculator2.Calculator");
 
        // Instantiate Appium Driver
//        AppiumDriver<MobileElement> driver = null;
        try {
            // Initialize driver
            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
            System.out.println("Calculator is open");
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }        
    }
	
	@Test
	public void add() {
		driver.findElementById("com.android.calculator2:id/digit_8").click();
		driver.findElementById("op_add").click();
		driver.findElementById("digit_9").click();
		driver.findElementById("eq").click();
		
		String result = driver.findElementById("result").getText();
		
		Assert.assertEquals(result, "17");
		
		System.out.println("Addition is Successfull");		
	
	}
	
	@AfterClass
	public void quitdriver() {
		driver.quit();
	}
	
}
