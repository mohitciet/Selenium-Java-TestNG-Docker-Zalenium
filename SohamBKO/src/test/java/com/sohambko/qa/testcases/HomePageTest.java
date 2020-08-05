package com.sohambko.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sohambko.qa.base.BaseTest;
import com.sohambko.qa.base.TestBase;
import com.sohambko.qa.pages.ContactsPage;
import com.sohambko.qa.pages.HomePage;
import com.sohambko.qa.pages.LoginPage;


public class HomePageTest extends BaseTest {
	
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		HomePage homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM","Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		HomePage homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest(){
		HomePage homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		ContactsPage contactsPage = homePage.clickOnContactsLink();
	}
	
	
	

}