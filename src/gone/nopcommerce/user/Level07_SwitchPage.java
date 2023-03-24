package gone.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObject.AddressPageObject;
import pageObject.CustomerInforPageObject;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.MyProductionReviewPageObject;
import pageObject.PageGeneratorManager;
import pageObject.RegisterPageObject;
import pageObject.RewardPointPageObject;

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

public class Level07_SwitchPage extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private CustomerInforPageObject customerInforPage;
	private AddressPageObject addressPage;
	private MyProductionReviewPageObject myProductionReviewPage;
	private RewardPointPageObject rewardPointPage;
	Select select;
	private String projectPath = System.getProperty("user.dir");
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
		homePage = PageGeneratorManager.getHomePage(driver);
		// loginPage = PageGeneratorManager.getLoginPage(driver);
		// registerPage = PageGeneratorManager.getRegisterPage(driver);

	}

	@Test
	public void TC01_Register_Account() {
		registerPage = homePage.clickToRegisterLink();
		registerPage.clickToGenderCheckbox();
		registerPage.inputToFirstNameTextbox("Do");
		registerPage.inputToLastNameTextbox("Trien");
		registerPage.inputToEmailTextbox(cusEmail);
		registerPage.inputToPasswordTextbox(passWord);
		registerPage.inputToConfirmPasswordTextbox(repassWord);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
		System.out.println(cusEmail);
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void TC02_Login_Success() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox("");
		loginPage.inputToPasswordTextBox(passWord);
		loginPage.clickToLoginButton();
		// Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	}

	/*
	 * @Test public void TC03_Customer_Infor() { customerInforPage =
	 * homePage.clickToMyAccountLink();
	 * Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed()); }
	 */

	@Test
	public void TC04_Switch_Page() {
//		addressPage = customerInforPage.openAddressPage(driver);
//		myProductionReviewPage = addressPage.openMyProductionReviewPage(driver);
//		rewardPointPage = myProductionReviewPage.openRewardPointPage(driver);
//		addressPage = rewardPointPage.openAddressPage(driver);
//		rewardPointPage = addressPage.openRewardPointPage(driver);
//		myProductionReviewPage = rewardPointPage.openMyProductionReviewPage(driver);
//		addressPage = myProductionReviewPage.openAddressPage(driver);
//		customerInforPage = addressPage.openCustomerInforPage(driver);
	}

	@Test
	public void TC05_Switch_Role() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(cusEmail);
		loginPage.inputToPasswordTextBox("34324@vcc");
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageWithNoRegisteredMail(),"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	}

	@Test
	public void TC06_Login_With_RegisteredMail_Password_Correct() {
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(cusEmail);
		loginPage.inputToPasswordTextBox(passWord);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
