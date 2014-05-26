package com.intellias.web.qa.test.suites;

import javax.swing.Timer;

import com.intellias.web.qa.configuration.Configuration;







/**
* @author rpash
* @version 1.0
*/
public class LoginPageObjectTestSuite extends MainTestSuit{

	protected void loginToFrontendPage (String userName, String password) {
		driver.get(configuration.getFrontendUrl());
		
	}
}
