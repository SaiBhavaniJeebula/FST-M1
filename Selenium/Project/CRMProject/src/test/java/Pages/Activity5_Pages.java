package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Activity5_Pages {
	
	WebDriver driver;
	String navigationColour;
	
	By navigationMenu = By.id("toolbar");
	
	public Activity5_Pages(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getNavigationMenuColour() {
		navigationColour = driver.findElement(navigationMenu).getCssValue("color");
		System.out.println(navigationColour);
		System.out.println("Activity 5 is successfully completed");
	}

}
