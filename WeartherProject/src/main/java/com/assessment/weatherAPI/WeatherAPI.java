package com.assessment.weatherAPI;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import com.assessment.WeatherAPIStrings.WeatherAPIStrings;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class WeatherAPI {
	// Performing "GET" operation and parsing the JSON instance
	private JsonPath apiFunction(String city) {
		RestAssured.baseURI = WeatherAPIStrings.BASEURI;
		String response = given().queryParam(WeatherAPIStrings.KEY1, city)
				.queryParam(WeatherAPIStrings.KEY2, WeatherAPIStrings.KEYVALUE2)
				.when().get(WeatherAPIStrings.RESOURCE)
				.then().log().all().assertThat().statusCode(200)
				.extract().response().asString();
		JsonPath js = new JsonPath(response);
		return js;
	}

	// Fetching details from GET response, Parsing after storing them in HashMap
	public HashMap<String, Double> getAPIData(String city) {
		// wind speed (API) in KPH from MPS
		JsonPath js = apiFunction(city);
		double windSpeed = Double.parseDouble(js.getString("wind.speed"));
		// Humidity% (API)
		double humidity = Double.parseDouble(js.getString("main.humidity"));
		// Temperature in Kelvin(API)
		double temperatureInKelvin = Double.parseDouble(js.getString("main.temp"));
		// Store all data in a HashMap
		HashMap<String, Double> mapOfAPIValues = new HashMap<String, Double>();
		mapOfAPIValues.put("wind", windSpeed);
		mapOfAPIValues.put("humidity", humidity);
		mapOfAPIValues.put("temperature", temperatureInKelvin);
		return mapOfAPIValues;
	}

}
