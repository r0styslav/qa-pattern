package com.intellias.web.qa.test.suites;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.intellias.web.qa.configuration.Configuration;
import com.intellias.web.qa.configuration.ConfigurationBrowser;
import com.intellias.web.qa.configuration.ConfigurationEnvironment;
import com.intellias.web.qa.factory.WebDriverFactory;

/**
 * @author rpash
 * @version 1.0
 * Main test class 
 * 
 */
public class MainTestSuit {
	protected static WebDriver driver = null;
	protected static Configuration configuration = null;
	
	@BeforeMethod
	@Parameters({"desireBrowser", "desireEnvironment" })
	public void setUp(@Optional ConfigurationBrowser desireBrowser, 
			@Optional ConfigurationEnvironment desireEnvironment) {
		System.out.println("This is desire Browser - " + desireBrowser + " and desire environment - "+desireEnvironment);
		configuration = Configuration.getConfiguration(desireBrowser, desireEnvironment);
		driver = WebDriverFactory.getWebDriver(configuration);
	}
	
	@AfterMethod
	public void shutDown () {
		driver.quit();
	}
	
	
	
	

}
