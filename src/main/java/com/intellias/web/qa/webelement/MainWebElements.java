package com.intellias.web.qa.webelement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * @author rpash
 * @version 1.0
 * 
 * Parent class for web elements
 * 
 */
public class MainWebElements {
	
	protected static WebDriver webDriver = null;
	protected static WebElement webElement = null;
	
	/**
	 * Initializes the class variables with appropriate WebElement and WebDriver instances
	 * @param webDriver
	 * @param webElement
	 */
	public MainWebElements (WebDriver webDriver, WebElement webElement) {
		this.webDriver = webDriver;
		this.webElement = webElement;
	}

	public static WebElement getWebElement() {
		return webElement;
	}
	
	
	

}
