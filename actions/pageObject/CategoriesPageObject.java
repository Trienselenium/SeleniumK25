package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.BasePageUI;

public class CategoriesPageObject extends BasePage{
	private WebDriver driver;
	
	public CategoriesPageObject(WebDriver driver) {
		this.driver = driver;
	}
		
	public BasePage openCategoriesAtHeaderMenu_PageObject_Dynamic(WebDriver driver,String pageName) {
		System.out.println("##############openCategoriesAtHeaderMenu_PageObject_Dynamic#################: " + pageName);
		waitForWebElementClickableDynamic(driver,BasePageUI.DYNAMIC_HEADER_MENU,pageName);
		clickToElementDynamic(driver,BasePageUI.DYNAMIC_HEADER_MENU, pageName);
		switch (pageName) {
		case "Computers":
			return PageGeneratorManager.getComputersPage(driver);
		case "Electronics":
			return PageGeneratorManager.getElectronicsPage(driver);
		case "Apparel":
			return PageGeneratorManager.getApparelPage(driver);
		case "Digital downloads":
			return PageGeneratorManager.getDigitaldownloadsPage(driver);
		default:
			throw new RuntimeException("Invalid Page Name after Login and go to Each Page");
		}
	}
	

}
