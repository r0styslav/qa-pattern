package com.intellias.web.qa.test.suites;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.intellias.web.qa.data.MsExcelDataProvider;
import com.intellias.web.qa.webelement.FirstPage;
import com.intellias.web.qa.webelement.IndexLoginFrontendPage;
import com.intellias.web.qa.webelement.IndexLoginFrontendPage.LoginElementsName;

/**
 * @author rpash
 * @version 1.0
 * 
 * Class contains methods for TCs
 * 
 */
public class LoginPageObjectTestSuite extends MainTestSuit {
	private WebElement webElement = null;

	protected void loginToFrontendPage(String userName, String password) throws InterruptedException {
		driver.get(configuration.getFrontendUrl());
		webElement = IndexLoginFrontendPage.getLoginFieldByCssName(driver,
				LoginElementsName.USERNAME);
		webElement.clear();
		System.out.println("userName - " + userName);
		webElement.sendKeys(userName);
		webElement = IndexLoginFrontendPage.getLoginFieldById(driver,
				LoginElementsName.PASSWORD);
		webElement.clear();
		System.out.println("password - " + password);
		webElement.sendKeys(password);
		webElement = IndexLoginFrontendPage.getLoginButtonByXpathId(driver);
		webElement.click();
		Thread.sleep(5000);
	}
	
	protected void logoutFromFrontendPage () throws InterruptedException {
		webElement = FirstPage.logOutFromFrontendPage(driver);
		webElement.click();
		Thread.sleep(5000);
	}
}
