package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity9_Pages extends Activity7_Pages {
	
	WebDriver driver;
	String name;
	String user;
	
	public Activity9_Pages(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void printFirstTenRowsNameUserColumns() throws InterruptedException {
		driver.findElement(salesOption).click();
        wait = new WebDriverWait(driver,5);
		driver.findElement(leadsOption).click();
		//wait.until(ExpectedConditions.elementToBeClickable(additionalDetails));
		Thread.sleep(3000);
		
		for(int x=1; x<11; x++) {
			name = driver.findElement(By.xpath("//div[@class='list-view-rounded-corners']/table/tbody/tr["+x+"]/td[3]/b/a")).getText();
			System.out.println(x + ":");
			System.out.println("Name:" + name);
			
			user = driver.findElement(By.xpath("//div[@class='list-view-rounded-corners']/table/tbody/tr["+x+"]/td[8]/a")).getText();
			System.out.print("User:" + user);
		}
		
		System.out.println("Activity 9 is successfully completed");
	}

}
