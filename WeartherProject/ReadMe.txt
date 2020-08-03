Configuration details: 

** Maven project
** Jars/Dependendency used:
			Selenium (Server Standalone): 2.46.0
			TestNG : 6.14.3
			rest-assured : 4.3.1
			json-path : 4.3.1
			xml-path : 4.3.1
			json-schema-validator : 4.3.1
			jcommander : 1.78
			
** com.assessment.base : PreDefinedActions.java : It contains all the base functions of selenium that are required in the scripts

** com.assessment.contants : ConstantPath.java : Storing the paths of the resources

** com.assessment.locatorValues : NDTVHomePageXpath.java : Storing all the x-paths for NDTV Home Page
								  WeatherPageXpath.java	: Storing all the x-paths for weather Page

** com.assessment.pages : NDTVHomePage.java : Declaration and defining the overall operation on the NDTV home page
						  WeatherPage.java : Declaration and defining the overall operation on the NDTV home page

** com.assessment.weatherAPI : WeatherAPI.java : Performing HTTP Methods and fetching the required data

** com.assessment.weatherAPIStrings : WeatherAPIStrings.java : Storing the baseURL, Resource, keys and values of the API

** com.assessment.testScripts : TestBase.java : Initiating and closing the browser and inherited by NDTVHomePageTestScript.java
								NDTVHomePageTestScript.java : Executing NDTVHomePage.java inherited by WeatherPageTestScript.java 
								WeatherPageTestScript.java : Executing WeatherPage.java
								FinalTestScript.java : Contains methods VarianceLogic and Comparator, and fetching the data from web application and API, comparing them and giving the output

** resources : Containing the ChromeDriver.exe

** To use this project, install Maven plugin in the ide and set your system environment for maven (Path and Environment variables).
   Import the project at your workspace.
   Run file "FinalTestScript.java" in "com.assessment.testScripts" as TestNG Test.
   Testcase should pass if data from Web application and API is same else it should fail.