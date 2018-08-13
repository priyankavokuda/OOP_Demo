/**
 * 
 */
package de.exxcellent.challenge;

import java.util.ArrayList;

import util.CSVDataReader;

/**
 * class which represents football data from csv file with header names as
 * attributes and performs class specific functions.
 * 
 * @author priyanka
 * 
 */
public class FootballData extends Data{
	String team;
	int games;
	int wins;
	int losses;
	int draws;
	int goals;
	int goalsAllowed;
	int points;

	public FootballData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FootballData(String team, int games, int wins, int losses,
			int draws, int goals, int goalsAllowed, int points) {
		super();
		this.team = team;
		this.games = games;
		this.wins = wins;
		this.losses = losses;
		this.draws = draws;
		this.goals = goals;
		this.goalsAllowed = goalsAllowed;
		this.points = points;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}

	public int getGoalsAllowed() {
		return goalsAllowed;
	}

	public void setGoalsAllowed(int goalsAllowed) {
		this.goalsAllowed = goalsAllowed;
	}
	
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}
	
	/**
	 * Reads CSV file given the name of file and returns the contents of file
	 * with each row stored as class objects and all rows stored in ArrayList
	 * 
	 * @param fileName
	 * @return data stored as class objects in ArrayList
	 */
	public ArrayList<FootballData> parseContentfromCSV(String fileName) {
		// TODO Auto-generated method stub

		CSVDataReader csvReader = new CSVDataReader();
		ArrayList<String[]> fileContents = csvReader.readContents(fileName);
		ArrayList<FootballData> contents = new ArrayList<FootballData>();
		for (int i = 0; i < fileContents.size(); i++) {
			FootballData fd = new FootballData(fileContents.get(i)[0],
					Integer.parseInt(fileContents.get(i)[1]),
					Integer.parseInt(fileContents.get(i)[2]),
					Integer.parseInt(fileContents.get(i)[3]),
					Integer.parseInt(fileContents.get(i)[4]),
					Integer.parseInt(fileContents.get(i)[5]),
					Integer.parseInt(fileContents.get(i)[6]),
					Integer.parseInt(fileContents.get(i)[7]));
			contents.add(fd);
		}
		return contents;
	}
	
	/**
	 * finds distance (absolute difference) between ‘Goals’ and ‘Goals Allowed’.
	 * This is an overloaded function.
	 * @param contents
	 * @return arraylist containing difference Goals and Goals Allowed 
	 */
	public ArrayList<Integer> findDiffrOfCols(
			ArrayList<FootballData> contents) {
		ArrayList<Integer> smallestDist = new ArrayList<Integer>();
		
		for (FootballData fd : contents) {
			smallestDist.add(Math.abs(fd.getGoals() - fd.getGoalsAllowed()));
		}
		return smallestDist;
	}
	

}
