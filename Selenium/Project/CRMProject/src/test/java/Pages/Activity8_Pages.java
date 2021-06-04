package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import TestUtils.BaseClass;

public class Activity8_Pages extends Activity7_Pages{
	
	WebDriver driver;
	WebDriverWait wait;
	String name;
	
	By accountsOption = By.xpath("//*[@id='moduleTab_9_Accounts']");

	public Activity8_Pages(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void printFirstFiveOddNumberedRows() throws InterruptedException {
		driver.findElement(salesOption).click();
	    wait = new WebDriverWait(driver,5);
	    driver.findElement(accountsOption).click();
	    
	    //wait.until(ExpectedConditions.attributeContains(filterIcon, "title", "Filter"));
	    Thread.sleep(3000);
	   		
		for(int x=1; x<10; x+=2) {
			name = driver.findElement(By.xpath("//div[@class='list-view-rounded-corners']/table/tbody/tr["+x+"]/td[3]/b/a")).getText();
			System.out.print(x + ":" + name);
		}
		
		System.out.println("Activity 8 is successfully completed");
	}
}
