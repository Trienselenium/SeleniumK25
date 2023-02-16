package demo.nopcommerce;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.CategoriesPageObject;
import pageObject.HomePageObject;
import pageObject.PageGeneratorManager;
import pageUIs.BasePageUI;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Topic0708_nopcommerce extends BaseTest{
	WebDriver driver;
	private HomePageObject homePage;
	private CategoriesPageObject categoriesPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);		
	}

	
	@Test
	public void TC1() {
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.openCategoriesAtHeaderMenu_Dynamic_Driver(driver, BasePageUI.DYNAMIC_GENRAL_HEADER_MENU, "Computers");
		/*
		 * categoriesPage.openCategoriesAtHeaderMenu_Driver("Desktops");
		 * categoriesPage.clickToCategoriesLeftMenu_Dynamic("Notebooks");
		 * categoriesPage.clickToCategoriesLeftMenu_Dynamic("Software");
		 * categoriesPage.openCategoriesAtHeaderMenuA("Desktops");
		 */
		//
		categoriesPage.openCategoriesAtHeaderMenu_Driver(driver, "Electronics");
		categoriesPage.sleepInSecond(2);
		categoriesPage.openCategoriesAtHeaderMenu_PageObject_Dynamic(driver, "Apparel");
		categoriesPage.sleepInSecond(2);
		categoriesPage.openCategoriesAtHeaderMenu_Dynamic_Driver(driver, BasePageUI.DYNAMIC_GENRAL_HEADER_MENU, "Electronics");
		categoriesPage.sleepInSecond(2);
		System.out.println("############## Electronics#################: ");
		categoriesPage.openCategoriesAtHeaderMenu_Dynamic_Driver(driver, BasePageUI.DYNAMIC_GENRAL_HEADER_MENU, "Digital downloads");
		categoriesPage.sleepInSecond(2);
		System.out.println("############## Digital downloads#################: ");

		
	}
	
	@Test
	public void TC2() {

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
