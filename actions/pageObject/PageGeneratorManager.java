package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;

public class PageGeneratorManager {
	public WebDriver driver;
	public PageGeneratorManager(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
		
	}
	public static CategoriesPageObject getCategoriesPage(WebDriver driver) {
		return new CategoriesPageObject(driver);		
	}
	
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
		
	}
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
		 
	}
	
	public static CustomerInforPageObject getCustomerInforPage(WebDriver driver) {
		return new CustomerInforPageObject(driver);		
	}	
	
	
	public static AddressPageObject getAddressPage(WebDriver driver) {
		return new AddressPageObject(driver);		
	}	
	
	public static MyProductionReviewPageObject getMyProductionReviewPage(WebDriver driver) {
		return new MyProductionReviewPageObject(driver);
		
	}	
	
	public static RewardPointPageObject getRewardPointPage(WebDriver driver) {
		return new RewardPointPageObject(driver);		
	}
	
	public static ComputersPageObject getComputersPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new ComputersPageObject(driver);
	}
	public static ElectronicsPageObject getElectronicsPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new ElectronicsPageObject(driver);
	}
	public static ApparelPageObject getApparelPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new ApparelPageObject(driver);
	}
	public static BasePage getDigitaldownloadsPage(WebDriver driver) {
		// TODO Auto-generated method stub
		return new DigitaldownloadsPageObject(driver);
	}	
	
	
	
}
