package bear.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.PageGeneratorManager;
import pageObject.RegisterPageObject;

public class Common_01_Register_New_Account extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private String passWord = "12345@Fra";
	private String repassWord = "12345@Fra";
	private String cusEmail;
	
	//@Parameters("browser")	
	@BeforeTest (description = " Create New Common User ")
	public void TC01_Register_Login_Account(String browserName) {
		driver = getBrowserDriver(browserName);	
		cusEmail = "username" + getRandomNumber() + "@gmail.com";
		homePage = PageGeneratorManager.getHomePage(driver);
		
		
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

	@AfterTest
	public void AfterTest() {
		driver.quit();
	}

}
