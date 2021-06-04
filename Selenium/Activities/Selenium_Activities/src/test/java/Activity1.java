import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
	
	public static void main(String[] args) {
		
        System.setProperty("webdriver.gecko.driver", "/Users/saibhavanijeebula/Downloads/Selenium_UDemy/geckodriver");

		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();			
		
		//Open the browser
		driver.get("https://www.training-support.net");
			
		//Close the browser
		driver.close();
	    }

}
