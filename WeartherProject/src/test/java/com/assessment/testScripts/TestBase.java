package com.assessment.testScripts;

import org.openqa.selenium.WebDriver;

import com.assessment.base.PreDefinedActions;

public class TestBase {
	private WebDriver driver;

	public WebDriver startSession() {
		driver = PreDefinedActions.start();
		return driver;
	}

	public WebDriver start(String url) {
		driver = PreDefinedActions.start(url);
		return driver;
	}

	void closeSession() {
		PreDefinedActions.shutTheBrowser();
		System.out.println("\n\n\n");
	}

}
