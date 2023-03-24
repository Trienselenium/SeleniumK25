package pageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
	private WebDriver driver;
	public HomePageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public RegisterPageObject clickToRegisterLink() {
		// TODO Auto-generated method stub
		waitForWebElementClickable(driver,HomePageUI.REGISTER_LINK);
		clickToElement(driver,HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public LoginPageObject clickToLoginLink() {
		waitForWebElementVisible(driver,HomePageUI.LOGIN_LINKA);
		clickToElement(driver,HomePageUI.LOGIN_LINKA);
		return PageGeneratorManager.getLoginPage(driver);
	}

	public boolean isMyAccountLinkDisplayed() {
		// TODO Auto-generated method stub
		waitForWebElementVisible(driver,HomePageUI.MYACCOUNT_LINK);
		return isElementDisplayed(driver,HomePageUI.MYACCOUNT_LINK);
	}

	public CustomerInforPageObject clickToMyAccountLink() {
		// TODO Auto-generated method stub
		waitForWebElementVisible(driver,HomePageUI.MYACCOUNT_LINK);
		clickToElement(driver,HomePageUI.MYACCOUNT_LINK);
		return PageGeneratorManager.getCustomerInforPage(driver);
	}

	public void inputToDepartureTextBox(String textValue) {
		// TODO Auto-generated method stub
		waitForWebElementVisible(driver, HomePageUI.DEPARTURE_TEXTBOX);
		sendKeyToElement(driver, HomePageUI.DEPARTURE_TEXTBOX,textValue);

	}

	public void inputToReturnTextBox(String textValue) {
		// TODO Auto-generated method stub
		waitForWebElementVisible(driver, HomePageUI.RETURN_TEXTBOX);
		sendKeyToElement(driver, HomePageUI.RETURN_TEXTBOX,textValue);
	}
	

	
	public void clickToInorgeButton() {
		waitForWebElementClickable(driver, HomePageUI.IGNORE_BUTTON);
		clickToElement(driver, HomePageUI.IGNORE_BUTTON);
	}
	
	public void clickToOneWay() {
		waitForWebElementInvisible(driver, HomePageUI.ONEWAY_RADIO);
		clickToElement(driver, HomePageUI.ONEWAY_RADIO);
	}
	public void selectToDepartureDropDown(String expectedText) {		
		waitForWebElementVisible(driver, HomePageUI.DEPARTURE_TEXTBOX);
		selectCustomDropDown(driver, HomePageUI.DEPARTURE_TEXTBOX, HomePageUI.DEPARTURE_CHILD_TEXTBOX, expectedText);
	}	
	public void selectToReturnDropDown(String expectedText) {
		// TODO Auto-generated method stub
		waitForWebElementVisible(driver, HomePageUI.RETURN_TEXTBOX);
		selectCustomDropDown(driver, HomePageUI.RETURN_TEXTBOX, HomePageUI.RETURN_CHILD_TEXTBOX, expectedText);
	}

	public void chooseDepartureDate() {
		// TODO Auto-generated method stub
		waitForWebElementClickable(driver, HomePageUI.DEPARTURE_DATE);
		clickToElement(driver, HomePageUI.DEPARTURE_DATE);
	}

	public void choosePassenger() {
		// TODO Auto-generated method stub
		waitForWebElementClickable(driver, HomePageUI.PASSENGER_COMBOBOX);		
		clickToElement(driver, HomePageUI.PASSENGER_COMBOBOX);
	}

	public void clickToSearchBookingButton() {
		// TODO Auto-generated method stub
		waitForWebElementClickable(driver, HomePageUI.SEARCH_BOOKING_BUTTON);
		clickToElement(driver, HomePageUI.SEARCH_BOOKING_BUTTON);
	}

	
	
	public void chooseTicketType() {
		sleepInSecond(3);
		//waitForWebElementVisible(driver, HomePageUI.TICKETPRICE_LABEL);
		//waitForWebElementClickable(driver, HomePageUI.TICKET_ALL_LIST);	
		waitForWebElementVisible(driver, HomePageUI.TICKETTYPE_LABEL);
		clickToElement(driver, HomePageUI.TICKETTYPE_LABEL); 
	}

	public void clickToContinueButton() {		
		// TODO Auto-generated method stub
		waitForWebElementClickable(driver, HomePageUI.CONTINUE_BUTTON);
		clickToElement(driver, HomePageUI.CONTINUE_BUTTON);		
	}

	public void clickToPaymentMethodButton() {
		// TODO Auto-generated method stub
		waitForWebElementVisible(driver, HomePageUI.WAIT_TT_BUTTON);	
		waitForWebElementClickable(driver, HomePageUI.WAIT_TT_BUTTON);		
		clickToElement(driver, HomePageUI.WAIT_TT_BUTTON); 
	}

	public void clickToPayLaterRadio() {
		// TODO Auto-generated method stub
		waitForWebElementClickable(driver, HomePageUI.PAYLATER_RADIO);
		clickToWebElementByJS(driver, HomePageUI.PAYLATER_RADIO);
	}

	public String getResultCode() {
		// TODO Auto-generated method stub
		waitForAllWebElementVisible(driver, HomePageUI.RESULT_CODE);
		return getElementText(driver, HomePageUI.RESULT_CODE);		
	}	
	
	public void getPricesListBooking() {
		waitForAllWebElementVisible(driver, HomePageUI.TICKET_ALL_LIST_ABOVE);
		waitForAllWebElementVisible(driver, HomePageUI.TICKET_ALL_LIST_BELOW);
		if (getElementText(driver, HomePageUI.BOOKING_MSG_LABEL).contains("Không tìm thấy chuyến bay nào cho lựa chọn của bạn")){
			List<WebElement> allItem_Above = getWebElementList(driver, HomePageUI.TICKET_ALL_LIST_ABOVE);
			for (WebElement item_Above : allItem_Above) {
				
			}
		}
		List<WebElement> allItem = getWebElementList(driver, HomePageUI.TICKET_EACH_PRICE_LIST);
		String msg = getElementText(driver, HomePageUI.BOOKING_MSG_LABEL);
		
		for (WebElement item : allItem) {
			System.out.println("item:" + item.getText());
			int i = 3;
			if (!item.getText().equals("2,650")) {				
				clickToElementDynamic(driver, HomePageUI.DATAINDEX_DYNAMIC, String.valueOf(i));
				System.out.println("lặp:" + i);	
				i++;
			}
		}
	}

}
