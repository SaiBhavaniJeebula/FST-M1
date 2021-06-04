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

public class Activity3 {
	
	AndroidDriver driver;
	
	@BeforeClass
	public void initiateDriver() throws InterruptedException, IOException {
		
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "2eed910sa");
        caps.setCapability("deviceName", "My Phone");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.android.calculator2");
        caps.setCapability("appActivity", ".Calculator");
        caps.setCapability("noReset", true);
 
        // Instantiate Appium Driver
//        AppiumDriver<MobileElement> driver = null;
        try {
            // Initialize driver
        	URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        	driver = new AndroidDriver<MobileElement>(appServer, caps);
        	System.out.println("Calculator is open");
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }        
    }
	
	@Test
	public void calculations() {
		driver.findElementById("digit_5").click();
		driver.findElementById("op_add").click(); 
		driver.findElementById("digit_9").click();
		driver.findElementById("eq").click(); 
		String sum = driver.findElementById("result").getText();   
		System.out.println("Sum of 5 and 9 is: " + sum);
		Assert.assertEquals(sum, "14"); 
		
		driver.findElementById("digit_1").click();
		driver.findElementById("digit_0").click();
		driver.findElementById("op_sub").click(); 
		driver.findElementById("digit_5").click();
		driver.findElementById("eq").click(); 
		String diff = driver.findElementById("result").getText();   
		System.out.println("Difference of 10 and 5 is: " + diff);
		Assert.assertEquals(diff, "5"); 
		
		driver.findElementById("digit_5").click();
		driver.findElementById("op_mul").click(); 
		driver.findElementById("digit_1").click();
		driver.findElementById("digit_0").click();
		driver.findElementById("digit_0").click();
		driver.findElementById("eq").click(); 
		String prod = driver.findElementById("result").getText();   
		System.out.println("Product of 5 and 100 is: " + prod);
		Assert.assertEquals(prod, "500"); 
		
		driver.findElementById("digit_5").click();
		driver.findElementById("digit_0").click();
		driver.findElementById("op_div").click(); 
		driver.findElementById("digit_2").click();
		driver.findElementById("eq").click(); 
		String quo = driver.findElementById("result").getText();   
		System.out.println("Quotient of 50 and 2 is: " + quo);
		Assert.assertEquals(quo, "25"); 
		
	}
	
	
	@AfterClass
	public void quitdriver() {
		driver.quit();
	}
}