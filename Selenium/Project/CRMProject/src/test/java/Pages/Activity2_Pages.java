package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Activity2_Pages {
	
	WebDriver driver;
	String headerImgURL;
	
	By headerImg = By.xpath("//img[@alt='SuiteCRM']");
	
	public Activity2_Pages(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getHeaderImgURL() {
		headerImgURL = driver.findElement(headerImg).getAttribute("src");
		System.out.println("Header Image URL is: " + headerImgURL);
		System.out.println("Activity 2 is successfully completed");
	}

}
