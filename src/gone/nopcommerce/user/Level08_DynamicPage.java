package gone.nopcommerce.user;

import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import commons.GlobalContants;
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

public class Level08_DynamicPage extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private CustomerInforPageObject customerInforPage;
	private AddressPageObject addressPage;
	private MyProductionReviewPageObject myProductionReviewPage;
	private RewardPointPageObject rewardPointPage;

	private String passWord = "12345@Fra";
	private String repassWord = "12345@Fra";
	private String cusEmail;
	
	//@Parameters("browser")	
	@BeforeClass
	public void beforeClass(String browserName) {
		System.setProperty("webdriver.chrome.driver", GlobalContants.PROJECT_PATH + "\\browserDrivers\\chromedriver.exe");
		driver = getBrowserDriver(browserName);	
		cusEmail = "username" + getRandomNumber() + "@gmail.com";
		homePage = PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void TC01_Register_Login_Account() {
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
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(cusEmail);
		loginPage.inputToPasswordTextBox(passWord);
		loginPage.clickToLoginButton();
		customerInforPage = homePage.clickToMyAccountLink();
	}

	@Test
	public void TC04_Dynamic_Page() {
		addressPage = (AddressPageObject) customerInforPage.openPagesAtLeftMenu(driver, "Addresses");
		myProductionReviewPage = (MyProductionReviewPageObject) addressPage.openPagesAtLeftMenu(driver, "My product reviews");
		rewardPointPage = (RewardPointPageObject) myProductionReviewPage.openPagesAtLeftMenu(driver, "Reward points");
		addressPage = (AddressPageObject) rewardPointPage.openPagesAtLeftMenu(driver, "Addresses");
		rewardPointPage = (RewardPointPageObject) addressPage.openPagesAtLeftMenu(driver, "Reward points");
		myProductionReviewPage = (MyProductionReviewPageObject) rewardPointPage.openPagesAtLeftMenu(driver, "My product reviews");
		addressPage = (AddressPageObject) myProductionReviewPage.openPagesAtLeftMenu(driver, "Addresses");
		customerInforPage = (CustomerInforPageObject) addressPage.openPagesAtLeftMenu(driver, "Customer info");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
