package com.crm.objectrepository.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Organizations")
	private WebElement orgLink;
	@FindBy(linkText = "Products")
	private WebElement prodLink;
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	@FindBy(linkText = "Opportunities")
	private WebElement opportLink;
	@FindBy(linkText = "Documents")
	private WebElement docLink;
	@FindBy(linkText = "More")
	private WebElement moreLink;
	@FindBy(linkText = "Campaigns")
	private WebElement campLink;
	@FindBy(linkText = "Invoice")
	private WebElement invoiceLink;
	@FindBy(linkText = "Quotes")
	private WebElement quoteLink;
	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement adminButton;
	@FindBy(linkText = "Sign Out")
	private WebElement signoutButton;
	@FindBy(linkText = "Purchase Order")
	private WebElement purchaseLink;
	@FindBy(linkText = "Sales Order")
	private WebElement salesLink;


	public WebElement getSalesLink() {
		return salesLink;
	}
	public WebElement getPurchaseLink() {
		return purchaseLink;
	}
	public WebElement getOrgLink() {
		return orgLink;
	}
	public WebElement getProdLink() {
		return prodLink;
	}
	public WebElement getContactLink() {
		return contactLink;
	}
	public WebElement getOpportLink() {
		return opportLink;
	}
	public WebElement getDocLink() {
		return docLink;
	}
	public WebElement getMoreLink() {
		return moreLink;
	}
	public WebElement getCampLink() {
		return campLink;
	}
	public WebElement getSignoutButton() {
		return signoutButton;
	}
	public WebElement getInvoiceLink() {
		return invoiceLink;
	}
	public WebElement getAdminButton() {
		return adminButton;
	}
	public WebElement getQuoteLookup() {
		return quoteLink;
	}
	public void navigtetoQuote() {
		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();
		quoteLink.click();
		
	}
	
	public void navigtetoPurchaseOrder() {
		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();
		purchaseLink.click();
	}
	public void navigtetoInvoice() {
		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();
		invoiceLink.click();
	}
	public void navigtetoContact() {
		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();
		contactLink.click();
	}
	public void navigtetoSalesOrder() {
		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();
		salesLink.click();
	}

	public void logout() {
			Actions act = new Actions(driver);
			act.moveToElement(adminButton).perform();
			signoutButton.click();
	}
	

	
}
