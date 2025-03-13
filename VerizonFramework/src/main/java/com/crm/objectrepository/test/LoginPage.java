package com.crm.objectrepository.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "user_name")
	private WebElement usernameText;

	@FindBy(name = "user_password")
	private WebElement passwordText;

	@FindBy(id = "submitButton")
	private WebElement loginButton;

	public WebElement getUsernameEdt() {
		return usernameText;
	}

	public WebElement getPasswordEdt() {
		return passwordText;
	}

	public WebElement getLoginBtn() {
		return loginButton;
	}

	// provide action
	public void loginToApp(String username, String password) {
		usernameText.sendKeys(username);
		passwordText.sendKeys(password);
		loginButton.click();
	}

	public void loginToAppWithUrl(String url, String username, String password) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		usernameText.sendKeys(username);
		passwordText.sendKeys(password);
		loginButton.click();
	}


}
