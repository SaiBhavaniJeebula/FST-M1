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
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Activity2 {
	
	AndroidDriver driver;
	
	@BeforeClass
	public void initiateDriver() throws InterruptedException, IOException {
		
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "2eed910sa");
        caps.setCapability("deviceName", "My Phone");
        caps.setCapability("platformName", "Android");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);
 
        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);  
        System.out.println("Chrome is Launched");
    }
	
	@Test
	public void printTitleOfWebPages() throws InterruptedException {
		
		driver.get("https://www.training-support.net/");
		Thread.sleep(1000);
		String firstWebPageTitle = driver.findElementByXPath("//android.view.View[@text='Training Support']").getText();
		System.out.println("First Web Page Title: " + firstWebPageTitle);
		driver.findElementByXPath("//android.view.View[@text='About Us']").click();
		Thread.sleep(1000);
		String secondWebPageTitle = driver.findElementByXPath("//android.view.View[@text='About Us']").getText();
		System.out.println("Second Web Page Title: " + secondWebPageTitle);
//		System.out.println("First Web Page Title: " + secondWebPageTitle);
		
	}
	
	@AfterClass
	public void quitdriver() {
		driver.quit();
	}
}