
package com.crm.objectrepository.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	WebDriver driver;

	public OrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCreateOrgLink() {
		return createOrgLink;
	}
	public WebElement getSearchFieldLink() {
		return searchFieldLink;
	}
	public WebElement getOrgDD() {
		return orgDD;
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}

	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrgLink;
	@FindBy(name = "search_text")
	private WebElement searchFieldLink;
	@FindBy(id = "bas_searchfield")
	private WebElement orgDD;
	@FindBy(name = "submit")
	private WebElement searchBtn;
	
	
}
