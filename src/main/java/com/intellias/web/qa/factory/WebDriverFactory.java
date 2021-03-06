package com.intellias.web.qa.factory;

import org.openqa.selenium.WebDriver;

import com.intellias.web.qa.configuration.Configuration;

/**
 * @author rpash
 * @version 1.0
 * 
 *  Class for locators for login
 * 
 */
public class WebDriverFactory {
	
	/**
	 * Method is used to fetch WebDriver
	 * @param configuration - Configuration 
	 * @return driver - WebDriver
	 */
	public static WebDriver getWebDriver (Configuration configuration) {
		WebDriver driver = null;

		driver = WebDriverProvider.getWebDriver(configuration);	
		return driver;
	}
	
}
