package demo.nopcommerce;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObject.HomePageObject;
import pageObject.PageGeneratorManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Level03_PageObjectTC extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;

	WebDriverWait explicitWait;
	BasePage basePage;
	Select select;


	@BeforeClass
	public void beforeTest() {		
		System.out.println("Start Testcase Level03_PageObjectTC on chrome");
	}
	
	@Parameters("browser")
	@Test 
	public void TC02_Register_Empty_Data(String browserName) throws InterruptedException {

	  for (int i = 1; i < 1500; i++) {
		  try {
			  Thread.sleep(1000);
			  driver = getBrowserDriver(browserName);
			  homePage = PageGeneratorManager.getHomePage(driver);
			  //log.info("LeftMenu - Step1: Click submenu at left menu after login successful");
			  //System.out.println("Lặp thứ: " + i);
			  homePage.clickToInorgeButton();
			  homePage.clickToOneWay();
			  homePage.selectToDepartureDropDown("SGN");		 
			  homePage.selectToReturnDropDown("HAN");
			  Thread.sleep(1000);
			  homePage.chooseDepartureDate();
			  homePage.choosePassenger();
			  homePage.clickToSearchBookingButton();		  
			  homePage.chooseTicketType();
			  //homePage.getPricesListBooking();
			  homePage.clickToContinueButton();
			  Thread.sleep(1000);
			  homePage.clickToContinueButton();	 
			  
			  driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Bear");
			  driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Mr");
			  driver.findElement(By.xpath("//input[@id='date-picker-inline']")).sendKeys("23/05/1987");
			  driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("0902855777");
			  driver.findElement(By.xpath("//input[@name='email']")).sendKeys("bear@yopmail.com");
			  homePage.clickToContinueButton();
			  Thread.sleep(1000);
			  homePage.clickToContinueButton();		  
			  homePage.clickToPayLaterRadio();
			  homePage.clickToPaymentMethodButton();
			  System.out.println("result:" + homePage.getResultCode());
			  log.info(homePage.getResultCode());
			  //String a = homePage.getResultCode();			  
			  //log.info("result:" +a);
			  Thread.sleep(2000);
			  closeBrowserAndDriver();
		} catch (Exception e) {			
			closeBrowserAndDriver();
		}		  
		  
	  	}  

	  }	

	public void selectDropDown(String parentXpath, String childXpath, String expectedText) throws InterruptedException {
		// click vào 1 thẻ đại diện để load hết thông tin item ra

		driver.findElement(By.xpath(parentXpath)).click();
		Thread.sleep(2000);
		// chờ cho tất cả các item con được presence(load) trong DOM hay trong thẻ HTML
		// trong vòng 30s
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childXpath)));
		// lấy tất cả element bỏ vào trong list
		List<WebElement> childElement = driver.findElements(By.xpath(childXpath));
		// duyệt list Element và check dieu kien để thao tác
		for (WebElement tempElement : childElement) {
			if (tempElement.getText().trim().equals(expectedText)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", tempElement);
				Thread.sleep(1000);				
				tempElement.click();
				break;
			}
		}
	}

	public int getRandomNumber() {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(9999);

	}

	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
