package com.intellias.web.qa.test;

import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.intellias.web.qa.data.MsExcelDataProvider;

public class LoginDataProvider {
	
	final static String fileName = "LoginDataFile";
	
	@DataProvider (name = "fetchDataFromExcelFile")
	public static Iterator<Object[]> getDataFromExcelFile () throws IOException {
		return MsExcelDataProvider.getMsExcelData(fileName);
	}

}
