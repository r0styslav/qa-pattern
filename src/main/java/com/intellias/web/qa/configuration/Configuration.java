package com.intellias.web.qa.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.testng.annotations.Optional;

/**
 * Configuration class 
 * 
 */
public class Configuration {	
	
	private String browser;
	private String frontendUrl;
	private String backendUrl;
	private String driverMode;
	private String seleniumGridAddress;
	private String appLanguage;
	private boolean parameterBrowserPresent;
	private boolean parameterEnvironmentPresent;
	private static String environmentConfigurationFilePath = "src/test/java/com/intellias/web/qa/test/settings/defaultEnvironment.properties";
	private static String browserConfigurationFilePath =     "src/test/java/com/intellias/web/qa/test/settings/defaultBrowser.properties";
	/**
	 * Method is used to fetch test configuration
	 * @param desireBrowser - set preferable browser or set from property file
	 * @param desireEnvironment - set preferable environment or set from property file
	 * @return configuration - environment and browser setup
	 * 
	 */
	public static Configuration getConfiguration (@Optional ConfigurationBrowser desireBrowser, 
			@Optional ConfigurationEnvironment desireEnvironment) {
		Configuration configuration = new Configuration();
		Properties environmentConfigurationProperties = new Properties();
		Properties browserConfigurationProperties = new Properties();
		configuration.parameterBrowserPresent = false;
		configuration.parameterEnvironmentPresent = false;
		
		if (desireEnvironment != null) {
			configuration.parameterEnvironmentPresent = true;
		}
		
		try {
			environmentConfigurationProperties.load(new FileInputStream(environmentConfigurationFilePath));
		} catch (IOException e) {
			System.out.println("==== Something wrong with environment file property ==========");
			e.printStackTrace();
		}	
		
		configuration.driverMode = (configuration.parameterEnvironmentPresent ? desireEnvironment.toString() : environmentConfigurationProperties.getProperty("driverMode"));
		configuration.frontendUrl = environmentConfigurationProperties.getProperty("frontendURL");
		configuration.backendUrl = environmentConfigurationProperties.getProperty("backendURL");
		configuration.seleniumGridAddress = environmentConfigurationProperties.getProperty("seleniumGridAddress");
		configuration.appLanguage = environmentConfigurationProperties.getProperty("appLanguage");	
		System.out.println("Configuration Mode set to - " + configuration.driverMode);		
		
		if (desireBrowser != null) {
			configuration.parameterBrowserPresent = true;
		}	
	
		try {
			browserConfigurationProperties.load(new FileInputStream(browserConfigurationFilePath));
			//to be deleted 
			System.out.println("?????------>>>>>"+browserConfigurationProperties);
		} catch (IOException e) {
			System.out.println("===== Something wrong with browser file property ========");
			e.printStackTrace();
		}
		
		configuration.browser = (configuration.parameterBrowserPresent ? desireBrowser.toString() : browserConfigurationProperties.getProperty("browser"));
		System.out.println("Browser is set to - " + configuration.browser);
		
		return configuration;
	}

	/**
	 * Method is used to get browser type
	 * @return browser 
	 */
	public String getBrowser() {
		return browser;
	}
	/**
	 * Method is used to get frontend URL
	 * @return frontendUrl 
	 */
	public String getFrontendUrl() {
		return frontendUrl;
	}
	/**
	 * Method is used to get backend URL
	 * @return backendUrl 
	 */
	public String getBackendUrl() {
		return backendUrl;
	}
	/**
	 * Method is used to get web driver mode
	 * @return driverMode 
	 */
	public String getDriverMode() {
		return driverMode;
	}
	/**
	 * Method is used to get Selenium GRID server address
	 * @return seleniumGridAddress 
	 */
	public String getSeleniumGridAddress() {
		return seleniumGridAddress;
	}
	/**
	 * Method is used to get environment language 
	 * @return appLanguage 
	 */
	public String getAppLanguage() {
		return appLanguage;
	}


}
