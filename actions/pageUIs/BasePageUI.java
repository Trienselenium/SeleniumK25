package pageUIs;

public class BasePageUI {
	public static final String ADDRESSSES_LINK = "//div[contains(@class,'header-screen')]//a[text()='Giới thiệu']";
	public static final String MYPRODUCTREVIEW_LINK = "//div[contains(@class,'account-navigation')]//a[text()='My produc review']";
	public static final String REWARDPOINT_LINK = "//div[contains(@class,'account-navigation')]//a[text()='Reward point']";
	public static final String CUSTOMER_INFO_LINK = "//a[@class='ico-register']";
	
	public static final String DYNAMIC_CATEGORIES_LEFT_MENU = "xpath=//div[@class='listbox']/ul[@class='list']//a[contains(text(),'%s')]";
	
	public static final String DYNAMIC_PAGES_LEFT_MENU = "xpath=//div[contains(@class,'account-navigation')]//a[text()='%s']";
	public static final String DYNAMIC_HEADER_MENU = "xpath=//ul[@class='top-menu notmobile']//a[normalize-space()='%s']";
	
	
	public static final String DYNAMIC_GENRAL_HEADER_MENU = "xpath=//ul[@class='top-menu notmobile']//a[normalize-space()='%s']";	
	
	
}
