package com.intellias.web.qa.test.suites;

import java.util.HashMap;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.intellias.web.qa.test.LoginDataProvider;


/**
 * @author rpash
 * @version 1.0
 * 
 * Class contains test cases regarding page login 
 * 
 */
public class LoginTestSuite extends LoginPageObjectTestSuite{
	/**
     * Test check case when user login with correct credentials
     * @param  Username, User password, expected validation message
     * @return assert true or false
     * @throws error exception or exception
     */
	@Test (dataProvider = "fetchDataFromExcelFile", dataProviderClass = LoginDataProvider.class) 
	public void verifyLoggingWithCorrectCredentials(HashMap<String, String> userData) {
		Reporter.log("Test case when user credentials"+ 
					"are valid", true);
		loginToFrontendPage(userData.get("login"), userData.get("password"));
		System.out.println("Excel Data: " + userData);
		
		
	}
}
