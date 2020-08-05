package com.sohambko.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sohambko.qa.base.TestBase;
import com.sohambko.qa.util.ElementUtil;

public class ContactsPage extends TestBase {
	
	private WebDriver driver;
	ElementUtil elementUtil;
	
	// constructor of the page class:
		public ContactsPage(WebDriver driver) {
			this.driver = driver;
			elementUtil = new ElementUtil(this.driver);
		}
		
		// By Locators -- OR
		By contactsLabel = By.xpath("//span[contains(text(),'Contacts')]");
		By firstName = By.xpath("//input[@name='first_name']");
		By lastName = By.xpath("//input[@name='last_name']");
		By company = By.xpath("//div[@name='company']//input[@class='search']");
		By saveBtn = By.xpath("//button[@class='ui linkedin button']");
	
	
	
	
	public boolean verifyContactsLabel(){
		return elementUtil.doIsDisplayed(contactsLabel);
	}
	
	
	public void selectContactsByName(String name){
		elementUtil.doClick(By.xpath("//td[text()='"+name+"']//preceding-sibling::td/div"));
	}
	
	
	public void createNewContact(String title, String ftName, String ltName, String comp){
		
		elementUtil.doClick(By.xpath("//button[contains(text(),'New')]"));
		elementUtil.doSendKeys(firstName, ftName);
		elementUtil.doSendKeys(lastName, ltName);
		elementUtil.doSendKeys(company, comp);
		elementUtil.doClick(saveBtn);
		
	}
	
	
	

}