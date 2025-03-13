package com.crm.verizon.createQuoteTest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;

import com.crm.genericutility.test.DatabaseUtilityTest;
import com.crm.genericutility.test.ExcelUtilityTest;
import com.crm.genericutility.test.FileUtilityTest;
import com.crm.genericutility.test.JavaUtilityTest;
import com.crm.genericutility.test.WebDriverUtility;
import com.crm.objectrepository.test.HomePage;
import com.crm.objectrepository.test.LoginPage;
import com.crm.objectrepository.test.Quote_Page;
@Listeners(com.crm.listenerutility.test.ListenerImp.class)
public class CreateQuote {
	public static void main(String[] args) throws IOException {
		DatabaseUtilityTest dlib = new DatabaseUtilityTest();
		ExcelUtilityTest elib = new ExcelUtilityTest();
		JavaUtilityTest jlib = new JavaUtilityTest();
		FileUtilityTest flib = new FileUtilityTest();
		WebDriverUtility wlib = new WebDriverUtility();
		
		String BROWSER = flib.fetchDataFromPropertyFile("browser");
		String URL=flib.fetchDataFromPropertyFile("url");
		String USERNAME = flib.fetchDataFromPropertyFile("username");
		String PASSWORD = flib.fetchDataFromPropertyFile("password");
//		int randomNo = jlib.getRandomNo();
		
		WebDriver driver= null;
		if(BROWSER.equals("chrome")) {
			driver= new ChromeDriver();
		}
		else if (BROWSER.equals("firefox")) {
			driver= new FirefoxDriver();
		}
		else if (BROWSER.equals("edge")) {
			driver= new EdgeDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		// login
		wlib.waitForPageLoad(driver);
		LoginPage lp= new LoginPage(driver);
		lp.loginToAppWithUrl(URL, USERNAME, PASSWORD);
		
		// navigate to home
		HomePage hp = new HomePage(driver);
		hp.getQuoteLookup().click();
		Quote_Page qp = new Quote_Page(driver);
		String title = qp.getQuoteLookup().getText();
		System.out.println(title);
		
		
	}




}
