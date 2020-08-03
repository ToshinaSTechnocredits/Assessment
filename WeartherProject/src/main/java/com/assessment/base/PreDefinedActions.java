package com.assessment.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.assessment.constants.ConstantPath;

abstract public class PreDefinedActions {
	static public WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	// Initiating the browser with URL
	 public static WebDriver start() {
		start(ConstantPath.URL);
		return driver;
	}

	// Initiating the browser
	public static WebDriver start(String url) {
		System.setProperty("webdriver.chrome.driver", ConstantPath.CHROMEDRIVEREXE);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

	// Perform click operation
	protected void click(WebElement element) {
		element.click();
	}

	// Perform data input operation
	protected void enterText(WebElement element, String text) {
		element.sendKeys(text);
	}

	// Perform fetch data operation
	protected String getText(WebElement element) {
		return element.getText();
	}

	// Perform fetch value of attribute operation
	protected String getAttributeValue(WebElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}

	// Perform fetch value of attribute operation
	protected boolean elementIsSelected(WebElement element) {
		return element.isSelected();
	}

	// Close the browser
	public static void shutTheBrowser() {
		driver.close();
		driver.quit();
	}

}
