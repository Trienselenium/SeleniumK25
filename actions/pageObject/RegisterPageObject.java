package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;
	
	public RegisterPageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	public void clickToRegisterButton() {
		// TODO Auto-generated method stub
		waitForWebElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public String getErrorMessageAtFirstnameTextbox() {
		// TODO Auto-generated method stub
		waitForWebElementVisible(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);		
		return getElementText(driver, RegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtLastnameTextbox() {
		// TODO Auto-generated method stub
		waitForWebElementVisible(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE);		
		return getElementText(driver, RegisterPageUI.LASTNAME_ERROR_MESSAGE);
	}

	public String getErrorMessageAtEmailTextbox() {
		// TODO Auto-generated method stub
		waitForWebElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);		
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}

	public String getErrorMessageAtPasswordTextbox() {
		// TODO Auto-generated method stub
		waitForWebElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);		
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}
	
	public String getErrorMessageAtConfirmPasswordTextbox() {
		// TODO Auto-generated method stub
		waitForWebElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);		
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}
	public void clickToGenderCheckbox() {
		// TODO Auto-generated method stub
		waitForWebElementClickable(driver, RegisterPageUI.GENDER_CHECKBOX);
		clickToElement(driver, RegisterPageUI.GENDER_CHECKBOX);
	}

	public void inputToFirstNameTextbox(String fistName) {
		// TODO Auto-generated method stub
		waitForWebElementVisible(driver, RegisterPageUI.FRISTNAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.FRISTNAME_TEXTBOX, fistName);

	}

	public void inputToLastNameTextbox(String lastName) {
		// TODO Auto-generated method stub
		waitForWebElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
	}

	public void inputToEmailTextbox(String email) {
		// TODO Auto-generated method stub
		waitForWebElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String password) {
		// TODO Auto-generated method stub
		waitForWebElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		// TODO Auto-generated method stub
		waitForWebElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
	}

	public String getRegisterSuccessMessage() {
		// TODO Auto-generated method stub		
		return getElementText(driver, RegisterPageUI.REGISTER_PASSWORD_SUCCESS_MESSAGE);
	}

	public HomePageObject clickToLogoutLink() {
		// TODO Auto-generated method stub
		waitForWebElementVisible(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}

	public String getErrorExistingEmailMessage() {
		// TODO Auto-generated method stub
		return getElementText(driver, RegisterPageUI.EXISTING_EMAILL_ERROR_MESSAGE);
	}

	public void clickToRegisterLink() {
		
		// TODO Auto-generated method stub
		waitForWebElementVisible(driver, RegisterPageUI.REGISTER_LINK);
		clickToElement(driver, RegisterPageUI.REGISTER_LINK);
		
	}

}
