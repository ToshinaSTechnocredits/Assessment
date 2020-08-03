package com.assessment.locatorValues;

public class WeatherPageXpath {
	public static final String input_PinYourCity_WeatherPage = "//input[@id='searchBox']";
	public static final String list_CitiesInDropDown_WeatherPage = "//div[@id='messages']/div/label/input";
	public static final String list_CheckboxForCitiesInDropdown_WeatherPage = "//div[@id='messages']//input[@type='checkbox']";
	public static final String list_CityPinsOnTheMap_WeatherPage = "//div[@id='map_canvas']/div[1]/div[4]/div/div";
	public static final String static_WindInContainer_WeatherPage = "//div[@id='map_canvas']/div[1]/div[6]/div/div[1]/div/div/span[2]/b";
	public static final String static_HumidityInContainer_WeatherPage = "//div[@id='map_canvas']/div[1]/div[6]/div/div[1]/div/div/span[3]/b";
	public static final String static_TempratureInCelciusInContainer_WeatherPage = "//div[@id='map_canvas']/div[1]/div[6]/div/div[1]/div/div/span[4]/b";
}
