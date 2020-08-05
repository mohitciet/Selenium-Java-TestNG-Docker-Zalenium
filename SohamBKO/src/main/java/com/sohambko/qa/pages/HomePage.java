package com.sohambko.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sohambko.qa.base.TestBase;
import com.sohambko.qa.util.Constants;
import com.sohambko.qa.util.ElementUtil;

public class HomePage extends TestBase {
	
	private WebDriver driver;
	ElementUtil elementUtil;
	
	// constructor of the page class:
		public HomePage(WebDriver driver) {
			this.driver = driver;
			elementUtil = new ElementUtil(this.driver);
		}
		
		// By Locators -- OR
		By userNameLabel = By.xpath("//span[contains(text(),'Mohit Singla')]");
		By contactsLink = By.xpath("//span[contains(text(),'Contacts')]");
		By newContactLink = By.xpath("//a[contains(text(),'Deals')]");
		By dealsLink = By.xpath("//button[contains(text(),'Sign Up')]");
		By tasksLink= By.xpath("//a[contains(text(),'Tasks')]");


	
	public String verifyHomePageTitle(){
		return elementUtil.doGetPageTitleWithIsTitle(10, Constants.HOME_PAGE_TITLE);
	}
	
	
	public boolean verifyCorrectUserName(){
		return elementUtil.doIsDisplayed(userNameLabel);
	}
	
	public ContactsPage clickOnContactsLink(){
		elementUtil.doClick(contactsLink);
		return new ContactsPage(driver);
	}
	
	public DealsPage clickOnDealsLink(){
		elementUtil.doClick(dealsLink);
		return new DealsPage();
	}
	
	public TaskPage clickOnTasksLink(){
		elementUtil.doClick(tasksLink);
		return new TaskPage();
	}
	
	public void clickOnNewContactLink(){
		elementUtil.doActionsClick(newContactLink);
	
		
	}
	
	
	
	
	
	
	

}