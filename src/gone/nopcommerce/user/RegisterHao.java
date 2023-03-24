package gone.nopcommerce.user;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class RegisterHao {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	private String firstNameInput = "Hao";
	private String lastNameInput = "Phan";
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get("https://opensource-demo.orangehrmlive.com/index.php/pim/addEmployee");
  }

  
  @Test
	public void TC_02_Add_Emp() {

		WebElement firstNameInput = driver.findElement(By.id("firstName"));
		firstNameInput.sendKeys("Hao");
		WebElement lastNameInput = driver.findElement(By.id("lastName"));
		lastNameInput.sendKeys("Phan");
		//empId = driver.findElement(By.id("employeeId")).getText();
		driver.findElement(By.id("btnSave")).click();
		
		//Assert.assertEquals(driver.findElement(By.xpath("//div[@class='head']//h1[text()='Personal Details']")).getText(), "Personal Details");

		Assert.assertEquals(driver.findElement(By.id("personal_txtEmpFirstName")).getText(), firstNameInput);
		Assert.assertEquals(driver.findElement(By.id("personal_txtEmpLastName")).getText(), lastNameInput);
		//Assert.assertEquals(driver.findElement(By.id("personal_txtEmployeeId")).getText(), empId);

		Assert.assertFalse(driver.findElement(By.id("personal_txtEmpFirstName")).isEnabled());
		Assert.assertFalse(driver.findElement(By.id("personal_txtEmpLastName")).isEnabled());
		Assert.assertFalse(driver.findElement(By.id("personal_txtEmployeeId")).isEnabled());
	}
  
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
