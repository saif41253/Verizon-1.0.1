package com.crm.objectrepository.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuoteInfoPage {
	WebDriver driver;
	public QuoteInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver= driver;
	}
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement quoteInfoHeader;
	public WebElement getQuoteInfoHeader() {
		return quoteInfoHeader;
	}
}
