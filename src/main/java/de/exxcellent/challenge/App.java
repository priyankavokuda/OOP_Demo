package de.exxcellent.challenge;

import de.exxcellent.challenge.WeatherData;
import de.exxcellent.challenge.FootballData;

import java.util.ArrayList;

/**
 * The entry class for your solution. This class is only aimed as starting point
 * and not intended as baseline for your software design. Read: create your own
 * classes and packages as appropriate.
 * 
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

	public static void main(String... args) {
		// Your preparation code …
		WeatherData wd = new WeatherData();
		String weatherDataFileName = "./src/main/resources/de/exxcellent/challenge/weather.csv";
		ArrayList<WeatherData> weatherDataContents = wd
				.parseContentfromCSV(weatherDataFileName);
		ArrayList<Integer> temprSpread = wd
				.findDiffrOfCols(weatherDataContents);
		int temprIndex = wd.findMinOfColumn(temprSpread);

		FootballData fd = new FootballData();
		String footballDataFileName = "./src/main/resources/de/exxcellent/challenge/football.csv";
		ArrayList<FootballData> footballDataContents = fd
				.parseContentfromCSV(footballDataFileName);
		ArrayList<Integer> smallestDist = fd
				.findDiffrOfCols(footballDataContents);
		int smallestDistIndex = fd.findMinOfColumn(smallestDist);
		

		String dayWithSmallestTempSpread = (weatherDataContents.get(temprIndex))
				.getDay(); // Your day analysis function call …
		String teamWithSmallesGoalSpread = (footballDataContents
				.get(smallestDistIndex)).getTeam(); // Your goal analysis
													// function call …

		System.out.printf("Day with smallest temperature spread : %s%n",
				dayWithSmallestTempSpread);
		System.out.printf("Team with smallest goal spread       : %s%n",
				teamWithSmallesGoalSpread);
	}
}
