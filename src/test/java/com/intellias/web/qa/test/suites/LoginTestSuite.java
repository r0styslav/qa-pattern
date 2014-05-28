package com.intellias.web.qa.test.suites;

import java.util.HashMap;

import junit.framework.Assert;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.intellias.web.qa.test.LoginDataProvider;
import com.intellias.web.qa.webelement.FirstPage;
import com.intellias.web.qa.webelement.IndexLoginFrontendPage;

/**
 * @author rpash
 * @version 1.0
 * 
 *          Class contains test cases regarding page login
 * 
 */
public class LoginTestSuite extends LoginPageObjectTestSuite {
	/**
	 * Test check case when user login with correct credentials
	 * 
	 * @param data
	 * @return assert true or false
	 * @throws InterruptedException
	 * @throws error
	 *             exception or exception
	 */
	@Test(dataProvider = "fetchDataFromExcelFile", dataProviderClass = LoginDataProvider.class)
	public void verifyLoggingWithCorrectCredentials(HashMap<String, String> userData) throws InterruptedException {
		Reporter.log("Test case when user credentials " + "are valid", true);
		loginToFrontendPage(userData.get("login"), userData.get("password"));
		Assert.assertTrue(FirstPage.getFirstPageInfo(driver).isDisplayed());
		Reporter.log("Log-in finished \n", true);
		Reporter.log("<br />");
		logoutFromFrontendPage();
		Assert.assertTrue(IndexLoginFrontendPage.getLoginFrontendPageInfo(driver).isDisplayed());
		Reporter.log("Log-out in finished \n", true);
		Reporter.log("<br />");
	}
	

}
