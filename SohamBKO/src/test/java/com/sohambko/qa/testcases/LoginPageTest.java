package com.sohambko.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sohambko.qa.base.BaseTest;
import com.sohambko.qa.base.TestBase;
import com.sohambko.qa.pages.HomePage;
import com.sohambko.qa.pages.LoginPage;

public class LoginPageTest extends BaseTest{
	
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small");
	}
	
	@Test(priority=2)
	public void verifyrCmLogoImageTest(){
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void verifyUserABleTologinTest(){
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	
	
	

}