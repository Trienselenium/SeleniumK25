package gone.nopcommerce.user;

import org.testng.annotations.Test;
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
public class Topic0708_linkhay {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Select select;
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.navigate().to("https://linkhay.com/link/stream/hot");
	  
  }

  @Test
  public void f() throws InterruptedException {
	  driver.findElement(By.xpath("//a[@class='link-nologin mrk-login']")).click();
	  Thread.sleep(3000);
	  driver.switchTo().frame(driver.findElement(By.id("login_box_frame")));
	  driver.findElement(By.xpath("//input[@name='account']")).sendKeys("TR001@qa.team");
	  driver.findElement(By.xpath("//a[@class='btn btn-blue btn-next btn-login']")).click();
	  Thread.sleep(2000);
	  System.out.println("##########");
	  String bbb= driver.findElement(By.xpath("//div[@class='center fontRobotoLight app-user-mail textGray']")).getText();
	  //String aaa= driver.findElement(By.xpath("//form[@id='confirmEmailForm']//input[@name='code']")).getAttribute("placeholder");
	  //System.out.println(aaa);
	  System.out.println(bbb);
	  driver.findElement(By.xpath("//form[@id='enterPasswordForm']//input[@name='password']")).sendKeys("12345@Fra");
	  Thread.sleep(3000);
	  
  }
  
  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
