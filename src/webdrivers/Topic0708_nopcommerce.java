package webdrivers;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Topic0708_nopcommerce {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Select select;
	String firstName = "Trien";
	String lastName = "Do";
	String day ="1";
	String month ="May";
	String year = "1980";
	String cusEmail;
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/register");

	}

	@Test
	public void f() {
		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='gender-male']")).click();
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
	}


	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
