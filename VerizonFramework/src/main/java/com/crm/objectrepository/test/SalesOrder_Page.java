package com.crm.objectrepository.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesOrder_Page {
	WebDriver driver;
	public SalesOrder_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver= driver;
	}
	@FindBy(xpath = "//img[@alt='Create Sales Order...']")
	private WebElement soLink;
	public WebElement getSoLink() {
		return soLink;
	}

}
