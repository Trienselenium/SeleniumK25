package webdrivers;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Topic0708_HRM {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	static String firstName = "Trien";
	static String lastName = "Do";
	static String firstNameEdit = "Phat";
	static String lastNameEdit = "Dang";
	static String numB;
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/");

	}

	@Test
	public void TC01() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		Actions actions = new Actions(driver);
		WebElement pimMenu = driver.findElement(By.xpath("//b[text()='PIM']"));
		actions.moveToElement(pimMenu).perform();
		driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']")).click();
		// actions.moveToElement(pimMenu)
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastName);
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(3000);
		numB = "1" + randomInt;
		driver.findElement(By.xpath("//input[@id='employeeId']")).clear();		
		driver.findElement(By.xpath("//input[@id='employeeId']")).sendKeys(numB);
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		
		//check thong tin trong employee list
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']")).getAttribute("value"), firstName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='personal_txtEmpLastName']")).getAttribute("value"), lastName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='personal_txtEmployeeId']")).getAttribute("value"), numB);
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']")).clear();		
		driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']")).sendKeys(firstNameEdit);
		driver.findElement(By.xpath("//input[@id='personal_txtEmpLastName']")).clear();
		driver.findElement(By.xpath("//input[@id='personal_txtEmpLastName']")).sendKeys(lastNameEdit);
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']")).isEnabled());
		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='personal_txtEmpLastName']")).isEnabled());
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']")).getAttribute("value"), firstNameEdit);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='personal_txtEmpLastName']")).getAttribute("value"), lastNameEdit);
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id='personal_txtEmpFirstName']")).isEnabled());
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id='personal_txtEmpLastName']")).isEnabled());
		Assert.assertFalse(driver.findElement(By.xpath("//input[@id='personal_txtEmployeeId']")).isEnabled());
		
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
