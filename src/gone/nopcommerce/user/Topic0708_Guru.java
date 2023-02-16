package gone.nopcommerce.user;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Topic0708_Guru {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	static String cusName = "Tr voucher";
	static String cusGender = "male";
	static String cusBirthDateInput = "05/23/1988";
	static String cusBirthDateOutput = "1988-05-23";
	static String cusEmail;
	static String cusAddress = "2633 Le Duc Tho";
	static String cusCity = "HO CHI MINH";
	static String cusState = "Go Vap";
	static String cusPin = "123456";
	static String cusPhone = "0902855123";
	static String cusPassWord = "12345@Fra";

	static String cusEmailEdit;
	static String cusAddressEdit = "123 Le van Sy";
	static String cusCityEdit = "Vung Tau";
	static String cusStateEdit = "HA Ha";
	static String cusPinEdit = "456789";
	static String cusPhoneEdit = "0902555444";
	static String cusPassWordEdit = "12345@Abc";
	String getCusID ;
	JavascriptExecutor jsExecutor;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();

		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.navigate().to("http://demo.guru99.com/v4");
		
	}

	@Test
	public void TC01_NewCustomer() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr381574");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("ebYqEru");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		String homePagetxt = driver.getTitle();
		System.out.println(homePagetxt);
		Assert.assertTrue(homePagetxt.contains("Guru99 Bank Manager HomePage"));
		driver.findElement(By.xpath("//a[normalize-space()='New Customer']")).click();
		Thread.sleep(5000);

		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(cusName);
		driver.findElement(By.xpath("//input[@value='m']")).click();
		
		WebElement dob = driver.findElement(By.xpath("//input[@id='dob']"));
		jsExecutor.executeScript("arguments[0].removeAttribute('type')", dob);
		dob.sendKeys(cusBirthDateInput);
		
		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(cusAddress);
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(cusCity);
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(cusState);
		driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys(cusPin);
		driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys(cusPhone);
		
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(9999);
		cusEmail = "username" + randomInt + "@gmail.com";
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(cusEmail);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(cusPassWord);	
		driver.findElement(By.xpath("//input[@name='sub']")).click();
		Thread.sleep(2000);	
		Assert.assertEquals(cusName, driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getAttribute("value"));
		Assert.assertEquals(cusGender, driver.findElement(By.xpath("//tr[td='Gender']/td/following-sibling::td")).getText());
		Assert.assertEquals(cusBirthDateOutput, driver.findElement(By.xpath("//tr[td='Birthdate']/td/following-sibling::td")).getText());
		Assert.assertEquals(cusAddress, driver.findElement(By.xpath("//tr[td='Address']/td/following-sibling::td")).getText());
		Assert.assertEquals(cusCity, driver.findElement(By.xpath("//tr[td='City']/td/following-sibling::td")).getText());
		Assert.assertEquals(cusState, driver.findElement(By.xpath("//tr[td='State']/td/following-sibling::td")).getText());
		Assert.assertEquals(cusPin, driver.findElement(By.xpath("//tr[td='Pin']/td/following-sibling::td")).getText());
		Assert.assertEquals(cusPhone, driver.findElement(By.xpath("//tr[td='Mobile No.']/td/following-sibling::td")).getText());
		Assert.assertEquals(cusEmail, driver.findElement(By.xpath("//tr[td='Email']/td/following-sibling::td")).getText());
		getCusID = driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void TC02_EditCustomer() throws InterruptedException {		
		//Case 02_Edit customer
		System.out.println(getCusID);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//a[text()='Edit Customer']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys(getCusID);
		driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();		

		Assert.assertEquals(cusName,  driver.findElement(By.xpath("//input[@name='name']")).getAttribute("value"));
		Assert.assertEquals(cusAddress, driver.findElement(By.xpath("//textarea[@name='addr']")).getText());
		
		driver.findElement(By.xpath("//textarea[@name='addr']")).clear();
		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(cusAddressEdit);
		driver.findElement(By.xpath("//input[@name='city']")).clear();	
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(cusCityEdit);
		driver.findElement(By.xpath("//input[@name='state']")).clear();		
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(cusStateEdit);
		driver.findElement(By.xpath("//input[@name='pinno']")).clear();				
		driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys(cusPinEdit);
		driver.findElement(By.xpath("//input[@name='telephoneno']")).clear();				
		driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys(cusPhoneEdit);		
		driver.findElement(By.xpath("//input[@name='emailid']")).clear();		
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(cusEmail);
		driver.findElement(By.xpath("//input[@name='sub']")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys(getCusID);
		driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.findElement(By.xpath("//input[@name='city']")).getAttribute("value"));
		System.out.println(driver.findElement(By.xpath("//input[@name='pinno']")).getAttribute("value"));
		Assert.assertEquals(driver.findElement(By.xpath("//textarea[@name='addr']")).getText(), cusAddressEdit);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='city']")).getAttribute("value"), cusCityEdit);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='state']")).getAttribute("value"), cusStateEdit);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='pinno']")).getAttribute("value"), cusPinEdit);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='telephoneno']")).getAttribute("value"), cusPhoneEdit);	
		
	}
	

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
