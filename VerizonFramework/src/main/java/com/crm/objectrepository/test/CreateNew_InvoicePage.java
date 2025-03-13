package com.crm.objectrepository.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNew_InvoicePage {
	WebDriver driver;
	public CreateNew_InvoicePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	@FindBy(name = "subject")
	private WebElement subTxtFld;
	public WebElement getSubTxtFld() {
		return subTxtFld;
	}
	@FindBy(xpath = "(//img[@alt='Select'])[3]")
	private WebElement orgLookup;
	public WebElement getOrgLookup() {
		return orgLookup;
	}
	@FindBy(name = "bill_street")
	private WebElement billingAdd;
	public WebElement getBillingAdd() {
		return billingAdd;
	}
	
	@FindBy(xpath = "//input[@onclick='return copyAddressRight(EditView)']")
	private WebElement copyAddRadio;
	@FindBy(id = "searchIcon1")
	private WebElement proIcon;
	public WebElement getCopyAddRadio() {
		return copyAddRadio;
	}
	public WebElement getProIcon() {
		return proIcon;
	}
	@FindBy(name = "qty1")
	private WebElement qtyFld;
	@FindBy(name = "button")
	private WebElement saveBtn;
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	public WebElement getQtyFld() {
		return qtyFld;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}

	
	

}
