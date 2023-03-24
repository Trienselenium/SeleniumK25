package pageUIs;

import org.testng.Assert;

public class HomePageUI {
	public static final String REGISTER_LINK ="//a[@class='ico-register']";
	public static final String LOGIN_LINKA = "//a[@class='ico-login']";
	public static final String MYACCOUNT_LINK = "//a[@class='ico-account']";
	//public static final String DEPARTURE_TEXTBOX = "//div[contains(@class,'MuiFormControl-root MuiTextField-root')]//label[text()='Điểm khởi hành']";
	public static final String DEPARTURE_TEXTBOX = "//div[@class='MuiFormControl-root MuiTextField-root jss589 MuiFormControl-fullWidth']//input[@type='text']";	
	public static final String DEPARTURE_CHILD_TEXTBOX = "//div[contains(@class,'MuiBox-root')]//div[text()='SGN']";
	public static final String RETURN_TEXTBOX = "//div[contains(@class,'MuiFormControl-root MuiTextField-root')]//label[text()='Điểm đến']/following-sibling::div/input[@type='text']";
	public static final String RETURN_CHILD_TEXTBOX = "//div[contains(@class,'MuiBox-root')]//div[text()='HAN']";	
	public static final String IGNORE_BUTTON = "//div[@class='slidedown-footer']/button[text()='Bỏ qua']";	
	public static final String ONEWAY_RADIO = "//label[contains(@class,'MuiFormControlLabel-root')]//input[@value='oneway']";
	public static final String DEPARTURE_DATE = "//span[contains(text(),'20')]";
	public static final String PASSENGER_COMBOBOX = "//div[@class='jss5']//div[@class='MuiFormControl-root jss846']//div[2]//*[name()='svg']";
	public static final String SEARCH_BOOKING_BUTTON = "//div[@class='jss831']//span[@class='MuiButton-label'][contains(text(),'Tìm chuyến bay')]";
	public static final String TICKETTYPE_LABEL = "//p[contains(@class,'MuiTypography-root')][normalize-space()='2,650']";
	public static final String TICKETPRICE_LABEL = "//div[@class='slick-slide slick-active']//span";
	public static final String TICKET_ALL_LIST_ABOVE = "//div[@class='slick-list']/div/div";
	
	public static final String TICKET_ALL_LIST_BELOW = "//div[@class='slick-slider slick-initialized']/parent::div/following-sibling::div[2]";
	public static final String TICKET_EACH_PRICE_LIST = "//div[@class='slick-slider slick-initialized']/parent::div/following-sibling::div[2]/div[2]/div[1]/div";	
	
	public static final String TICKET_PRICE_LIST = "//div[@class='slick-list']//span[1]";
	
	public static final String CONTINUE_BUTTON = "//button[contains(@class,'MuiButtonBase-root MuiButton-root MuiButton-contained')]//span[text()='Đi tiếp']";	
	public static final String BOOKING_MSG_LABEL = "//div[contains(@class,'MuiBox-root')]//h5[contains(text(),'Không tìm thấy chuyến bay nào cho lựa chọn của bạn')]";
	public static final String PAYMENTMETHOD_BUTTON = "//h4[normalize-space()='Thanh toán']";
	public static final String PAYLATER_RADIO = "//h4[contains(text(),'Giữ mã đặt chỗ & thanh toán sau')]";
	public static final String PAYNGAY_RADIO = "//h4[contains(text(),'Thanh toán ngay')]";
	
	
	public static final String DATAINDEX = "//div[@class='slick-slide slick-active slick-center slick-current']";
	public static final String DATAINDEX_DYNAMIC = "xpath=//div[@class='slick-track']//div[@data-index='%s']";
	
	public static final String RESULT_CODE = "//span[contains(text(),'Mã đặt chỗ')]/following-sibling::span";	
	
	public static final String WAIT_TT_BUTTON = "//h4[normalize-space()='Thanh toán']/parent::span/parent::button[not(@disabled)]";
}
