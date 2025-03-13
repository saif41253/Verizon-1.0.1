package com.crm.verizon.createPurchaseOrderTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.genericutility.test.BaseClassTest;
import com.crm.genericutility.test.ExcelUtilityTest;
import com.crm.objectrepository.test.CreateNew_PurchaseOrderPage;
import com.crm.objectrepository.test.HomePage;
import com.crm.objectrepository.test.PurchaseOrderPage;
@Listeners(com.crm.listenerutility.test.ListenerImp.class)
public class CreatePurchaseOrderTest extends BaseClassTest{
	ExcelUtilityTest elib = new ExcelUtilityTest();
	
	@Test
	public void createPurchaseOrder_Test() throws IOException, Exception {
		wlib.waitForPageLoad(driver);
		wlib.getMaximizeWindow(driver);
		String subTxt = elib.fetchDataFromExcelFile("TestData1", 1, 2);
		String add = elib.fetchDataFromExcelFile("TestData1", 1, 3);
		String vendor = elib.fetchDataFromExcelFile("TestData1", 4, 3);
		String prodName = elib.fetchDataFromExcelFile("TestData1", 7, 2);
		String prodQty = elib.fetchDataFromExcelFile("TestData1", 7, 3);
		
		HomePage homepage= new HomePage(driver);
		homepage.navigtetoPurchaseOrder();
		PurchaseOrderPage po= new PurchaseOrderPage(driver);
		po.getPoLink().click();
//		System.out.println("execute1");
//		System.out.println("Driver:"+driver);
		CreateNew_PurchaseOrderPage cnpo= new CreateNew_PurchaseOrderPage(driver);
		cnpo.getSubTxtFild().sendKeys(subTxt);
		cnpo.vendorIcon.click();
		wlib.switchtoWindowBasedOnURL(driver, "module=Vendors&action=Popup&ht");
		driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(vendor);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[contains(text(),'"+vendor+"')]")).click();
		wlib.switchtoWindowBasedOnURL(driver, "PurchaseOrder&action=EditView&return_ac");
		cnpo.getBillingAdd().sendKeys(add);
		cnpo.getBillingRadio().click();
		System.out.println("12");
		cnpo.getProIcon().click();
		wlib.switchtoWindowBasedOnURL(driver, "dex.php?module=Products");
		driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(prodName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[contains(text(),'"+prodName+"')]")).click();
		wlib.switchtoWindowBasedOnURL(driver, "PurchaseOrder&action=EditView&return_ac");
		cnpo.getQtyFld().sendKeys(prodQty);
		cnpo.getSaveBtn().click();
	}

}
