package webdrivers;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
public class Topic06_WebBrowserElement {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.navigate().to("http://live.techpanda.org/");
  } 
	
  @Test(priority = 1)
  public void TC_01() {
	  driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	  String verifyUrlLogin = driver.getCurrentUrl();
	  Assert.assertEquals(verifyUrlLogin, "http://live.techpanda.org/index.php/customer/account/login/");
	  driver.findElement(By.xpath("//span[contains(text(),'Create an Account')]")).click();
	  String verifyUrlRegister = driver.getCurrentUrl();
	  Assert.assertEquals(verifyUrlRegister,"http://live.techpanda.org/index.php/customer/account/create/");
  }
  
  @Test(priority = 2)
  public void TC_02() {
	  driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	  String verifyTitleLogin = driver.getTitle();
	  Assert.assertEquals(verifyTitleLogin, "Customer Login");
	  driver.findElement(By.xpath("//span[contains(text(),'Create an Account')]")).click();
	  String verifyTitleRegister = driver.getTitle();
	  Assert.assertEquals(verifyTitleRegister, "Create New Customer Account");
  }
  
  @Test(priority = 3)
  public void TC_03() {
	  driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	  driver.findElement(By.xpath("//span[contains(text(),'Create an Account')]")).click();
	  String verifyUrlRegister = driver.getCurrentUrl();
	  Assert.assertEquals(verifyUrlRegister,"http://live.techpanda.org/index.php/customer/account/create/");	  
	  driver.navigate().back();
	  String verifyUrlLogin = driver.getCurrentUrl();
	  Assert.assertEquals(verifyUrlLogin, "http://live.techpanda.org/index.php/customer/account/login/");
	  driver.navigate().forward();
	  String verifyTitleRegister = driver.getTitle();
	  Assert.assertEquals(verifyTitleRegister, "Create New Customer Account");	  
  }
  @Test(priority = 4)
  public void TC_04() {
	  driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	  String verifyMyAccountTxt = driver.findElement(By.xpath("//h1[normalize-space()='Login or Create an Account']")).getText();
	  Assert.assertEquals(verifyMyAccountTxt,"LOGIN OR CREATE AN ACCOUNT");
	  System.out.println("Test" + verifyMyAccountTxt);
	  driver.findElement(By.xpath("//span[contains(text(),'Create an Account')]")).click();
	  System.out.println("##########################");
	  String verifyCreateAccTxt = driver.findElement(By.xpath("//h1[normalize-space()='Create an Account']")).getText();
	  System.out.println("111111111111111111111111111");
	  Assert.assertEquals(verifyCreateAccTxt,"CREATE AN ACCOUNT");	  
  }
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
