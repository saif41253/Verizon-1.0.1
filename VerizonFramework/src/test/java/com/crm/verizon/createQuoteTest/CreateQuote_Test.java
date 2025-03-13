package com.crm.verizon.createQuoteTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.genericutility.test.BaseClassTest;
import com.crm.objectrepository.test.CreateNewOrganizationPage;
import com.crm.objectrepository.test.CreateNew_QuotePage;
import com.crm.objectrepository.test.HomePage;
import com.crm.objectrepository.test.OrganizationPage;
import com.crm.objectrepository.test.OrganizationPopupPage;
import com.crm.objectrepository.test.ProductPopupPage;
import com.crm.objectrepository.test.QuoteInfoPage;
import com.crm.objectrepository.test.Quote_Page;
@Listeners(com.crm.listenerutility.test.ListenerImp.class)
public class CreateQuote_Test extends BaseClassTest{
	String Expected="dex.php?module=Quotes&action=index";
	@Test(groups = "smoke")
	public void quotelistPageDisplayed() {
		wlib.waitForPageLoad(driver);
		HomePage homepage= new HomePage(driver);
		homepage.getQuoteLookup().click();
		Quote_Page qp = new Quote_Page(driver);
		String URL = qp.getPageUrl(driver);
		System.out.println(URL);
		boolean status = URL.contains("module=Quotes");
		Assert.assertTrue(status);
		Reporter.log("Executed and passed");
//		if(URL.contains(Expected)) {
//			System.out.println("Passed");
//		}
//		else {
//			System.out.println(URL+" Failed");
//		}
	
	}
	@Test(groups = "smoke")
	public void newQuotePageDisplayed() {
		wlib.waitForPageLoad(driver);
		HomePage homepage= new HomePage(driver);
		homepage.getQuoteLookup().click();
		Quote_Page qp = new Quote_Page(driver);
		qp.getQuoteLookup().click();
		CreateNew_QuotePage cncp= new CreateNew_QuotePage(driver);
    	String actPageHeader = cncp.getPageHeader().getText();
		Assert.assertEquals(actPageHeader,"Creating New Quote");
		
		
	}
	@Test(groups = "smoke")
	public void newQuoteWithOrg() throws IOException, InterruptedException {
		wlib.getMaximizeWindow(driver);
		wlib.waitForPageLoad(driver);
		int randomCount = jlib.getRandomNo();
		String sub = elib.fetchDataFromExcelFile("TestData1", 1, 2)+randomCount;
		String orgName = elib.fetchDataFromExcelFile("TestData1", 4, 2)+randomCount;
		String add = elib.fetchDataFromExcelFile("TestData1", 1, 3);
		String prodName = elib.fetchDataFromExcelFile("TestData1", 7, 2);
		
		HomePage homepage= new HomePage(driver);
		homepage.getOrgLink().click();
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrgLink().click();
		CreateNewOrganizationPage cnop= new CreateNewOrganizationPage(driver);
		cnop.getOrgTxtFld().sendKeys(orgName);
		cnop.getSaveBtn().click();
		
		homepage.navigtetoQuote();
		Quote_Page qp = new Quote_Page(driver);
		qp.getQuoteLookup().click();
		CreateNew_QuotePage cnq=new CreateNew_QuotePage(driver);
		
		cnq.getSubTxtFld().sendKeys(sub);
		cnq.getOrgLookup().click();
		wlib.switchtoWindowBasedOnURL(driver, "module=Accounts&action");
		OrganizationPopupPage opp = new OrganizationPopupPage(driver);
		opp.getSearchField().sendKeys(orgName);
		opp.getSearchButton().click();
		driver.findElement(By.xpath("//a[contains(text(),'"+orgName+"')]")).click();
		wlib.switchtoAlertAccept(driver);
		wlib.switchtoWindowBasedOnURL(driver, "module=Quotes&action=EditView&return");
		cnq.getBillingAdd().sendKeys(add);
		cnq.getShippingRadio().click();
		cnq.getProSrcIcon().click();
		wlib.switchtoWindowBasedOnURL(driver, "?module=Products&actio");
		String prodQty = elib.fetchDataFromExcelFile("TestData1", 7, 3);
		ProductPopupPage ppp= new ProductPopupPage(driver);
		ppp.getSearchField().sendKeys(prodName);
		ppp.getSearchButton().click();
		driver.findElement(By.xpath("//a[contains(text(),'"+prodName+"')]")).click();
		wlib.switchtoWindowBasedOnURL(driver, "module=Quotes&action=EditView&return");
		cnq.getQtyTxtFld().sendKeys(prodQty);
		System.out.println(prodQty);
		cnq.getSaveButton().click();
		QuoteInfoPage qip = new QuoteInfoPage(driver);
		String actHeader = qip.getQuoteInfoHeader().getText();
		boolean subject = actHeader.contains(sub);
		Assert.assertTrue(subject);
		Reporter.log("Subject name displayed");
		
		
	}
	@Test(groups = "smoke")
	public void newQuoteWithRadioBtn() throws InterruptedException {
		wlib.getMaximizeWindow(driver);
		wlib.waitForPageLoad(driver);
		HomePage homepage= new HomePage(driver);
		homepage.getQuoteLookup().click();
		Quote_Page qp = new Quote_Page(driver);
		qp.getQuoteLookup().click();
		CreateNew_QuotePage cnq=new CreateNew_QuotePage(driver);
		cnq.getAssignRadio().click();
		Thread.sleep(2000);
		String radioText = cnq.getGroupText().getText();
		boolean actText = radioText.contains("Marketing Group");
		Assert.assertEquals(actText, true);
//		 boolean isEnabled = cnq.getGroupText().isEnabled();
//		 Assert.assertEquals(isEnabled, true);
		 Reporter.log("pass");
		
		
	}

}
