package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity7_Pages {
	
	WebDriver driver;
	WebDriverWait wait;
	List<WebElement> infoIcons;
	WebElement infoIcon;
	String phnNoText;
	
	By salesOption = By.id("grouptab_0");
	By leadsOption = By.xpath("//*[@id='moduleTab_9_Leads']");
	By additionalDetails = By.xpath("//*[@title='Additional Details']");
	By PhoneNo = By.xpath("//span[@class='phone']");
	
	public Activity7_Pages(WebDriver driver) {
		this.driver = driver;
	}

	public void readPopupInfo() {
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver,10);
        driver.findElement(salesOption).click();
        wait = new WebDriverWait(driver,5);
		driver.findElement(leadsOption).click();
		wait.until(ExpectedConditions.elementToBeClickable(additionalDetails));
		
		infoIcons = driver.findElements(additionalDetails);
	    infoIcon = infoIcons.get(2);
	    infoIcon.click();
	    //forceClickElement(infoIcon, driver);
		wait.until(ExpectedConditions.elementToBeClickable(PhoneNo));
	   	phnNoText = driver.findElement(PhoneNo).getText();
		System.out.println(phnNoText);
		
		System.out.println("Activity 7 is successfully completed");
	}
	
}
