package de.exxcellent.challenge;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Example JUnit4 test case.
 * 
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public class AppTest {

	private String successLabel = "not successful";
	WeatherData wd = new WeatherData();
	String weatherDataFileName = "./src/main/resources/de/exxcellent/challenge/weather.csv";

	@Before
	public void setUp() throws Exception {
		successLabel = "successful";

	}

	@Test
	public void aPointlessTest() {
		Assert.assertEquals("Expectations met", "successful", successLabel);
	}

	/**
	 * Checks if all the contents are read from csv file
	 */
	@Test
	public void checkAllContentsRead() {

		ArrayList<WeatherData> weatherDataContents = wd
				.parseContentfromCSV(weatherDataFileName);
		Assert.assertEquals(weatherDataContents.size(), 30);
	}

	/**
	 * Validates the minimum difference calculated by the correct answer
	 */
	@Test
	public void checkminDiff() {
		ArrayList<WeatherData> weatherDataContents = wd
				.parseContentfromCSV(weatherDataFileName);
		ArrayList<Integer> temprSpread = wd
				.findDiffrOfCols(weatherDataContents);
		int temprIndex = wd.findMinOfColumn(temprSpread);
		Assert.assertEquals((weatherDataContents.get(temprIndex)).getDay(),
				"14");

	}
}