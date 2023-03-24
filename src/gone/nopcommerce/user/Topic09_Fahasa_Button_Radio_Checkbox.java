package gone.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import pageUIs.BasePageUI;

import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class Topic09_Fahasa_Button_Radio_Checkbox extends BasePage {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Select select;
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.navigate().to("https://www.guardian.com.vn/account/login");
	  
  }

  @Test
  public void f() {
	  driver.findElement(By.xpath("//input[@value='Đăng nhập']")).click();
	  String a = getElementValidationMessage(driver, "//input[@id='customer_email']");
	  System.out.println(a);
	  sleepInSecond(2);
	  
	  driver.findElement(By.xpath("//input[@id='customer_email']")).sendKeys("aaaa");	  
	  String b = getElementValidationMessage(driver, "//input[@id='customer_email']");
	  System.out.println(b);

  }
  
  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
