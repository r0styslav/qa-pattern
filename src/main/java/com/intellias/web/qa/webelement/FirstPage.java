package com.intellias.web.qa.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstPage extends MainWebElements{

	public FirstPage(WebDriver webDriver, WebElement webElement) {
		super(webDriver, webElement);
	}

	public static WebElement logOutFromFrontendPage (WebDriver driver) {
		return webElement = driver.findElement(By.xpath(".//*[@id='page-header-wrapper']/div/div[1]/a[2]"));
	}
	
	public static WebElement getFirstPageInfo(WebDriver webDriver) {
		return webElement = webDriver.findElement(By.cssSelector("#usersettings>span"));
	}
}
