package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.LoginPageUI;


public class LoginPageObject extends BasePage{
	private WebDriver driver;
	
	public LoginPageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public HomePageObject clickToLoginButton() {
		waitForWebElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}
	
	public String getErrorMessageAtEmailTextbox() {
		waitForWebElementVisible(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public LoginPageObject clickToLoginLink() {
		// TODO Auto-generated method stub
		waitForWebElementVisible(driver, LoginPageUI.LOGIN_LINK);
		clickToElement(driver, LoginPageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public void inputToEmailTextbox(String invalidEmail) {
		// TODO Auto-generated method stub
		waitForWebElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, invalidEmail);
	}

	public String getErrorMessageWithNoRegisteredMail() {
		// TODO Auto-generated method stub
		waitForWebElementVisible(driver, LoginPageUI.EMAIL_NO_REGISTERED_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMAIL_NO_REGISTERED_ERROR_MESSAGE);
	}
	public void inputToPasswordTextBox(String passWord) {
		// TODO Auto-generated method stub
		waitForWebElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, passWord);
	}

}
