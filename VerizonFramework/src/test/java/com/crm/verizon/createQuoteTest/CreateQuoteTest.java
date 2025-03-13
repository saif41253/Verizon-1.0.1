package com.crm.verizon.createQuoteTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.crm.genericutility.test.BaseClassTest;
import com.crm.objectrepository.test.ContactPage;
import com.crm.objectrepository.test.CreateNewContactPage;
import com.crm.objectrepository.test.CreateNewOrganizationPage;
import com.crm.objectrepository.test.CreateNew_QuotePage;
import com.crm.objectrepository.test.HomePage;
import com.crm.objectrepository.test.OrganizationPage;
import com.crm.objectrepository.test.OrganizationPopupPage;
import com.crm.objectrepository.test.ProductPopupPage;
import com.crm.objectrepository.test.QuoteInfoPage;
import com.crm.objectrepository.test.Quote_Page;

import net.bytebuddy.asm.Advice.Argument;
@Listeners(com.crm.listenerutility.test.ListenerImp.class)
public class CreateQuoteTest extends BaseClassTest {
	@Test(groups = "system")
	public void createQuoteTest() throws IOException, InterruptedException {
		
    	int randomNo = jlib.getRandomNo();
    	wlib.getMaximizeWindow(driver);
    	
		HomePage homepage= new HomePage(driver);
		homepage.getQuoteLookup().click();	
		Quote_Page qp =new Quote_Page(driver);
		qp.getQuoteLookup().click();
		CreateNew_QuotePage cnq=new CreateNew_QuotePage(driver);
		String sub = elib.fetchDataFromExcelFile("TestData1", 1, 2)+randomNo;
		String add = elib.fetchDataFromExcelFile("TestData1", 1, 3);
		String orgName = elib.fetchDataFromExcelFile("TestData1", 4, 2);
		String prodName = elib.fetchDataFromExcelFile("TestData1", 7, 2);
		String prodQty = elib.fetchDataFromExcelFile("TestData1", 7, 3);
		
		cnq.getSubTxtFld().sendKeys(sub);
		cnq.getOrgLookup().click();
		wlib.switchtoWindowBasedOnURL(driver, "module=Accounts&action=Popup");
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
		ProductPopupPage ppp= new ProductPopupPage(driver);
		ppp.getSearchField().sendKeys(prodName);
		ppp.getSearchButton().click();
		driver.findElement(By.xpath("//a[contains(text(),'"+prodName+"')]")).click();
		wlib.switchtoWindowBasedOnURL(driver, "module=Quotes&action=EditView&return");
//		Actions act = new Actions(driver);
//		act.scrollToElement(cnq.getQtyTxtFld()).perform();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",cnq.getQtyTxtFld());
		cnq.getQtyTxtFld().sendKeys(prodQty);
		Thread.sleep(1000);
		cnq.getSaveButton().click();
		QuoteInfoPage qip = new QuoteInfoPage(driver);
		String actHeader = qip.getQuoteInfoHeader().getText();
		boolean subject = actHeader.contains(sub);
		Assert.assertTrue(subject);
		Reporter.log("Subject name displayed");
		
		
		
	}
	
	// organization to quote
	@Test(groups = "integration")
	public void createNewQuoteWithOrgTest() throws InterruptedException, IOException {
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
		Thread.sleep(2000);
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
		boolean subject =actHeader.contains(sub);
		Assert.assertTrue(subject);
		Reporter.log("Subject name displayed");
		
	}
	// contact to quote
	@Test(groups = "integration")
	public void createNewQuoteWithContactTest() throws Throwable {
		wlib.waitForPageLoad(driver);
		wlib.getMaximizeWindow(driver);
		int randomCount = jlib.getRandomNo();
		String sub = elib.fetchDataFromExcelFile("TestData1", 1, 2)+randomCount;
		String contName = elib.fetchDataFromExcelFile("TestData1", 13, 2)+randomCount;
		String add = elib.fetchDataFromExcelFile("TestData1", 1, 3);
		String prodName = elib.fetchDataFromExcelFile("TestData1", 7, 2);
		String orgName = elib.fetchDataFromExcelFile("TestData1", 4, 2);
		String prodQty = elib.fetchDataFromExcelFile("TestData1", 7, 3);
		
		HomePage homepage= new HomePage(driver);
		homepage.getContactLink().click();
		ContactPage cp = new ContactPage(driver);
		cp.getCreateContactLink().click();
		
		CreateNewContactPage cncp= new CreateNewContactPage(driver);
		cncp.getLastName().sendKeys(contName);
		cncp.getSaveBtn().click();
		
		homepage.navigtetoQuote();
		
		Quote_Page qp = new Quote_Page(driver);
		qp.getQuoteLookup().click();
		CreateNew_QuotePage cnq=new CreateNew_QuotePage(driver);
		cnq.getSubTxtFld().sendKeys(sub);
		cnq.getContactLookup().click();
		wlib.switchtoWindowBasedOnURL(driver, "?module=Contacts&action=");
		driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(contName);  
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[contains(text(),'"+contName+"')]")).click();
		wlib.switchtoAlertAccept(driver);
		wlib.switchtoWindowBasedOnURL(driver, "module=Quotes&action=EditView&return");
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
		boolean subject =actHeader.contains(sub);
		Assert.assertTrue(subject);
		Reporter.log("Subject name displayed");
		
	}

}
