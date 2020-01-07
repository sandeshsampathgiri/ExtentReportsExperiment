package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	WebDriver driver;
	Properties properties;

	public WebDriver initializeDriver(Properties properties) {
		String browserName = properties.getProperty("browser");
		System.out.println("Browser name= " + browserName);

		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			options.addArguments("--disable-notifications");
			options.addArguments("--disable-infobars");
			options.addArguments("start-maximized");
			options.setAcceptInsecureCerts(true);

			driver = new ChromeDriver(options);
		} else {
			System.out.println("No browser is defined");
		}

		return driver;
	}
	
	public Properties initializeProperties()
	{
		try
		{
		properties = new Properties();
		String configPath = System.getProperty("user.dir");
		
		FileInputStream fis = new FileInputStream("E:\\API_Automation_Workspace\\ExtentReportsExperiment\\src\\main\\java\\com\\qa\\hubspot\\configuration\\config.properties");
		properties.load(fis);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return properties;
	}

}
