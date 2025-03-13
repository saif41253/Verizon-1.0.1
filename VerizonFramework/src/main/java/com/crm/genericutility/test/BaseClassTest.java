package com.crm.genericutility.test;

import java.io.IOException;
import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.crm.objectrepository.test.HomePage;
import com.crm.objectrepository.test.LoginPage;

public class BaseClassTest {
	public DatabaseUtilityTest dlib = new DatabaseUtilityTest();
	public ExcelUtilityTest elib = new ExcelUtilityTest();
	public FileUtilityTest flib = new FileUtilityTest();
	public JavaUtilityTest jlib = new JavaUtilityTest();
	public WebDriverUtility wlib = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	
	@BeforeSuite(groups = {"smoke","integration","system"})
	//@BeforeSuite(groups = "true")
	public void configBS() {
		System.out.println("Execute configBS===connect to dB, Report config===");
		dlib.getConnection();
	}
//	@Parameters("BROWSER")
	@BeforeClass(groups = {"smoke","integration","system"})
	public void configBC(/*@Optional("chrome")String browser*/) throws IOException {
		System.out.println("Execute configBC===Laucnh Browser===");
		String BROWSER =flib.fetchDataFromPropertyFile("browser");
		
//		String BROWSER =browser;
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
		wlib.waitForPageLoad(driver);
		
		sdriver=driver;
	}
	@BeforeMethod(groups = {"smoke","integration","system"})
	public void configBM() throws Throwable {
		System.out.println("Execute configBM==Login to apps==");
		
		String URL = flib.fetchDataFromPropertyFile("url");
		String USERNAME = flib.fetchDataFromPropertyFile("username");
		String PASSWORD = flib.fetchDataFromPropertyFile("password");
//		String URL = System.getProperty("url");
//		String USERNAME = System.getProperty("username");
//		String PASSWORD = System.getProperty("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToAppWithUrl(URL, USERNAME, PASSWORD);
		
	}
	
	@AfterMethod(groups = {"smoke","integration","system"})
	public void configAM() {
		System.out.println("Execute configAM==logout apps==");
		HomePage hp = new HomePage(driver);
		hp.logout();
			}
	@AfterClass(groups = {"smoke","integration","system"})
	public void configAC() throws Throwable {
		System.out.println("Execute configAC===close Browser===");
		driver.quit();
		
	}
	@AfterSuite(groups = {"smoke","integration","system"})
	public void configAS() throws SQLException {
		System.out.println("Execute configAS====close dB, Report backup====");
		dlib.closeConnection();
//		report.flush();
	}


}
