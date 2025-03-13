package com.crm.verizon.createSalesOrderTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.genericutility.test.BaseClassTest;
import com.crm.objectrepository.test.CreateNew_SalesOrderPage;
import com.crm.objectrepository.test.HomePage;
import com.crm.objectrepository.test.OrganizationPopupPage;
import com.crm.objectrepository.test.ProductPopupPage;
import com.crm.objectrepository.test.SalesOrder_Page;
@Listeners(com.crm.listenerutility.test.ListenerImp.class)
public class CreateSalesOrderTest extends BaseClassTest{
	@Test
	public void createSalesOrder() throws IOException {
		wlib.getMaximizeWindow(driver);
		wlib.waitForPageLoad(driver);
		int random = jlib.getRandomNo();
		
		String prodName=elib.fetchDataFromExcelFile("TestData1", 7, 2);
		String custAdd=elib.fetchDataFromExcelFile("TestData1", 1, 3);
		String sub=elib.fetchDataFromExcelFile("TestData1", 1, 2)+random;
		String orgName = elib.fetchDataFromExcelFile("TestData1", 4, 2);
		
		HomePage homepage= new HomePage(driver);
		homepage.navigtetoSalesOrder();
		SalesOrder_Page so= new SalesOrder_Page(driver);
		so.getSoLink().click();
		CreateNew_SalesOrderPage snsop= new CreateNew_SalesOrderPage(driver);
		snsop.getSubTxtFld().sendKeys(sub);
		
		snsop.getOrgLookup().click();
		wlib.switchtoWindowBasedOnURL(driver, "module=Accounts&action=Popup");
		OrganizationPopupPage opp = new OrganizationPopupPage(driver);
		opp.getSearchField().sendKeys(orgName);
		opp.getSearchButton().click();
		driver.findElement(By.xpath("//a[contains(text(),'"+orgName+"')]")).click();
		wlib.switchtoAlertAccept(driver);
		wlib.switchtoWindowBasedOnURL(driver, ".php?module=SalesOrder&action=EditView&return");
		snsop.getBillingAdd().sendKeys(custAdd);
		snsop.getCopyAdd().click();
		snsop.getProIcon().click();
		wlib.switchtoWindowBasedOnURL(driver, "module=Products&action");
		ProductPopupPage ppp= new ProductPopupPage(driver);
		ppp.getSearchField().sendKeys(prodName);
		ppp.getSearchButton().click();
		driver.findElement(By.xpath("//a[contains(text(),'"+prodName+"')]")).click();
		wlib.switchtoWindowBasedOnURL(driver, "p?module=SalesOrder&action=EditView&return");
		snsop.getQtyFld().sendKeys("20");
		System.out.println("Hii");
		wlib.clickOnElement(driver, snsop.getSaveButton());
		System.out.println("Hi");
		//snsop.getSaveButton().click();
	
	}
}
