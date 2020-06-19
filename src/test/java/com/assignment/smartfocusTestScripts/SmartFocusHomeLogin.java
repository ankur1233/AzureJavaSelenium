package com.assignment.smartfocusTestScripts;

import org.apache.log4j.Logger;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.assignment.smartfocusComponent.BaseClass;
import com.assignment.smartfocusComponent.SmartFocusComponents;
import com.assignment.smartfocusPageObject.SmartFocusHomePageObject;
import com.assignment.smartfocusPageObject.SmartFocusLoginPageObject;


public class SmartFocusHomeLogin {

	final static Logger logger = Logger.getLogger(SmartFocusHomeLogin.class);
	
	@BeforeClass
	public void setup () {
		BaseClass.launchApp();		
	}
	

	@Test(priority=1)
	public void VerifyLogin() throws InterruptedException {

		SmartFocusHomePageObject homePage = new SmartFocusHomePageObject(BaseClass.driver);
		SmartFocusLoginPageObject loginPage = new SmartFocusLoginPageObject(BaseClass.driver);
		SmartFocusComponents componets = new SmartFocusComponents();

		logger.info("Initialize driver for homePage , LoginPage");

		homePage.searchinputField.sendKeys("smartfocus uk");
		homePage.searchinputField.sendKeys(Keys.ENTER);
		componets.waitForToLoad();
		homePage.smarkFocusLink.click();		

		logger.info("Result link click");
		componets.waitForToLoad();
		
		homePage.switchlang.click();
		homePage.lang.click();
		homePage.smarkFocusLoginLink.click();
		
		componets.waitForToLoad(2000);
		
		homePage.acceptcheckBox.click();
		homePage.LoginButton.click();
		componets.waitForToLoad();

		logger.info("Login Page loaded smart focus");

		componets.switchToTab();
		
		loginPage.userNameField.sendKeys("Test");
		loginPage.passwordField.sendKeys("test1234");
		loginPage.loginButton.click();

		logger.info("verfying login field");
		Assert.assertTrue(componets.verifyText("Invalid User Name OR Password"));

		logger.info("verfying login field :PASS");
		
	}
	
	
	@Test(priority=2)
	public void TestDemo_Fail() {
		Assert.assertTrue(false);
		
	}
		
	
	
	@AfterClass
	public void aftertest() {
		BaseClass.closeApp(); 
	}
}
