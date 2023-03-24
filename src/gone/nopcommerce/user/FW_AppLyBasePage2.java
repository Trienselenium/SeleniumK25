package gone.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commons.BasePage;

public class FW_AppLyBasePage2 extends BasePage {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Select select;
	String firstName = "Trien";
	String lastName = "Do";
	String day ="1";
	String month ="May";
	String year = "1980";
	String cusEmail;
	String passWord = "12345@Fra";
	String cusPassWord = "12345";
	String repassWord = "12345@Fra";	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cusEmail = "username" + getRandomNumber() + "@gmail.com";
		driver.navigate().to("https://demo.nopcommerce.com/register");

	}
	@Test
	public void TC01_Register_Empty_Data() throws InterruptedException {
		waitForWebElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		waitForWebElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
		
		
	}
	@Test
	public void TC02_Invalid_Email() throws InterruptedException {
		waitForWebElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");

		
		waitForWebElementClickable(driver, "//input[@id='gender-male']");
		clickToElement(driver,"//input[@id='gender-male']");
		
				

		sendKeyToElement(driver, "//input[@id='FirstName']", "Trien");		
		
		sendKeyToElement(driver, "//input[@id='LastName']", "Do");
		
		selectDefaultDropDown(driver, "//select[@name='DateOfBirthDay']", day);
		Assert.assertEquals(getOptionsSize(driver, "//select[@name='DateOfBirthDay']"), 32);
		
		selectDefaultDropDown(driver, "//select[@name='DateOfBirthMonth']", month);
		Assert.assertEquals(getOptionsSize(driver, "//select[@name='DateOfBirthMonth']"), 13);

		selectDefaultDropDown(driver, "//select[@name='DateOfBirthYear']", year);
		Assert.assertEquals(getOptionsSize(driver, "//select[@name='DateOfBirthYear']"), 112);			

		sendKeyToElement(driver, "//input[@id='Email']", "sasdsd@123..");		
		sendKeyToElement(driver, "//input[@id='Password']", passWord);
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", repassWord);	
		
		waitForWebElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"),"Wrong email");
	}
	@Test
	public void TC03_Register_Success() throws InterruptedException {
		waitForWebElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");	
		
		waitForWebElementClickable(driver, "//input[@id='gender-male']");
		clickToElement(driver,"//input[@id='gender-male']");

		sendKeyToElement(driver, "//input[@id='FirstName']", "Trien");
		sendKeyToElement(driver, "//input[@id='LastName']", "Do");
		
		selectDefaultDropDown(driver, "//select[@name='DateOfBirthDay']", day);
		Assert.assertEquals(getOptionsSize(driver, "//select[@name='DateOfBirthDay']"), 32);
		
		selectDefaultDropDown(driver, "//select[@name='DateOfBirthMonth']", month);
		Assert.assertEquals(getOptionsSize(driver, "//select[@name='DateOfBirthMonth']"), 13);

		selectDefaultDropDown(driver, "//select[@name='DateOfBirthYear']", year);
		Assert.assertEquals(getOptionsSize(driver, "//select[@name='DateOfBirthYear']"), 112);			

		sendKeyToElement(driver, "//input[@id='Email']", cusEmail);		
		sendKeyToElement(driver, "//input[@id='Password']", passWord);
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", repassWord);	
		
		waitForWebElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(getElementText(driver, "//div[@class='result']"),"Your registration completed");
		
		clickToElement(driver, "//a[@class='ico-logout']");
		
	}
	@Test
	public void TC04_Register_Email_Exist() throws InterruptedException {
		waitForWebElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");	
		
		waitForWebElementClickable(driver, "//input[@id='gender-male']");
		clickToElement(driver,"//input[@id='gender-male']");

		sendKeyToElement(driver, "//input[@id='FirstName']", "Trien");
		sendKeyToElement(driver, "//input[@id='LastName']", "Do");
		
		selectDefaultDropDown(driver, "//select[@name='DateOfBirthDay']", day);
		Assert.assertEquals(getOptionsSize(driver, "//select[@name='DateOfBirthDay']"), 32);
		
		selectDefaultDropDown(driver, "//select[@name='DateOfBirthMonth']", month);
		Assert.assertEquals(getOptionsSize(driver, "//select[@name='DateOfBirthMonth']"), 13);

		selectDefaultDropDown(driver, "//select[@name='DateOfBirthYear']", year);
		Assert.assertEquals(getOptionsSize(driver, "//select[@name='DateOfBirthYear']"), 112);			

		sendKeyToElement(driver, "//input[@id='Email']", cusEmail);		
		sendKeyToElement(driver, "//input[@id='Password']", passWord);
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", repassWord);	
		
		waitForWebElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(getElementText(driver, "//div[@class='message-error validation-summary-errors']/ul/li"),"The specified email already exists");
	}
	@Test
	public void TC05_Register_LessThan_6Chars() throws InterruptedException {
		waitForWebElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");	
		
		waitForWebElementClickable(driver, "//input[@id='gender-male']");
		clickToElement(driver,"//input[@id='gender-male']");

		sendKeyToElement(driver, "//input[@id='FirstName']", "Trien");
		sendKeyToElement(driver, "//input[@id='LastName']", "Do");
		
		selectDefaultDropDown(driver, "//select[@name='DateOfBirthDay']", day);
		Assert.assertEquals(getOptionsSize(driver, "//select[@name='DateOfBirthDay']"), 32);
		
		selectDefaultDropDown(driver, "//select[@name='DateOfBirthMonth']", month);
		Assert.assertEquals(getOptionsSize(driver, "//select[@name='DateOfBirthMonth']"), 13);

		selectDefaultDropDown(driver, "//select[@name='DateOfBirthYear']", year);
		Assert.assertEquals(getOptionsSize(driver, "//select[@name='DateOfBirthYear']"), 112);			

		sendKeyToElement(driver, "//input[@id='Email']", cusEmail);		
		sendKeyToElement(driver, "//input[@id='Password']", cusPassWord);
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", cusPassWord);	
		
		waitForWebElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"),"Password must meet the following rules:\nmust have at least 6 characters");
		
	}
	@Test
	public void TC06_Register_Invalid_Confirm_Password() throws InterruptedException {
		waitForWebElementClickable(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//a[@class='ico-register']");	
		
		waitForWebElementClickable(driver, "//input[@id='gender-male']");
		clickToElement(driver,"//input[@id='gender-male']");

		sendKeyToElement(driver, "//input[@id='FirstName']", "Trien");
		sendKeyToElement(driver, "//input[@id='LastName']", "Do");
		
		selectDefaultDropDown(driver, "//select[@name='DateOfBirthDay']", day);
		Assert.assertEquals(getOptionsSize(driver, "//select[@name='DateOfBirthDay']"), 32);
		
		selectDefaultDropDown(driver, "//select[@name='DateOfBirthMonth']", month);
		Assert.assertEquals(getOptionsSize(driver, "//select[@name='DateOfBirthMonth']"), 13);

		selectDefaultDropDown(driver, "//select[@name='DateOfBirthYear']", year);
		Assert.assertEquals(getOptionsSize(driver, "//select[@name='DateOfBirthYear']"), 112);			

		sendKeyToElement(driver, "//input[@id='Email']", cusEmail);		
		sendKeyToElement(driver, "//input[@id='Password']", cusPassWord);
		sendKeyToElement(driver, "//input[@id='ConfirmPassword']", "12345!GF");	
		
		waitForWebElementClickable(driver, "//button[@id='register-button']");
		clickToElement(driver, "//button[@id='register-button']");
		Assert.assertEquals(getElementText(driver, "//span[@id='ConfirmPassword-error']"),"The password and confirmation password do not match.");
		
	}
	public int getRandomNumber() {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(9999);
	
	}



	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
