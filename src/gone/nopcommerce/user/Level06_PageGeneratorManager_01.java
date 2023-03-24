package gone.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.RegisterPageObject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static org.testng.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Level06_PageGeneratorManager_01 extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	Select select;
	private String projectPath = System.getProperty("user.dir");
	private String invalidEmail ="2323@..@";
	private String noRegisteredMail ="triendo@galaxy.two";
	private String passWord = "12345@Fra";
	private String repassWord = "12345@Fra";
	private String cusEmail;
	
  @BeforeClass
  public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/");
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
  public void TC01_Login_Empty_data() {
	  homePage.clickToLoginLink();
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
  }
  
  @Test
  public void TC02_Login_Invalid_Mail() {
	  homePage.clickToLoginLink();
	  loginPage.clickToLoginLink();
	  loginPage.inputToEmailTextbox(invalidEmail);
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");
  }
  
  @Test
  public void TC03_Login_With_NoRegisteredMail() {
	  homePage.clickToLoginLink();
	  loginPage.clickToLoginLink();
	  loginPage.inputToEmailTextbox(noRegisteredMail);
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageWithNoRegisteredMail(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
  }
  
  
  @Test
  public void TC04_Login_With_RegisteredMail_Password_Empty() {
	  homePage.clickToLoginLink();
	  loginPage.inputToEmailTextbox(cusEmail);
	  loginPage.inputToPasswordTextBox("");
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageWithNoRegisteredMail(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
  }
  
  @Test
  public void TC05_Login_With_RegisteredMail_Password_Wrong() {
	  homePage.clickToLoginLink();
	  loginPage.inputToEmailTextbox(cusEmail);
	  loginPage.inputToPasswordTextBox("34324@vcc");
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageWithNoRegisteredMail(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
  }
  
  @Test
  public void TC06_Login_With_RegisteredMail_Password_Correct() {
	  homePage.clickToLoginLink();
	  loginPage.inputToEmailTextbox(cusEmail);
	  loginPage.inputToPasswordTextBox(passWord);
	  loginPage.clickToLoginButton();
	  homePage = new HomePageObject(driver);
	  Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

  }
  

  
  @AfterClass
  public void afterClass() {
		driver.close();
  }

}
