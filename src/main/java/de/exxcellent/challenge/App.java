package de.exxcellent.challenge;

import de.exxcellent.file.FootballData;
import de.exxcellent.file.WeatherData;

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
		
		//Get the contents from csv file and parse it class object form
		ArrayList<WeatherData> weatherDataContents = wd
				.parseContentfromCSV(wd.getFileName());
		//Get tempr spread
		ArrayList<Integer> temprSpread = wd
				.findDiffrOfCols(weatherDataContents);
		//Get index of day with smallest tempr spread
		int temprIndex = wd.findArgMinOfColumn(temprSpread);

		
		FootballData fd = new FootballData();
		
		//Get the contents from csv file and parse it class object form
		ArrayList<FootballData> footballDataContents = fd
				.parseContentfromCSV(fd.getFileName());
		//Get difference in goals
		ArrayList<Integer> smallestDist = fd
				.findDiffrOfCols(footballDataContents);
		//Get index of the team with smallest number of goal difference
		int smallestDistIndex = fd.findArgMinOfColumn(smallestDist);
		

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
