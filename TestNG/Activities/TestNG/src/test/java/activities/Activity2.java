package activities;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity2 {
	WebDriver driver;
	@BeforeTest
	public void beforeMethod() {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/target-practice");
	}
	@Test
	public void firstTest() {
		String title = driver.getTitle();
		System.out.println("Title is " + title);
		AssertJUnit.assertEquals(title, "Title Practice");
	}

}
