package com.crm.qa.pages;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//page factory or object repository
	
	@FindBy(xpath="//td[contains(text(),'User: Vineela K')]")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	//initialize objects of page factory
	
		public HomePage() {
			PageFactory.initElements(driver, this); // This is current class object
		}
	
	//Actions
	public String verifyHomePageTitle() {
		return driver.getTitle();
		
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickonTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public void clickOnNewContactLink() {
		Actions action = new Actions(driver); // for mouse overs .. drag and drops
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}
	
}
