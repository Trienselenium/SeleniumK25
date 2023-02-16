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
public class Topic0708_Rode {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	Select select;
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.navigate().to("https://www.rode.com/wheretobuy");
	  
  }

  @Test
  public void f() {
	  select = new Select(driver.findElement(By.xpath("//select[@id='where_country']")));
	  Assert.assertFalse(select.isMultiple());
	  select.selectByVisibleText("Vietnam");
	  Assert.assertEquals(select.getFirstSelectedOption().getText(), "Vietnam");
	  Assert.assertEquals(select.getOptions().size(),233);	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//input[@id='search_loc_submit']")).click();
	  
	  Assert.assertEquals(driver.findElement(By.cssSelector("div.result_count>span")).getText(),"32");
	  List<WebElement> distributorName = driver.findElements(By.cssSelector("div.result_item div.store_name"));
	  for (WebElement webElement : distributorName) {
		System.out.println(webElement.getText());
	}

  }
  
  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
