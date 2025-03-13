package com.crm.verizon.createInvoiceTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.genericutility.test.BaseClassTest;
import com.crm.objectrepository.test.CreateNew_InvoicePage;
import com.crm.objectrepository.test.HomePage;
import com.crm.objectrepository.test.Invoice_Page;
@Listeners(com.crm.listenerutility.test.ListenerImp.class)
public class CreateInvoiceTest extends BaseClassTest {
	@Test
	public void createInvoice() throws IOException, InterruptedException {
		
		wlib.getMaximizeWindow(driver);
		wlib.waitForPageLoad(driver);
		String prodName=elib.fetchDataFromExcelFile("TestData1", 7, 2);
		String custAdd=elib.fetchDataFromExcelFile("TestData1", 1, 3);
		String orgName=elib.fetchDataFromExcelFile("TestData1", 4, 2);
		
		HomePage homepage= new HomePage(driver);
		homepage.navigtetoInvoice();
		
		Invoice_Page ip = new Invoice_Page(driver);
		ip.getInvoiceLink().click();
		
		CreateNew_InvoicePage cnip= new CreateNew_InvoicePage(driver);
		cnip.getSubTxtFld().sendKeys(prodName);
		cnip.getOrgLookup().click();
		wlib.switchtoWindowBasedOnURL(driver, "module=Accounts&action=");
		driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[contains(text(),'"+orgName+"')]")).click();
		wlib.switchtoAlertAccept(driver);
		wlib.switchtoWindowBasedOnURL(driver, "Invoice&action=EditView&return");
		
		cnip.getBillingAdd().sendKeys(custAdd);
		Thread.sleep(2000);
		cnip.getCopyAddRadio().click();
		cnip.getProIcon().click();
		wlib.switchtoWindowBasedOnURL(driver, "module=Products&action=Popup");
		driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(prodName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[contains(text(),'"+prodName+"')]")).click();
		wlib.switchtoWindowBasedOnURL(driver, "Invoice&action=EditView&return");
		cnip.getQtyFld().sendKeys("2");
		cnip.getSaveButton().click();
		
	}
	
	
	
}
