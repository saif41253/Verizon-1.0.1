package com.crm.objectrepository.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNew_PurchaseOrderPage {
	WebDriver driver ;
	public CreateNew_PurchaseOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	@FindBy(name = "subject")
	private WebElement subTxtFild;
	public WebElement getSubTxtFild() {
		return subTxtFild;
	}
	@FindBy(xpath = "//img[@alt='Select']")
	public WebElement vendorIcon;
	public WebElement getVendorIcon() {
		return vendorIcon;
	}
	@FindBy(name = "bill_street")
	private WebElement billingAdd;
	@FindBy(xpath = "//input[@onclick='return copyAddressRight(EditView)']")
	private WebElement billingRadio;
	@FindBy(xpath = "//img[@title='Products']")
	private WebElement proIcon;
	@FindBy(name = "qty1")
	private WebElement qtyFld;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	public WebElement getBillingAdd() {
		return billingAdd;
	}

	public WebElement getBillingRadio() {
		return billingRadio;
	}

	public WebElement getProIcon() {
		return proIcon;
	}

	public WebElement getQtyFld() {
		return qtyFld;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
}
