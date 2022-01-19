package webdrivers;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Topic06_WebElement {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("https://automationfc.github.io/basic-form/index.html");
	}

	@Test(priority = 1)
	public void TC_01() throws InterruptedException {
		WebElement emailDisplay = driver.findElement(By.xpath("(//div[@class='container'])//label[@for='mail']"));
		if (emailDisplay.isDisplayed()) {
			emailDisplay.getText();
			System.out.println(emailDisplay.getText());
		}
		WebElement ageDisplay = driver.findElement(By.xpath("//label[@for='under_18']"));
		if (ageDisplay.isDisplayed()) {
			ageDisplay.getText();
			System.out.println(ageDisplay.getText());
		}

		WebElement nameDisplayNotMove = driver.findElement(By.xpath("//h5[normalize-space()='Name: User5']"));
		Assert.assertFalse(nameDisplayNotMove.isDisplayed());

		WebElement image = driver.findElement(By.xpath("//img[@alt='User Avatar 05']"));
		Actions action = new Actions(driver);
		action.moveToElement(image).build().perform();
		WebElement nameDisplayMove = driver.findElement(By.xpath("//h5[normalize-space()='Name: User5']"));
		String getNameDisplay = nameDisplayMove.getText();
		Thread.sleep(3000);
		if (nameDisplayMove.isDisplayed()) {
			driver.findElement(By.xpath("//input[@id='mail']")).sendKeys("trien@gmail.com");
			driver.findElement(By.xpath("//textarea[@id='edu']")).sendKeys("Hoc Auto Topic 06");
			driver.findElement(By.xpath("//input[@id='under_18']")).click();
			System.out.println("Element is display: " + getNameDisplay);
		} else {
			System.out.println("Element is not display");
		}
	}

	@Test(priority = 2)
	public void TC_02() {
		WebElement emailEnable = driver.findElement(By.xpath("//input[@id='mail']"));
		Assert.assertTrue(emailEnable.isEnabled());

		WebElement ageEnable = driver.findElement(By.xpath("//input[@id='under_18']"));
		Assert.assertTrue(ageEnable.isEnabled());

		WebElement eduEnable = driver.findElement(By.xpath("//textarea[@id='edu']"));
		Assert.assertTrue(eduEnable.isEnabled());

		WebElement jobRole1Enable = driver.findElement(By.xpath("//select[@id='job1']"));
		Assert.assertTrue(jobRole1Enable.isEnabled());

		WebElement jobRole2Enable = driver.findElement(By.xpath("//select[@id='job2']"));
		Assert.assertTrue(jobRole2Enable.isEnabled());

		WebElement interestDevelopmentEnable = driver.findElement(By.xpath("//input[@id='development']"));
		Assert.assertTrue(interestDevelopmentEnable.isEnabled());

		WebElement slide1Enable = driver.findElement(By.xpath("//input[@id='slider-1']"));
		Assert.assertTrue(slide1Enable.isEnabled());

		WebElement passWordDisable = driver.findElement(By.xpath("//input[@id='disable_password']"));
		Assert.assertFalse(passWordDisable.isEnabled());

		WebElement ageRadioDisable = driver.findElement(By.xpath("//input[@id='radio-disabled']"));
		Assert.assertFalse(ageRadioDisable.isEnabled());

		WebElement biographyTxtDisable = driver.findElement(By.xpath("//textarea[@id='bio']"));
		Assert.assertFalse(biographyTxtDisable.isEnabled());

		WebElement job3DropdownDisable = driver.findElement(By.xpath("//select[@id='job3']"));
		Assert.assertFalse(job3DropdownDisable.isEnabled());

		WebElement interestsCheckBoxDisable = driver.findElement(By.xpath("//input[@id='check-disbaled']"));
		Assert.assertFalse(interestsCheckBoxDisable.isEnabled());

		WebElement slider2Disable = driver.findElement(By.xpath("//input[@id='slider-2']"));
		Assert.assertFalse(slider2Disable.isEnabled());

		if (emailEnable.isEnabled() && ageEnable.isEnabled() && jobRole1Enable.isEnabled() && jobRole2Enable.isEnabled()
				&& interestDevelopmentEnable.isEnabled() && slide1Enable.isEnabled()) {
			System.out.println("Element is Enabled ");
		} else {
			System.out.println("Element is Disabled ");
		}

		if (passWordDisable.isEnabled() && ageRadioDisable.isEnabled() && biographyTxtDisable.isEnabled()
				&& job3DropdownDisable.isEnabled() && interestsCheckBoxDisable.isEnabled()
				&& slider2Disable.isEnabled()) {
			System.out.println("Element is Enabled ");
		} else {
			System.out.println("Element is Disabled ");
		}

	}

	@Test(priority = 3)
	public void TC_03() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(2000);
		WebElement ageEnablea = driver.findElement(By.xpath("//input[@id='under_18']"));
		ageEnablea.click();
		WebElement languageSelected = driver.findElement(By.xpath("//input[@id='java']"));
		languageSelected.click();
		Assert.assertTrue(ageEnablea.isSelected());
		Assert.assertTrue(languageSelected.isSelected());
		languageSelected.click();
		Assert.assertFalse(languageSelected.isSelected());
		Thread.sleep(2000);
		if (ageEnablea.isSelected()) {
			System.out.println("ageEnablea Element is selected");
		}
		if (languageSelected.isSelected()) {
			System.out.println("Element is selected");
		} else {
			System.out.println(" languageSelected Element is de-selected");
		}
	}

	@Test(priority = 4)
	public void TC_04() throws InterruptedException {
		driver.navigate().to("https://login.mailchimp.com/signup/");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("trien@gmail.com");
		driver.findElement(By.xpath("//input[@id='new_username']")).sendKeys("trien do");
		driver.findElement(By.xpath("//input[@id='new_password']")).sendKeys("123456");

		WebElement oneNumberNewTxt = driver.findElement(By.xpath("//li[@class='number-char completed']"));		
		WebElement oneUpperTxt = driver.findElement(By.xpath("//li[@class='uppercase-char']"));		
		WebElement oneLowerTxt = driver.findElement(By.xpath("//li[@class='lowercase-char']"));		
		WebElement specialTxt = driver.findElement(By.xpath("//li[@class='special-char']"));		
		WebElement minLengthTxt = driver.findElement(By.xpath("//li[@class='8-char']"));		
		
		Assert.assertTrue(oneNumberNewTxt.isDisplayed());
		Assert.assertTrue(oneUpperTxt.isDisplayed());
		Assert.assertTrue(oneLowerTxt.isDisplayed());
		Assert.assertTrue(specialTxt.isDisplayed());
		Assert.assertTrue(minLengthTxt.isDisplayed());

		
		driver.findElement(By.xpath("//input[@id='new_password']")).clear();
		driver.findElement(By.xpath("//input[@id='new_password']")).sendKeys("ABC");		
		WebElement oneNumberTxt = driver.findElement(By.xpath("//li[@class='number-char']"));
		WebElement oneUpperNewTxt = driver.findElement(By.xpath("//li[@class='uppercase-char completed']"));
		System.out.print("##########" + oneNumberTxt.getAttribute("class"));
		
		Assert.assertTrue(oneNumberTxt.isDisplayed());
		System.out.print("sadasdasd");
		Assert.assertTrue(oneUpperNewTxt.isDisplayed());
		System.out.print("111111111");
		Assert.assertTrue(oneLowerTxt.isDisplayed());
		System.out.print("2222");
		Assert.assertTrue(specialTxt.isDisplayed());
		System.out.print("33333");
		Assert.assertTrue(minLengthTxt.isDisplayed());
		
		
		
		
	
		

		
		
		/*
		 * 
		 * 
		 * Assert.assertTrue(oneNumberTxt.isEnabled());
		 * Assert.assertTrue(oneUpperTxt.isEnabled());
		 * Assert.assertFalse(oneLowerTxt.isEnabled());
		 * Assert.assertTrue(specialTxt.isEnabled());
		 * Assert.assertTrue(minLengthTxt.isEnabled());
		 * System.out.println("2222222222");
		 * 
		 * 
		 * 
		 * Assert.assertTrue(signUpbtn.isEnabled());
		 * Assert.assertTrue(oneNumberTxt.isEnabled());
		 * Assert.assertFalse(oneUpperTxt.isEnabled());
		 * Assert.assertTrue(oneLowerTxt.isEnabled());
		 * Assert.assertTrue(specialTxt.isEnabled());
		 * Assert.assertTrue(minLengthTxt.isEnabled());
		 * System.out.println("333333333333");
		 * 
		 * driver.findElement(By.xpath("//input[@id='new_password']")).clear();
		 * driver.findElement(By.xpath("//input[@id='new_password']")).sendKeys(
		 * "#$@$()*@(%_"); Assert.assertFalse(signUpbtn.isEnabled());
		 * Assert.assertTrue(signUpbtn.isEnabled());
		 * Assert.assertTrue(oneNumberTxt.isEnabled());
		 * Assert.assertTrue(oneUpperTxt.isEnabled());
		 * Assert.assertTrue(oneLowerTxt.isEnabled());
		 * Assert.assertFalse(specialTxt.isEnabled());
		 * Assert.assertTrue(minLengthTxt.isEnabled());
		 * 
		 * driver.findElement(By.xpath("//input[@id='new_password']")).clear();
		 * driver.findElement(By.xpath("//input[@id='new_password']")).sendKeys(
		 * "123456789"); Assert.assertFalse(signUpbtn.isEnabled());
		 * Assert.assertTrue(signUpbtn.isEnabled());
		 * Assert.assertFalse(oneNumberTxt.isEnabled());
		 * Assert.assertTrue(oneUpperTxt.isEnabled());
		 * Assert.assertTrue(oneLowerTxt.isEnabled());
		 * Assert.assertTrue(specialTxt.isEnabled());
		 * Assert.assertFalse(minLengthTxt.isEnabled());
		 */

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
