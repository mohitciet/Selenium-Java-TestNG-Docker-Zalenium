package com.sohambko.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sohambko.qa.base.BaseTest;
import com.sohambko.qa.base.TestBase;
import com.sohambko.qa.pages.ContactsPage;
import com.sohambko.qa.pages.HomePage;
import com.sohambko.qa.pages.LoginPage;
import com.sohambko.qa.util.Constants;
import com.sohambko.qa.util.ExcelUtil;

public class ContactsPageTest extends BaseTest {

	@Test(priority = 1)
	public void verifyContactsPageLabel() {
		HomePage homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		ContactsPage contactsPage = homePage.clickOnContactsLink();
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
	}

	@Test(priority = 2)
	public void verifyselectSingleContactsTest() {
		HomePage homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		ContactsPage contactsPage = homePage.clickOnContactsLink();
		contactsPage.selectContactsByName("First2 Last2");
	}

	@Test(priority = 3)
	public void verifyselectMultipleContactsTest() {
		HomePage homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		ContactsPage contactsPage = homePage.clickOnContactsLink();
		contactsPage.selectContactsByName("First2 Last2");
		contactsPage.selectContactsByName("FirstName LastName");

	}

	@DataProvider
	public Object[][] getContactsTestData() {
		Object data[][] = ExcelUtil.getTestData(Constants.CONTACTS_SHEET_NAME);
		return data;
	}

	public void verifyCreateNewContact(String title, String firstName, String lastName, String company) {
		HomePage homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		ContactsPage contactsPage = homePage.clickOnContactsLink();
		contactsPage.createNewContact(title, firstName, lastName, company);

	}

}