package com.sohambko.qa.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.sohambko.qa.pages.HomePage;
import com.sohambko.qa.pages.LoginPage;

public class BaseTest {

	public WebDriver driver;
	public Properties prop;
	public TestBase basePage;
	public LoginPage loginPage;
	public HomePage homePage;



	// Code to input browser name from TestNG.xml as Parameter annotation

	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browserName) throws Exception {

		System.out.println("Thread ID : " + Thread.currentThread().getId());
		basePage = new TestBase();
		prop = basePage.init_prop();
		prop.setProperty("browser", browserName);
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

//@BeforeMethod
//public void setUp() throws Exception {
//	String browserName = prop.getProperty("huburl");
////    System.out.println("browser name is : " + browserName);
////   System.out.println("Thread ID : "+Thread.currentThread().getId());
////	basePage = new TestBase();
////	prop = basePage.init_prop();
////	prop.setProperty("browser", browserName);
////	driver = basePage.init_driver(prop);
////	loginPage = new LoginPage(driver);
//}
