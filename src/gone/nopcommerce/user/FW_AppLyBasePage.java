package gone.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commons.BasePage;


public class FW_AppLyBasePage{
	WebDriver driver;
	BasePage basePage;
	String projectPath = System.getProperty("user.dir");
	Select select;
	String firstName = "Trien";
	String lastName = "Do";
	String day ="1";
	String month ="May";
	String year = "1980";
	String cusEmail;
	String passWord = "12345@Fra";
	String repassWord = "12345@Fra";	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		basePage = BasePage.getBasePage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/register");

	}
	@Test
	public void TC01_Register_Empty_Data() throws InterruptedException {
		basePage.waitForWebElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.waitForWebElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
		
		
	}
	@Test
	public void f() throws InterruptedException {
		basePage.waitForWebElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		
		basePage.waitForWebElementClickable(driver, "//input[@id='gender-male']");
		basePage.clickToElement(driver,"//input[@id='gender-male']");
		//driver.findElement(By.xpath("//input[@id='gender-male']")).click();
				
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys(lastName);
		
		
		
		
		Select dayDropDown = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		dayDropDown.selectByVisibleText(day);		
		Assert.assertEquals(dayDropDown.getOptions().size(), 32);
		
		Select monthDropDown = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		monthDropDown.selectByVisibleText(month);
		Assert.assertEquals(monthDropDown.getOptions().size(), 13);
		
		Select yearDropDown = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		yearDropDown.selectByVisibleText(year);
		Assert.assertEquals(yearDropDown.getOptions().size(), 112);

		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(9999);
		cusEmail = "username" + randomInt + "@gmail.com";
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(cusEmail);
		
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(passWord);
		driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys(repassWord);
		driver.findElement(By.xpath("//button[@id='register-button']")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='result' and text()='Your registration completed']")).isDisplayed());
		driver.findElement(By.xpath("//a[@class='ico-account']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		dayDropDown = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		
		Assert.assertEquals(dayDropDown.getFirstSelectedOption().getText(),day);
		
		monthDropDown = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		Assert.assertEquals(monthDropDown.getFirstSelectedOption().getText(),month);
		
		yearDropDown = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		Assert.assertEquals(yearDropDown.getFirstSelectedOption().getText(),year);
	}


	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
