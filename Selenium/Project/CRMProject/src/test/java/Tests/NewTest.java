package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.Activity1_Pages;
import Pages.Activity2_Pages;
import Pages.Activity3_Pages;
import Pages.Activity4_Pages;
import Pages.Activity5_Pages;
import Pages.Activity6_Pages;
import Pages.Activity7_Pages;
import Pages.Activity8_Pages;
import Pages.Activity9_Pages;
import TestUtils.BaseClass;

public class NewTest extends BaseClass{
	
	private WebDriver driver;
	Activity1_Pages activity1Obj;
	Activity2_Pages activity2Obj;
	Activity3_Pages activity3Obj;
	Activity4_Pages activity4Obj;
	Activity5_Pages activity5Obj;
	Activity6_Pages activity6Obj;
	Activity7_Pages activity7Obj;
	Activity8_Pages activity8Obj;
	Activity9_Pages activity9Obj;
	
	@BeforeClass
	public void beforeClass() throws IOException {
		driver = initializeDriver();
	}
	
	@Test
	public void activity1() {
		WebDriverWait wait = new WebDriverWait(driver,20);
		activity1Obj = new Activity1_Pages(driver);
		activity1Obj.validateAppTitle();
	}
	
	@Test
	public void activity2() {
		WebDriverWait wait = new WebDriverWait(driver,20);
		activity2Obj = new Activity2_Pages(driver);
		activity2Obj.getHeaderImgURL();
	}
	
	@Test
	public void activity3() {
		WebDriverWait wait = new WebDriverWait(driver,20);
		activity3Obj = new Activity3_Pages(driver);
		activity3Obj.printFirstCopyrightText();
	}
	
	@Test
	public void activity4() {
		WebDriverWait wait = new WebDriverWait(driver,20);
		activity4Obj = new Activity4_Pages(driver);
		activity4Obj.loginApp();		
	}
	
	@Test
	public void activity5() {
		WebDriverWait wait = new WebDriverWait(driver,20);
		activity5Obj = new Activity5_Pages(driver);
		activity5Obj.getNavigationMenuColour();
	}
	
	@Test
	public void activity6() {
		WebDriverWait wait = new WebDriverWait(driver,20);
		activity6Obj = new Activity6_Pages(driver);
		activity6Obj.activityMenu();
	}
	
	@Test
	public void activity7() {
		WebDriverWait wait = new WebDriverWait(driver,20);
		activity7Obj = new Activity7_Pages(driver);
		activity7Obj.readPopupInfo();
	}
	
	@Test
	public void activity8() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,20);
		activity8Obj = new Activity8_Pages(driver);
		activity8Obj.printFirstFiveOddNumberedRows();
	}
	
	@Test
	public void activity9() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,20);
		activity9Obj = new Activity9_Pages(driver);
		activity9Obj.printFirstTenRowsNameUserColumns();
	}
	
	@AfterClass
	public void afterClass() {
  		driver.close();
	}
}
