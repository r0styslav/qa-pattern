package com.intellias.web.qa.test.suites;

import org.testng.annotations.Test;

import com.intellias.web.qa.configuration.Configuration;
import com.intellias.web.qa.configuration.ConfigurationBrowser;
import com.intellias.web.qa.configuration.ConfigurationEnvironment;

/**
 * 
 * @author rpash
 * @version 1.0
 */
public class ProjectTestSuit extends MainTestSuit {
	
	@Test()
	public void runFrontendPage () {
		try {
			driver.navigate().to(configuration.getFrontendUrl());
		} catch (Exception e) {
			System.out.println("Check environment properties, bad URL");
			e.printStackTrace();
		}
	}

}
