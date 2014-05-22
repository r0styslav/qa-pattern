package com.intellias.web.qa.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class RemoteTest {
//	WebDriver driver;
//	String baseUrl, nodeUrl;
//	
//	@BeforeTest
//	public void setUp() throws MalformedURLException {
//		baseUrl = "http://newtours.demoaut.com/";
//		nodeUrl = "http://192.168.1.230:4444/wd/hub";
//		DesiredCapabilities capability = DesiredCapabilities.firefox();
//		capability.setBrowserName("firefox");
//		capability.setPlatform(Platform.VISTA);
//		driver = new RemoteWebDriver(new URL(nodeUrl), capability);
//		
//	}
//	
//	@AfterTest
//	public void afterTest() {
//		driver.quit();
//	}
//	
//	@Test
//	public void simpleTest(){
//		driver.get(baseUrl);
//		Assert.assertEquals("Welcome: Mercury Tours", driver.getTitle());
//		
//	}
//	

}
