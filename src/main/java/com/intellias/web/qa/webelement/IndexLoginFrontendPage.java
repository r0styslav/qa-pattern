package com.intellias.web.qa.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author rpash
 * @version 1.0
 * 
 *  Class for locators for login
 * 
 */
public class IndexLoginFrontendPage extends MainWebElements {

	public static enum LoginElementsName {
		USERNAME, PASSWORD
	}

	public static enum LocatorDesireType {
		ID, NAME, XPATH_ID, XPATH_NAME, CSS_ID, CSS_NAME
	}

	/**
	 * Constructs the instance using provided WebDriver and WebElement
	 * 
	 * @param webDriver
	 * @param webElement
	 */
	public IndexLoginFrontendPage(WebDriver webDriver, WebElement webElement) {
		super(webDriver, webElement);
	}
	
	/**
	 * Method that return Web Element
	 * @param webDriver - WebDriver
	 * @param id - LoginElementsName parameter
	 * @return webElement - new WebElement
	 */
	public static WebElement getLoginFieldById(WebDriver webDriver,
			LoginElementsName id) {
		return webElement = webDriver.findElement(By.id(id.toString()
				.toLowerCase()));
	}
	
	/**
	 * Method that return Web Element
	 * @param webDriver - WebDriver
	 * @param name - LoginElementsName parameter
	 * @return webElement - new WebElement
	 */
	public static WebElement getLoginFieldByName(WebDriver webDriver,
			LoginElementsName name) {
		return webElement = webDriver.findElement(By.name(name.toString()
				.toLowerCase()));
	}

	/**
	 * Method that return Web Element
	 * @param webDriver - WebDriver
	 * @param xpathId - LoginElementsName parameter
	 * @return webElement - new WebElement
	 */
	public static WebElement getLoginFieldByXpathId(WebDriver webDriver,
			LoginElementsName xpathId) {
		return webElement = webDriver.findElement(By.xpath(".//*[@id='"
				+ xpathId.toString().toLowerCase() + "']"));
	}

	/**
	 * Method that return Web Element
	 * @param webDriver - WebDriver
	 * @param xpathName - LoginElementsName parameter
	 * @return webElement - new WebElement
	 */
	public static WebElement getLoginFieldByXpathName(WebDriver webDriver,
			LoginElementsName xpathName) {
		return webElement = webDriver.findElement(By.xpath(".//*[@name='"
				+ xpathName.toString().toLowerCase() + "']"));
	}

	/**
	 * Method that return Web Element
	 * @param webDriver - WebDriver
	 * @param cssId - LoginElementsName parameter
	 * @return webElement - new WebElement
	 */
	public static WebElement getLoginFieldByCssId(WebDriver webDriver,
			LoginElementsName cssId) {
		return webElement = webDriver.findElement(By.cssSelector("#"
				+ cssId.toString().toLowerCase()));
	}
	
	/**
	 * Method that return Web Element
	 * @param webDriver - WebDriver
	 * @param cssName - LoginElementsName parameter
	 * @return webElement - new WebElement
	 */
	public static WebElement getLoginFieldByCssName(WebDriver webDriver,
			LoginElementsName cssName) {
		return webElement = webDriver.findElement(By.cssSelector("[name="
				+ cssName.toString().toLowerCase() + "]"));
	}
	
	/**
	 * Method that return Web Element
	 * @param webDriver - WebDriver
	 * @return webElement - new WebElement
	 */
	public static WebElement getLoginButtonById(WebDriver webDriver) {
		return webElement = webDriver.findElement(By.id("loginbtn"));
	}
	
	/**
	 * Method that return Web Element
	 * @param webDriver - WebDriver
	 * @return webElement - new WebElement
	 */
	public static WebElement getLoginButtonByXpathId(WebDriver webDriver) {
		return webElement = webDriver.findElement(By.xpath(".//*[@id='loginbtn']"));
	}

	/**
	 * Method that return Web Element
	 * @param webDriver - WebDriver
	 * @return webElement - new WebElement
	 */
	public static WebElement getLoginButtonByXpathAttributeName(
			WebDriver webDriver) {
		return webElement = webDriver.findElement(By.xpath(".//*[@value='Log in']"));
	}

	/**
	 * Method that return Web Element
	 * @param webDriver - WebDriver
	 * @return webElement - new WebElement
	 */
	public static WebElement getLoginButtonByCssId(WebDriver webDriver) {
		return webElement = webDriver.findElement(By.cssSelector("#loginbtn"));
	}

	/**
	 * Method that return Web Element
	 * @param webDriver - WebDriver
	 * @return webElement - new WebElement
	 */
	public static WebElement getLoginButtonByCssAttributeName(
			WebDriver webDriver) {
		return webElement = webDriver.findElement(By.cssSelector("[value='Log in']"));
	}

	/**
	 * Method that return Web Element
	 * @param webDriver - WebDriver
	 * @return webElement - new WebElement
	 */
	public static WebElement getLoginFrontendPageInfo (WebDriver webDriver) {
		return webElement = webDriver.findElement(By.cssSelector(".homelink>a"));
	}

}
