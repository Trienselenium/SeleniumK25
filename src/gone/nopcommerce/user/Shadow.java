package gone.nopcommerce.user;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;


public class Shadow {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	private WebElement shadowRoot;
  @BeforeClass
  public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://stg-adsystem.web.app/#/auth");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
  }
  
  @Test
  public void f() throws InterruptedException {
	  Thread.sleep(3000);
      WebElement shadow_host = driver.findElement(By.cssSelector("#flt-glass-pane"));
      System.out.println(shadow_host);
      
      Object shadowRoot = ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot", shadow_host);
      String id = (String) ((Map<String, Object>) shadow_host).get("shadow-6066-11e4-a52e-4f735466cecf");
      System.out.println(id);
      RemoteWebElement shadowRootElement = new RemoteWebElement();
      shadowRootElement.setParent((RemoteWebDriver) driver);
      shadowRootElement.setId(id);

      WebElement shadowContent = shadowRootElement.findElement(By.cssSelector("#email"));
      System.out.println(shadowContent);
      shadowContent.sendKeys("asdasdnasd");
      Thread.sleep(2000);
  }
  
  
  @AfterClass
  public void afterClass() {
		driver.quit();
  }

}
