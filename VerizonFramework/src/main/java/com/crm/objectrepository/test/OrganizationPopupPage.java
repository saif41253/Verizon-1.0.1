package com.crm.objectrepository.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPopupPage {
	WebDriver driver;
	public OrganizationPopupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	@FindBy(xpath = "//input[@id='search_txt']")
	private WebElement searchField;
	@FindBy(name = "search")
	private WebElement searchButton;
	
	public WebElement getSearchField() {
		return searchField;
	}
	public WebElement getSearchButton() {
		return searchButton;
	}
	
	

}
