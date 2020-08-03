package com.assessment.testScripts;

import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import com.assessment.pages.WeatherPage;

public class WeatherScript extends TestBase {

	WebDriver driver;

	// Performing the whole operation on Web Application
	public HashMap<String, Double> fetchWeather(String city) {
		this.driver = startSession();
		WeatherPage weatherPage = new WeatherPage(driver);
		weatherPage.moveToWeather_operation_NDTVHomePage();
		HashMap<String, Double> temperatureFromWebApplication = weatherPage.getWeatherDetails_WeatherPage(city);
		closeSession();
		return temperatureFromWebApplication;
	}
}
