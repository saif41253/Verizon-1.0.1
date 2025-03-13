package com.crm.genericutility.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtilityTest {
	public String fetchDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./configAppsData/commondata1.properties");
		Properties prop = new Properties();
		prop.load(fis);
		 String data = prop.getProperty(key);
		return data;
	}


}
