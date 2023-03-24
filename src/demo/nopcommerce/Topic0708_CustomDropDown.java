package demo.nopcommerce;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Topic0708_CustomDropDown {
	WebDriver driver;
	WebDriverWait explicitWait;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	Select select;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		explicitWait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().window().maximize();

	}
	@Test
	public void TC01_Jquery() throws InterruptedException{
		driver.navigate().to("https://jqueryui.com/resources/demos/selectmenu/default.html");		
		selectDropDown("//span[@id='number-button']", "//ul[@id='number-menu']/li/div", "9");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text']")).getText(), "9");
		Thread.sleep(1000);
		selectDropDown("//span[@id='number-button']", "//ul[@id='number-menu']/li/div", "19");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id='number-button']/span[@class='ui-selectmenu-text']")).getText(), "19");
	}

//	@Test
//	public void TC02_ReatJS() throws InterruptedException{
//		driver.navigate().to("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
//		selectDropDown("//div[@class='ui fluid selection dropdown']", "//div[contains(@class,'item')]/span[@class='text']", "Elliot Fu");
//		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='divider text']")).getText(), "Elliot Fu");
//	}
//	
//	@Test
//	public void TC03_VueJS() throws InterruptedException{
//		driver.navigate().to("https://mikerodham.github.io/vue-dropdowns/");
//		selectDropDown("//li[@class='dropdown-toggle']", "//ul[@class='dropdown-menu']//a", "Second Option");		
//		Assert.assertEquals(driver.findElement(By.xpath("//li[@class='dropdown-toggle']")).getText(), "Second Option");
//	}
//	@Test
//	public void TC04_Angular() throws InterruptedException{
//		driver.navigate().to("https://tiemchungcovid19.gov.vn/portal/register-person");
//		Thread.sleep(2000);
//		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//input[@placeholder='Nghề nghiệp']")));
//		Thread.sleep(2000);
//		selectDropDown("//ng-select[@bindvalue='provinceCode']//span[@class='ng-arrow-wrapper']", "//span[contains(@class,'ng-option-label')]", "Thành phố Hồ Chí Minh");
//		Thread.sleep(2000);
//		String expectedText = (String) jsExecutor.executeScript("return document.querySelector(\"ng-select[bindvalue='provinceCode'] span[class='ng-value-label ng-star-inserted']\").innerText");
//		Assert.assertEquals(expectedText, "Thành phố Hồ Chí Minh");
//		
//		selectDropDown("//ng-select[@bindvalue='districtCode']//span[@class='ng-arrow-wrapper']", "//span[contains(@class,'ng-option-label')]", "Quận 1");
//		Thread.sleep(2000);
//		String expectedTextQ = (String) jsExecutor.executeScript("return document.querySelector(\"ng-select[bindvalue='districtCode'] span[class='ng-value-label ng-star-inserted']\").innerText");
//		Assert.assertEquals(expectedTextQ, "Quận 1");		
//		
//		selectDropDown("//ng-select[@bindvalue='wardCode']//span[@class='ng-arrow-wrapper']", "//span[contains(@class,'ng-option-label')]", "Phường Đa Kao");
//		Thread.sleep(2000);
//		String expectedTextP = (String) jsExecutor.executeScript("return document.querySelector(\"ng-select[bindvalue='wardCode'] span[class='ng-value-label ng-star-inserted']\").innerText");
//		Assert.assertEquals(expectedTextP, "Phường Đa Kao");	
//		
//	}
	
	
	public void selectDropDown(String parentXpath, String childXpath, String expectedText) throws InterruptedException {
		// click vào 1 thẻ đại diện để load hết thông tin item ra

		driver.findElement(By.xpath(parentXpath)).click();
		Thread.sleep(2000);
		// chờ cho tất cả các item con được presence(load) trong DOM hay trong thẻ HTML
		// trong vòng 30s
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childXpath)));
		// lấy tất cả element bỏ vào trong list
		List<WebElement> childElement = driver.findElements(By.xpath(childXpath));
		// duyệt list Element và check dieu kien để thao tác
		for (WebElement tempElement : childElement) {
			if (tempElement.getText().trim().equals(expectedText)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", tempElement);
				Thread.sleep(2000);
				System.out.println(tempElement.getText());
				tempElement.click();
				break;
			}
		}
	}
	
	
	
	
	public void selectEditDropDown(String parentXpath, String childXpath, String expectedText) throws InterruptedException {
		// click vào 1 thẻ đại diện để load hết thông tin item ra
		driver.findElement(By.xpath(parentXpath)).clear();
		driver.findElement(By.xpath(parentXpath)).sendKeys(expectedText);
		Thread.sleep(2000);
		// chờ cho tất cả các item con được presence(load) trong DOM hay trong thẻ HTML
		// trong vòng 30s
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childXpath)));
		// lấy tất cả element bỏ vào trong list
		List<WebElement> childElement = driver.findElements(By.xpath(childXpath));
		// duyệt list Element và check dieu kien để thao tác
		for (WebElement tempElement : childElement) {
			if (tempElement.getText().trim().equals(expectedText)) {
				tempElement.click();
				Thread.sleep(2000);
				break;
			}
		}
	}
	

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
