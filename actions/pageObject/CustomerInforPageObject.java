package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.CustomerInforPageUI;


public class CustomerInforPageObject extends BasePage{
	private WebDriver driver;
	
	public CustomerInforPageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		//Phải tạo cái hàm này thì qua PageGeneratorManager mới khởi tạo new MyAccountPageObject 
		this.driver = driver;
	}


}
