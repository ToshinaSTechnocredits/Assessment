package com.assessment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.assessment.base.PreDefinedActions;
import com.assessment.locatorValues.NDTVHomePageXpath;

public class NDTVHomePage extends PreDefinedActions {

	WebDriver driver;

	public NDTVHomePage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 120);
		PageFactory.initElements(factory, this);
	}

	@FindBy(xpath = NDTVHomePageXpath.link_NoThanks_DynamicPopUp_NDTVHomePage)
	private WebElement link_NoThanks_DynamicPopUp_NDTVHomePage;

	@FindBy(xpath = NDTVHomePageXpath.link_expandMenu_NDTVHomePage)
	private WebElement link_expandMenu_NDTVHomePage;

	@FindBy(xpath = NDTVHomePageXpath.link_Weather_NDTVHomePage)
	private WebElement link_Weather_NDTVHomePage;

	//Functions to be performed on NDTV Home Page
	public void moveToWeather_operation_NDTVHomePage() {
		try {
			click(link_NoThanks_DynamicPopUp_NDTVHomePage);
		} catch (Exception e) {
			System.out.println("Pop-out not present");
		}
		click(link_expandMenu_NDTVHomePage);
		click(link_Weather_NDTVHomePage);
	}

}
