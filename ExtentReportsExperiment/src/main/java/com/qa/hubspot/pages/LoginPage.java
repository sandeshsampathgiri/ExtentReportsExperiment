package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class LoginPage extends BasePage {

	WebDriver driver;

	By signUpLnk = By.xpath("//i18n-string[contains(text(),'Sign up')]");
	By emailAddressTxtBx = By.id("username");
	By passwordTxtBx = By.id("password");
	By loginBtn = By.id("loginBtn");

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	public String getLoginPageTitle() {
		return (driver.getTitle());

	}

	public boolean verifySignUpLink() {
		// return signUpLink.isDisplayed();

		return (driver.findElement(signUpLnk).isDisplayed());

	}
}
