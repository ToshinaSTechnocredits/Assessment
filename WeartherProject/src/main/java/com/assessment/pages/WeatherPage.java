package com.assessment.pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.assessment.locatorValues.WeatherPageXpath;

public class WeatherPage extends NDTVHomePage {
	public WeatherPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = WeatherPageXpath.input_PinYourCity_WeatherPage)
	private WebElement input_PinYourCity_WeatherPage;
	@FindAll(@FindBy(xpath = WeatherPageXpath.list_CitiesInDropDown_WeatherPage))
	private List<WebElement> list_CitiesInDropDown_WeatherPage;
	@FindAll(@FindBy(xpath = WeatherPageXpath.list_CheckboxForCitiesInDropdown_WeatherPage))
	private List<WebElement> list_CheckboxForCitiesInDropdown_WeatherPage;
	@FindAll(@FindBy(xpath = WeatherPageXpath.list_CityPinsOnTheMap_WeatherPage))
	private List<WebElement> list_CityPinsOnTheMap_WeatherPage;
	@FindBy(xpath = WeatherPageXpath.static_WindInContainer_WeatherPage)
	private WebElement static_WindInContainer_WeatherPage;
	@FindBy(xpath = WeatherPageXpath.static_HumidityInContainer_WeatherPage)
	private WebElement static_HumidityInContainer_WeatherPage;
	@FindBy(xpath = WeatherPageXpath.static_TempratureInCelciusInContainer_WeatherPage)
	private WebElement static_TempratureInCelciusInContainer_WeatherPage;
	private HashMap<String, Double> values_InTheCityContainer_WeatherPage = new HashMap<String, Double>();

	// Functions to be performed on Weather Page
	public HashMap<String, Double> getWeatherDetails_WeatherPage(String cityForWeatherPage) {
		enterText(input_PinYourCity_WeatherPage, cityForWeatherPage);
		// Checking the check-box for required city
		for (WebElement city : list_CitiesInDropDown_WeatherPage) {
			String attributeValue = getAttributeValue(city, "id");
			if (attributeValue.equalsIgnoreCase(cityForWeatherPage)) {
				if (elementIsSelected(city) == false) {
					click(city);
				}
			}
		}
		// Finding the pin for required city
		for (WebElement pin : list_CityPinsOnTheMap_WeatherPage) {
			String attributeValue = getAttributeValue(pin, "title");
			if (attributeValue.equalsIgnoreCase(cityForWeatherPage)) {
				click(pin);
				break;
			}
		}
		// Fetching the values from the Weather container of the city
		double value_Wind_WeatherPage = (double) Double
				.parseDouble(getText(static_WindInContainer_WeatherPage).split(":")[1].split("KPH")[0].trim());
		double value_Humidity_WeatherPage = (double) Integer
				.parseInt(getText(static_HumidityInContainer_WeatherPage).split(":")[1].split("%")[0].trim());
		int temperatuteInCelsius = Integer
				.parseInt(getText(static_TempratureInCelciusInContainer_WeatherPage).split(":")[1].trim());
		double value_TemperatureInKelvin_WeatherPage = (double) temperatuteInCelsius + 273.15;
		// Parsing the values after adding them in a single entity
		values_InTheCityContainer_WeatherPage.put("wind", value_Wind_WeatherPage);
		values_InTheCityContainer_WeatherPage.put("humidity", value_Humidity_WeatherPage);
		values_InTheCityContainer_WeatherPage.put("temperature", value_TemperatureInKelvin_WeatherPage);
		return values_InTheCityContainer_WeatherPage;
	}
}
