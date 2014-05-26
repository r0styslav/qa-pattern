package com.intellias.web.qa.factory;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;

import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.intellias.web.qa.configuration.Configuration;
import com.intellias.web.qa.configuration.ConfigurationBrowser;
import com.intellias.web.qa.configuration.ConfigurationEnvironment;

/**
 * @author rpash
 * @version 1.0
 * 
 * WebDriver data provider Class 
 * 
 */
public class WebDriverProvider extends WebDriverFactory {
	
	final static String localSettingsPath = "src/test/java/com/intellias/web/qa/test/settings/";
	
	/**
	 * Method is used to fetch WebDriver according to browser and environment configuration
	 * @param configuration - test configurations 
	 * @return driver - WebDriver
	 * 
	 */
	public static WebDriver getWebDriver (Configuration configuration) {
		WebDriver driver = null;
		
		if (ConfigurationEnvironment.LOCAL.toString().equalsIgnoreCase(configuration.getDriverMode())) {
			try {
				driver = getLocalWebDriver(configuration);
			} catch (Exception e) {
				System.out.println("Something wrong with local WebDriver initialization");
				e.printStackTrace();
			}
		} else
		
		if (ConfigurationEnvironment.REMOTE.toString().equalsIgnoreCase(configuration.getDriverMode())) {
			try {
				driver = getRemoteWebDriver(configuration);
			} catch (Exception e) {
				System.out.println("Something wrong with getting remote WebDriver");
				e.printStackTrace();
			}
		} else {
			System.out.println("Incorrect Environment mode chosen");
		}
	
		return driver;
	}
	
	/**
	 * Method is used to fetch WebDriver for local tests
	 * @param configuration - test configurations 
	 * @return driver - WebDriver
	 * 
	 */
	private static WebDriver getLocalWebDriver(Configuration configuration) {
		WebDriver driver= null;

		if (configuration.getBrowser().equalsIgnoreCase(ConfigurationBrowser.CHROME.toString())) {
			System.setProperty("webdriver.chrome.driver", localSettingsPath + "chromedriver.exe");	
			driver = new ChromeDriver();	
		} else
		if (configuration.getBrowser().equalsIgnoreCase(ConfigurationBrowser.FF.toString())) {
			driver = new FirefoxDriver();	
		} else
		if (configuration.getBrowser().equalsIgnoreCase(ConfigurationBrowser.IE.toString())) {
			System.setProperty("webdriver.ie.driver", localSettingsPath + "IEDriverServer.exe");
			driver = new InternetExplorerDriver();	
		} else {
			System.out.println("Not supported browser");
		}
		
		return driver;
	}

	/**
	 * Method is used to fetch WebDriver for remote tests
	 * @param configuration - test configurations 
	 * @return driver - WebDriver
	 * 
	 */
	private static WebDriver getRemoteWebDriver (Configuration configuration) {
		WebDriver driver = null;
		
		DesiredCapabilities capabilities = getDesiredCapabilities(configuration); 
		try {
			driver = new RemoteWebDriver(URI.create(configuration.getSeleniumGridAddress()).toURL(),capabilities);
		} catch (MalformedURLException e) {
			System.out.println("Something wrong with remote WebDriver initialization");
			e.printStackTrace();
		}
		
		return driver;
	}

	/**
	 * Method is used to fetch DesiredCapabilities for remote tests
	 * @param configuration - test configurations 
	 * @return capabilities - DesiredCapabilities
	 * 
	 */
	private static DesiredCapabilities getDesiredCapabilities(Configuration configuration) {
		DesiredCapabilities capabilities = null;
		
		if (configuration.getBrowser().equalsIgnoreCase(ConfigurationBrowser.FF.toString())) {
			capabilities = DesiredCapabilities.firefox();
			capabilities.setJavascriptEnabled(true);
		}
		
		if (configuration.getBrowser().equalsIgnoreCase(ConfigurationBrowser.CHROME.toString())) {
			capabilities = DesiredCapabilities.chrome();
			capabilities.setJavascriptEnabled(true);
		}
		
		if (configuration.getBrowser().equalsIgnoreCase(ConfigurationBrowser.IE.toString())) {
			capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setJavascriptEnabled(true);
		}
			
		return capabilities;
	}

}
