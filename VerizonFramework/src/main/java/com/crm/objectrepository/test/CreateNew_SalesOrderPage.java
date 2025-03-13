package com.crm.objectrepository.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNew_SalesOrderPage {
	WebDriver driver;
	public CreateNew_SalesOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	@FindBy(name = "subject")
	private WebElement subTxtFld;
	@FindBy(name = "bill_street")
	private WebElement billingAdd;
	@FindBy(xpath = "//input[@onclick='return copyAddressRight(EditView)']")
	private WebElement copyAdd;
	public WebElement getSubTxtFld() {
		return subTxtFld;
	}
	public WebElement getBillingAdd() {
		return billingAdd;
	}
	public WebElement getCopyAdd() {
		return copyAdd;
	}
	@FindBy(name = "button")
	private WebElement saveButton;
	public WebElement getSaveButton() {
		return saveButton;
	}
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	@FindBy(xpath = "//input[@name=\"account_id\"]/following-sibling::img[@alt='Select']")
	private WebElement orgLookup;
	public WebElement getOrgLookup() {
		return orgLookup;
	}
	@FindBy(id = "searchIcon1")
	private WebElement proIcon;
	@FindBy(name = "qty1")
	private WebElement qtyFld;
	public WebElement getProIcon() {
		return proIcon;
	}
	public WebElement getQtyFld() {
		return qtyFld;
	}

}
