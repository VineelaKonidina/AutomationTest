package com.crm.qa.testcases;
/*
 * 
 * @author Vineela K
 */



import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName = "contacts";
	
	
	public ContactsPageTest() {
		super();
	}
	//Define annotations
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage(); // create login page object
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password")); // by using login page object we are calling login method
		//TestUtil.runTimeInfo("error", "login successful");
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test()
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts Label is Missing on the Page");
	}
	
//	@Test()
//	public void selectContactsTest() {
//		contactsPage.selectContactsByName("Test Test");
//	}
	
//	@Test()
//	public void selectMultipleContactsTest() {
//		contactsPage.selectContactsByName("autom test");
//		contactsPage.selectContactsByName("Test Test");
//	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] =  TestUtil.getTestData(sheetName);
		return data;
	}
//	@Test(dataProvider="getCRMTestData")
//	public void validateCreateNewContact(String title,String firstName,String lastName,String company ) {
//		homePage.clickOnNewContactLink();
//		//contactsPage.createNewContact("Mr.", "Peter", "Heins", "Animation");
//		contactsPage.createNewContact(title, firstName, lastName, company);
//	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
