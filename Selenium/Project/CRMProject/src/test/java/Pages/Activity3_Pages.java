package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Activity3_Pages {
	
	WebDriver driver;
	String firstCopyrightText;
	
	By firstCopyrightTextElement = By.id("admin_options");
	
	public Activity3_Pages(WebDriver driver) {
		this.driver = driver;
	}
	
	public void printFirstCopyrightText() {
		firstCopyrightText = driver.findElement(firstCopyrightTextElement).getText();
		System.out.println("First Copyright Text in the Footer is: " +firstCopyrightText);
		System.out.println("Activity 3 is successfully completed");
	}

}
