package com.crm.objectrepository.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Quote_Page {
	WebDriver driver;
	public Quote_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	@FindBy(xpath = "//img[@alt='Create Quote...']")
	private WebElement quoteLookup;
	
	public WebElement getQuoteLookup() {
		return quoteLookup;
	}
	public WebElement getQuoteLogo() {
		return quoteLogo;
	}
	public WebElement getQuotesLogo() {
		return quotesLogo;
	}
	@FindBy(className = "hdrLink")
	private WebElement quoteLogo;
	@FindBy(xpath = "(//a[text()='Quotes'])[3]")
	private WebElement quotesLogo;
	
	public String getPageUrl(WebDriver driver) {
		String URL = driver.getCurrentUrl();
		return URL;
		
	}

}