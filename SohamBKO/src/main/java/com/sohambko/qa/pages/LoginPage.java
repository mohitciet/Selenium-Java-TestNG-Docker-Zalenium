package com.sohambko.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sohambko.qa.base.TestBase;
import com.sohambko.qa.util.Constants;
import com.sohambko.qa.util.ElementUtil;

public class LoginPage extends TestBase{
	
	private WebDriver driver;
	ElementUtil elementUtil;
	
	// constructor of the page class:
		public LoginPage(WebDriver driver) {
			this.driver = driver;
			elementUtil = new ElementUtil(this.driver);
		}
		
		// By Locators -- OR
		By username = By.name("email");
		By password = By.name("password");
		By loginBtn = By.xpath("//div[@class='ui fluid large blue submit button']");
		By signUpLink = By.xpath("//button[contains(text(),'Sign Up')]");
		By crmLogo= By.className("brand-name");
		By login= By.xpath("//span[contains(text(),'Log In')]");
	

	
	//Actions:
	public String validateLoginPageTitle(){
		return elementUtil.doGetPageTitleWithIsTitle(10, Constants.LOGIN_PAGE_TITLE);
	}
	
	public boolean validateCRMImage(){
		return elementUtil.doIsDisplayed(crmLogo);
	}
	
	public HomePage login(String un, String pwd){
		elementUtil.doClick(login);
		elementUtil.doSendKeys(username, un);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginBtn);
		    	
		return new HomePage(driver);
	}
	
}