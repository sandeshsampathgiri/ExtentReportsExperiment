package com.qa.hubspot.tests;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.util.CommonUtil;

public class LoginPageTests {

	BasePage basePage;
	WebDriver driver;
	Properties properties;
	LoginPage loginPage;

	@BeforeMethod
	public void setUp() {

		/*
		 * basePage = new BasePage(); properties = new Properties(); loginPage = new
		 * LoginPage(driver); driver.get(properties.getProperty("url"));
		 */

		basePage = new BasePage();
		properties = basePage.initializeProperties();
		driver = basePage.initializeDriver(properties);
		driver.get(properties.getProperty("url"));
		CommonUtil.mediumWait();
		// loginPage = new LoginPageUsingPageFactory(driver);
		loginPage = new LoginPage(driver);

	}

	@Test
	public void verifyLoginPageTitle() {

		//This method verifies the page title
		String loginPageTitle = loginPage.getLoginPageTitle();
		System.out.println("Login page title is: " + loginPageTitle);
		Assert.assertEquals(loginPageTitle, "HubSpot Login", "Login page title is incorrect");

	}

	@Test
	public void verifySignUpLnkIsPresent() {

		//This method verifies if the signup link is present
		Assert.assertTrue(loginPage.verifySignUpLink(), "Signup Link is not displayed");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
