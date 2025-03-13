package com.crm.objectrepository.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Invoice_Page {
	WebDriver driver;
	public Invoice_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	@FindBy(xpath = "//img[@alt='Create Invoice...']")
	private WebElement invoiceLink;
	public WebElement getInvoiceLink() {
		return invoiceLink;
	}

}
