package TestUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class BaseClass {
	
	public WebDriver driver;
	public static Properties prop;
	public String appURL;
	
	public WebDriver initializeDriver() throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/testUtils/data.properties");
		prop.load(fis);
		
		driver = new SafariDriver();
		appURL = prop.getProperty("url");
		driver.get(appURL);
		
		return driver;
		
	}
	
//	public void forceClickElement(WebElement infoIcon, WebDriver driver) {
//		WebElement element = infoIcon;
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", element);
//	}
	

}
