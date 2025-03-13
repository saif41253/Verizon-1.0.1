package com.crm.objectrepository.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNew_QuotePage {
	WebDriver driver;
	public CreateNew_QuotePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "(//input[@onclick='toggleAssignType(this.value)'])[2]")
	private WebElement assignRadio;
	@FindBy(xpath = "(//img[@alt='Select'])[3]")
	private WebElement orgLookup; 
	@FindBy(name = "bill_street")
	private WebElement billingAdd; 
	@FindBy(xpath = "//input[@onclick='return copyAddressRight(EditView)']")
	private WebElement shippingRadio;
	@FindBy(id = "searchIcon1")
	private WebElement proSrcIcon;
	//input[@title="Save [Alt+S]"]
	@FindBy(name = "button")
	private WebElement saveButton;
	@FindBy(name = "subject")
	private WebElement subTxtFld;
	@FindBy(xpath = "//input[@id='qty1']")
	private WebElement qtyTxtFld;
	public WebElement getContactLookup() {
		return contactLookup;
	}
	@FindBy(name = "assigned_group_id")
	private WebElement groupText;
	@FindBy(xpath = "(//img[@title='Select'])[2]")
	private WebElement contactLookup;
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement pageHeader;
	
	
	public WebElement getPageHeader() {
		return pageHeader;
	}

	public WebElement getQtyTxtFld() {
		return qtyTxtFld;
	}
	
	public WebElement getGroupText() {
		return groupText;
	}

	public WebElement getAssignRadio() {
		return assignRadio;
	}
	
	public WebElement getSubTxtFld() {
		return subTxtFld;
	}
	public WebElement getOrgLookup() {
		return orgLookup;
	}
	public WebElement getBillingAdd() {
		return billingAdd;
	}
	public WebElement getShippingRadio() {
		return shippingRadio;
	}
	public WebElement getProSrcIcon() {
		return proSrcIcon;
	}
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public void createQuote() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Actions act = new Actions(driver);
		
	}


}
