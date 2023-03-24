package gone.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.RegisterPageObject;

public class Level03_PageObject02_TC extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	Select select;
	private String invalidEmail = "2323@..@";
	private String noRegisteredMail = "triendo@galaxy.two";
	private String passWord = "12345@Fra";
	private String repassWord = "12345@Fra";
	private String cusEmail;
	String projectFolder = System.getProperty("user.dir");
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriverManager(browserName);		
		System.out.println("Start Testcase Level03_PageObject02_TC on firefox");
		cusEmail = "username" + getRandomNumber() + "@gmail.com";
		homePage = new HomePageObject(driver);
		loginPage = new LoginPageObject(driver);
		registerPage = new RegisterPageObject(driver);
		registerPage.clickToRegisterLink();
		registerPage.clickToGenderCheckbox();
		registerPage.inputToFirstNameTextbox("Do");
		registerPage.inputToLastNameTextbox("Trien");
		registerPage.inputToEmailTextbox(cusEmail);
		registerPage.inputToPasswordTextbox(passWord);
		registerPage.inputToConfirmPasswordTextbox(repassWord);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		System.out.println(cusEmail);
		registerPage.clickToLogoutLink();
	}

	@Test
	public void TC011_New_Login_Empty_data() {
		homePage.clickToLoginLink();
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}

	@Test
	public void TC012_New_Login_Invalid_Mail() {
		homePage.clickToLoginLink();
		loginPage.clickToLoginLink();
		loginPage.inputToEmailTextbox(invalidEmail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "FAILLLLLLLLLLLLLLL TC012_Login_Invalid_Mail");
	}

	@Test
	public void TC013_New_Login_With_NoRegisteredMail() {
		homePage.clickToLoginLink();
		loginPage.clickToLoginLink();
		loginPage.inputToEmailTextbox(noRegisteredMail);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageWithNoRegisteredMail(),"FAILLLLLLLLLLLLLLL TC013_Login_With_NoRegisteredMail");
	}

	@Test
	public void TC014_New_Login_With_RegisteredMail_Password_Empty() {
		homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(cusEmail);
		loginPage.inputToPasswordTextBox("");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageWithNoRegisteredMail(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void TC015_New_Login_With_RegisteredMail_Password_Wrong() {
		homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(cusEmail);
		loginPage.inputToPasswordTextBox("34324@vcc");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageWithNoRegisteredMail(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void TC016_New_Login_With_RegisteredMail_Password_Correct() {
		homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(cusEmail);
		loginPage.inputToPasswordTextBox(passWord);
		loginPage.clickToLoginButton();
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	}

	public int getRandomNumber() {
		Random randomGenerator = new Random();
		return randomGenerator.nextInt(9999);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
