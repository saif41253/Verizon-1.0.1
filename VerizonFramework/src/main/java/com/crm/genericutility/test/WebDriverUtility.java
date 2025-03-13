package com.crm.genericutility.test;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	// implicitly wait
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	// explicitly wait
	public void waitForElementPresence(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// switch to window on url
	public void switchtoWindowBasedOnURL(WebDriver driver, String partialURL) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String wid = it.next();
			driver.switchTo().window(wid);
			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains(partialURL)) {
				break;
			}
		}
	}

	// switch to window on title
	public void switchtoWindowBasedOnTitle(WebDriver driver, String partialtitle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String wid = it.next();
			driver.switchTo().window(wid);
			String actTitle = driver.getTitle();
			if (actTitle.contains(partialtitle)) {
				break;
			}
		}
	}

	// switch to frame on index
	public void switchtoFrameIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	// switch to frame on name
	public void switchtoFrameIndex(WebDriver driver, String name) {
		driver.switchTo().frame(name);
	}

	// switch to frame on webelement
	public void switchtoFrameIndex(WebDriver driver, WebElement ele) {
		driver.switchTo().frame(ele);
	}

	// switch to alert and accept ok
	public void switchtoAlertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	// switch to alert and dismiss cancel
	public void switchtoAlertCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
		;
	}

	// switch to alert and capture text msg
	public void switchtoAlert(WebDriver driver) {
		driver.switchTo().alert().getText();
	}

	// select class method by text
	public void select(WebElement ele, String text) {
		Select select = new Select(ele);
		select.selectByVisibleText(text);
	}

	// select class method by index
	public void select(WebElement ele, int index) {
		Select select = new Select(ele);
		select.selectByIndex(index);
	}

	// actions class method
	public void mouseMoveOnElemet(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element);
	}

	// actions class method
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}

	// action class method
	public void clickOnElement(WebDriver driver, WebElement ele) {
		Actions act =new Actions(driver);
		act.click(ele).perform();
	}
	// max window
	public void getMaximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	// min window
	public void getMinimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

}
