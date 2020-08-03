package com.assessment.testScripts;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.assessment.weatherAPI.WeatherAPI;

public class FinalTestScript {
	WebDriver driver;
	WeatherScript weatherScript;
	WeatherAPI weatherAPIdata;

	/*
	 * Variance logic = ((Sum(Square(Value)))/Number of Values)-Square(Sum(Value)/Number of Values);
	 * 
	 * Values = {a,b,c};
	 * 
	 * Number of values = 3;
	 * 
	 * Variance = (((a*a)+(b*b)+(c*c))/3)-(((a+b+c)/3)*((a+b+c)/3));
	 */

	private void varianceLogic(HashMap<String, Double> weatherApp, HashMap<String, Double> weatherAPI) {
		DecimalFormat df = new DecimalFormat("##. 00");
		Set<String> parameters = weatherApp.keySet();
		for (String parameter : parameters) {
			double value1 = weatherApp.get(parameter);
			double value2 = weatherAPI.get(parameter);
			double mean = (value1 + value2) / 2;
			double variance = ((((value1) * (value1)) + ((value2) * (value2))) / 2) - (mean * mean);
			System.out.println("Variance for " + parameter + " is : " + df.format(variance));
		}
	}

	// Comparing values for every parameter from Web Application and API
	// Response
	private void comparator(HashMap<String, Double> weatherApp, HashMap<String, Double> weatherAPI) {
		SoftAssert softAssert = new SoftAssert();
		Set<String> parameters = weatherApp.keySet();
		for (String parameter : parameters) {
			softAssert.assertEquals(weatherApp.get(parameter), weatherAPI.get(parameter),
					parameter + " is not the same");
		}
		softAssert.assertAll();
	}

	/*
	 * Final operation of the whole assessment
	 * TestCase would pass if both values are same else will fail displaying relevant message
	 */
	@Test
	public void finalOperation() {
		weatherScript = new WeatherScript();
		weatherAPIdata = new WeatherAPI();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the city : ");
		String city = sc.next();
		HashMap<String, Double> weatherApp = weatherScript.fetchWeather(city);
		HashMap<String, Double> weatherAPI = weatherAPIdata.getAPIData(city);
		varianceLogic(weatherApp, weatherAPI);
		comparator(weatherApp, weatherAPI);
		sc.close();
	}

}
